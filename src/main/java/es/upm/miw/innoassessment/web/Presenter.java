package es.upm.miw.innoassessment.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import es.upm.miw.innoassessment.business.controllers.AssessmentLineController;
import es.upm.miw.innoassessment.business.controllers.DimensionController;
import es.upm.miw.innoassessment.business.wrapper.DimensionWrapper;
import es.upm.miw.innoassessment.data.entities.Dimension;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
@SessionAttributes("name")
public class Presenter {
	
	@Autowired
    private AssessmentLineController assessmentLineController;
	
	@Autowired
    private DimensionController dimensionController;

    // Se ejecuta siempre y antes. Añade un atributo al Model
    @ModelAttribute("now")
    public String now() {
        return new SimpleDateFormat("EEEE, d MMM yyyy HH:mm:ss").format(new Date());
    }

    @RequestMapping("/home")
    public String home(Model model) {
        //La vista resultante no lleva extensión (.jsp) configurado en WebConfig.java
        return "jsp/home";
    }
    
    @RequestMapping("/assessmentLine-list")
    public ModelAndView listAssessmentLines(Model model) {
        ModelAndView modelAndView = new ModelAndView("jsp/assessmentLineList");
        modelAndView.addObject("assessmentLine", assessmentLineController.showAssessmentLines());
        return modelAndView;
    }
    
    @RequestMapping("/dimension-list")
    public ModelAndView listDimension(Model model) {
        ModelAndView modelAndView = new ModelAndView("jsp/dimensionList");
        modelAndView.addObject("dimensionList", dimensionController.showDimensions());
        return modelAndView;
    }
    
    @RequestMapping(value = "/create-dimension", method = RequestMethod.GET)
    public String createDimension(Model model) {    	
       	model.addAttribute("dimension", new DimensionWrapper());     
        return "jsp/createDimension";
    }

    @RequestMapping(value = "/create-dimension", method = RequestMethod.POST)
    public String createDimensionSubmit(@Valid DimensionWrapper dimension, BindingResult bindingResult, Model model) {
    	if (!bindingResult.hasErrors()) {
            if (dimensionController.createDimension(dimension.getName())) {
            	System.out.println("------------ CREATE DIMENSION SUBMIT ID:" +  dimension.getId()+"-NAME:"+dimension.getName());
            	model.addAttribute("name", dimension.getName());
            	model.addAttribute("id", dimension.getId());
                return "jsp/registrationSuccess";
            } else {
                bindingResult.rejectValue("name", "error.dimension", "Dimension ya existente");
            }
        }
        return "jsp/createDimension";
    }

    @RequestMapping(value = {"/delete-dimension/{id}"})
    public String deleteDimension(@PathVariable int id, Model model) {
        dimensionController.deleteDimension(id);
        model.addAttribute("dimensionList", dimensionController.showDimensions());
        return "jsp/dimensionList";
    }

}
