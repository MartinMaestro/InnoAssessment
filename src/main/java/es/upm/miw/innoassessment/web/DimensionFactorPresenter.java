package es.upm.miw.innoassessment.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import es.upm.miw.innoassessment.business.api.exceptions.AlreadyExistDimensionException;
import es.upm.miw.innoassessment.business.controllers.DimensionController;
import es.upm.miw.innoassessment.business.controllers.FactorController;
import es.upm.miw.innoassessment.business.wrapper.DimensionWrapper;
import es.upm.miw.innoassessment.business.wrapper.FactorWrapper;
import javax.validation.Valid;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
@SessionAttributes("name")
public class DimensionFactorPresenter {

	@Autowired
	private DimensionController dimensionController;

	@Autowired
	private FactorController factorController;

	@RequestMapping("/dimension-list")
	public ModelAndView listDimension(Model model) {
		ModelAndView modelAndView = new ModelAndView("jsp/list/dimensionList");
		modelAndView.addObject("dimensionList", dimensionController.showDimensions());
		return modelAndView;
	}
	
	@RequestMapping("/factor-list")
	public ModelAndView listFactor(Model model) {
		ModelAndView modelAndView = new ModelAndView("jsp/list/factorList");
		System.out.println("prueba listFactor");
		modelAndView.addObject("factorList", factorController.showFactors());
		return modelAndView;
	}

	@RequestMapping(value = "/create-dimension", method = RequestMethod.GET)
	public String createDimension(Model model) {
		model.addAttribute("dimension", new DimensionWrapper());
		return "jsp/create/dimensionCreate";
	}

	@RequestMapping(value = "/create-dimension", method = RequestMethod.POST)
	public String createDimensionSubmit(@Valid DimensionWrapper dimension, BindingResult bindingResult, Model model)
			throws AlreadyExistDimensionException {
		if (!bindingResult.hasErrors()) {
			if (dimensionController.createDimension(dimension.getName())) {
				model.addAttribute("name", dimension.getName());
				model.addAttribute("id", dimension.getId());
				return "jsp/registrationSuccess";
			} else {
				bindingResult.rejectValue("name", "error.dimension", "Dimension ya existente");
			}
		}
		return "jsp/create/dimensionCreate";
	}

	@RequestMapping(value = "/create-factor", method = RequestMethod.GET)
	public String createFactor(Model model) {
		model.addAttribute("factor", new FactorWrapper());
		return "jsp/create/factorCreate";
	}

	@RequestMapping(value = "/create-factor", method = RequestMethod.POST)
	public String createFactorSubmit(@Valid FactorWrapper factor, BindingResult bindingResult, Model model) {
		if (!bindingResult.hasErrors()) {
			if (factorController.createFactor(factor.getName(), factor.getDefinition())) {
				model.addAttribute("name", factor.getName());
				model.addAttribute("definition", factor.getDefinition());
				model.addAttribute("id", factor.getId());
				return "jsp/list/factorList";				
			} else {
				bindingResult.rejectValue("name", "error.factor", "Exist factor");
			}
		}
		return "jsp/create/factorCreate";
	}

	@RequestMapping(value = { "/delete-dimension/{id}" })
	public String deleteDimension(@PathVariable int id, Model model) {
		dimensionController.deleteDimension(id);
		model.addAttribute("dimensionList", dimensionController.showDimensions());
		return "jsp/list/dimensionList";
	}

	@RequestMapping(value = { "/delete-factor/{id}" })
	public String deleteFactor(@PathVariable int id, Model model) {
		factorController.deleteFactor(id);
		model.addAttribute("factorList", factorController.showFactors());
		return "jsp/list/factorList";
	}
}
