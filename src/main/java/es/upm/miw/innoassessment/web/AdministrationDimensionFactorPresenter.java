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
public class AdministrationDimensionFactorPresenter {
	static final String PATH = "jsp/administration/dimension-factor";
	@Autowired
	private DimensionController dimensionController;

	@Autowired
	private FactorController factorController;

	@RequestMapping("/administration/list-dimension")
	public ModelAndView listDimension(Model model) {
		ModelAndView modelAndView = new ModelAndView(PATH + "/administrationDimensionList");
		modelAndView.addObject("dimensionList", dimensionController.showDimensions());
		return modelAndView;
	}

	@RequestMapping("/administration/list-factor")
	public ModelAndView listFactor(Model model) {
		ModelAndView modelAndView = new ModelAndView(PATH + "/administrationFactorList");
		modelAndView.addObject("factorList", factorController.showFactors());
		return modelAndView;
	}

	@RequestMapping(value = "/administration/create-dimension", method = RequestMethod.GET)
	public String createDimension(Model model) {
		model.addAttribute("dimension", new DimensionWrapper());
		return PATH + "/administrationDimensionCreate";
	}

	@RequestMapping(value = "/administration/create-dimension", method = RequestMethod.POST)
	public String createDimensionSubmit(@Valid DimensionWrapper dimension, BindingResult bindingResult, Model model) {
		if (!bindingResult.hasErrors()) {
			if (dimensionController.createDimension(dimension.getName())) {
				model.addAttribute("dimensionList", dimensionController.showDimensions());
				return PATH + "/administrationDimensionList";
			} else {
				model.addAttribute("dimension", dimension);
				bindingResult.rejectValue("name", "error.dimension", "Exist dimension");
			}
		}
		return PATH + "/administrationDimensionCreate";
	}

	@RequestMapping(value = "/administration/create-factor", method = RequestMethod.GET)
	public String createFactor(Model model) {
		model.addAttribute("factor", new FactorWrapper());
		return PATH + "/administrationFactorCreate";
	}

	@RequestMapping(value = "/administration/create-factor", method = RequestMethod.POST)
	public String createFactorSubmit(@Valid FactorWrapper factor, BindingResult bindingResult, Model model) {
		if (!bindingResult.hasErrors()) {
			if (factorController.createFactor(factor.getName(), factor.getDefinition())) {
				model.addAttribute("factorList", factorController.showFactors());
				return PATH + "/administrationFactorList";
			} else {
				model.addAttribute("factor", factor);
				bindingResult.rejectValue("name", "error.factor", "Exist factor");
			}
		}
		return PATH + "/administrationFactorCreate";
	}

	@RequestMapping(value = { "/administration/delete-dimension/{id}" })
	public String deleteDimension(@PathVariable int id, Model model) {
		dimensionController.deleteDimension(id);
		model.addAttribute("dimensionList", dimensionController.showDimensions());
		return PATH + "/administrationDimensionList";
	}

	@RequestMapping(value = { "/administration/delete-factor/{id}" })
	public String deleteFactor(@PathVariable int id, Model model) {
		factorController.deleteFactor(id);
		model.addAttribute("factorList", factorController.showFactors());
		return PATH + "/administrationFactorList";
	}
}
