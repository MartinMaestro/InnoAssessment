package es.upm.miw.innoassessment.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import es.upm.miw.innoassessment.business.controllers.AssessmentLineController;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
@SessionAttributes("name")
public class Presenter {
	
	@Autowired
    private AssessmentLineController assessmentLineController;

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

}
