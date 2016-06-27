package es.upm.miw.innoassessment.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import es.upm.miw.innoassessment.business.controllers.DimensionController;
import es.upm.miw.innoassessment.business.controllers.FactorController;
import es.upm.miw.innoassessment.business.wrapper.DimensionWrapper;
import es.upm.miw.innoassessment.business.wrapper.FactorWrapper;
import javax.validation.Valid;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
@SessionAttributes("name")
public class AdministrationDimensionFactorPresenter {

	@Autowired
	private DimensionController dimensionController;

	@Autowired
	private FactorController factorController;

	@RequestMapping("/administration-list-dimension")
	public ModelAndView listDimension(Model model) {
		ModelAndView modelAndView = new ModelAndView("jsp/administration/administrationDimensionList");
		modelAndView.addObject("dimensionList", dimensionController.showDimensions());
		return modelAndView;
	}
	
	@RequestMapping("/administration-list-factor")
	public ModelAndView listFactor(Model model) {
		ModelAndView modelAndView = new ModelAndView("jsp/administration/administrationFactorList");
		modelAndView.addObject("factorList", factorController.showFactors());
		return modelAndView;
	}

	@RequestMapping(value = "/administration-create-dimension", method = RequestMethod.GET)
	public String createDimension(Model model) {
		model.addAttribute("dimension", new DimensionWrapper());
		return "jsp/administration/administrationDimensionCreate";
	}

	@RequestMapping(value = "/administration-create-dimension", method = RequestMethod.POST)
	public String createDimensionSubmit(@Valid DimensionWrapper dimension, BindingResult bindingResult, Model model) {
		if (!bindingResult.hasErrors()) {
			if (dimensionController.createDimension(dimension.getName())) {
				model.addAttribute("dimensionList", dimensionController.showDimensions());				
				return "jsp/administration/administrationDimensionList";
			} else {
				bindingResult.rejectValue("name", "error.dimension", "Dimension ya existente");
			}
		}
		return "jsp/administration/administrationDimensionCreate";
	}

	@RequestMapping(value = "/administration-create-factor", method = RequestMethod.GET)
	public String createFactor(Model model) {
		model.addAttribute("factor", new FactorWrapper());
		return "jsp/administration/administrationFactorCreate";
	}

	@RequestMapping(value = "/administration-create-factor", method = RequestMethod.POST)
	public String createFactorSubmit(@Valid FactorWrapper factor, BindingResult bindingResult, Model model) {
		if (!bindingResult.hasErrors()) {
			if (factorController.createFactor(factor.getName(), factor.getDefinition())) {
				model.addAttribute("name", factor.getName());
				model.addAttribute("definition", factor.getDefinition());
				model.addAttribute("id", factor.getId());
				return "jsp/administration/administrationFactorList";				
			} else {
				bindingResult.rejectValue("name", "error.factor", "Exist factor");
			}
		}
		return "jsp/administration/factorCreate";
	}

	@RequestMapping(value = { "/administration-delete-dimension/{id}" })
	public String deleteDimension(@PathVariable int id, Model model) {
		dimensionController.deleteDimension(id);
		model.addAttribute("dimensionList", dimensionController.showDimensions());
		return "jsp/administration/administrationDimensionList";
	}

	@RequestMapping(value = { "/administration-delete-factor/{id}" })
	public String deleteFactor(@PathVariable int id, Model model) {
		factorController.deleteFactor(id);
		model.addAttribute("factorList", factorController.showFactors());
		return "jsp/administration/administrationFactorList";
	}
}
