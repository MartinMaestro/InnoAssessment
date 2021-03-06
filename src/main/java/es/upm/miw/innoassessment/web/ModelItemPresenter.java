package es.upm.miw.innoassessment.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import es.upm.miw.innoassessment.business.controllers.DimensionController;
import es.upm.miw.innoassessment.business.controllers.FactorController;
import es.upm.miw.innoassessment.business.controllers.ModelController;
import es.upm.miw.innoassessment.business.controllers.ModelItemController;
import es.upm.miw.innoassessment.business.wrapper.DimensionWrapper;
import es.upm.miw.innoassessment.business.wrapper.FactorWrapper;
import es.upm.miw.innoassessment.business.wrapper.ListFactor;
import es.upm.miw.innoassessment.business.wrapper.ListModelItem;
import es.upm.miw.innoassessment.business.wrapper.ModelItemWrapper;
import es.upm.miw.innoassessment.business.wrapper.ModelWrapper;
import java.util.ArrayList;
import java.util.List;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
@SessionAttributes("name")
public class ModelItemPresenter {

	@Autowired
	private DimensionController dimensionController;

	@Autowired
	private FactorController factorController;

	@Autowired
	private ModelController modelController;

	@Autowired
	private ModelItemController modelItemController;

	@RequestMapping("/model-select")
	public ModelAndView listModelDimension(Model model,
			@RequestParam(value = "modelId", required = false, defaultValue = "0") int modelId) {
		ModelAndView modelAndView = new ModelAndView("jsp/list/selectModel");
		modelAndView.addObject("modelList", modelController.showModels());
		return modelAndView;
	}

	@RequestMapping(value = "/factor-select/{modelid}")
	public ModelAndView listFactor(Model model, @PathVariable int modelid) {
		ModelAndView modelAndView = new ModelAndView("jsp/model-modelItems/factorList");
		modelAndView.addObject("model", modelid);
		modelAndView.addObject("factorList", factorController.showFactors());
		ListFactor listFactor = new ListFactor();
		listFactor.setFactorList(factorController.showFactors());
		modelAndView.addObject("listFactor", listFactor);
		return modelAndView;
	}

	@RequestMapping(value = { "/factor-select/{modelid}" }, method = RequestMethod.POST)
	public String listFactorSubmit(Model model, @PathVariable int modelid,
			@ModelAttribute("listFactor") ListFactor listFactor) {
		ModelAndView modelAndView = new ModelAndView("jsp/model-modelItems/factorList");
		modelAndView.addObject("factorList", factorController.showFactors());
		for (FactorWrapper factor : listFactor.getFactorList()) {
			System.out.println("FACTORS: " + factor.getId() + " - " + factor.getRadioValue());
		}
		return "jsp/model-modelItems/modelItemsCreate";
	}

	/*
	@RequestMapping(value = "/create-model", method = RequestMethod.GET)
	public String createModel(Model model) {
		model.addAttribute("model", new ModelWrapper());
		return "jsp/model-modelItems/modelCreate";
	}

	@RequestMapping(value = "/create-model", method = RequestMethod.POST)
	public String createModelSubmit(@Valid ModelWrapper modelw, BindingResult bindingResult, Model model) {
		if (!bindingResult.hasErrors()) {
			if (modelController.createModel(modelw.getName(), modelw.getYear(), modelw.getVersion(),
					modelw.getDescription())) {
				model.addAttribute("name", modelw.getName());
				model.addAttribute("year", modelw.getYear());
				model.addAttribute("version", modelw.getVersion());
				model.addAttribute("description", modelw.getDescription());
				model.addAttribute("id", modelw.getId());
				return "jsp/registrationSuccess";
			} else {
				bindingResult.rejectValue("name", "error.model", "Model ya existente");
			}
		}
		return "jsp/model-modelItems/createModel";
	}

	@RequestMapping(value = "/create-modelItem", method = RequestMethod.GET)
	public String createModelItem(Model model) {
		model.addAttribute("modelList", modelController.showModels());
		model.addAttribute("modelItem", new ModelItemWrapper());
		model.addAttribute("impactValuesList", modelItemController.showAssessmentTypes());
		model.addAttribute("dimensionList", dimensionController.showDimensions());
		model.addAttribute("factorList", factorController.showFactors());
		return "jsp/model-modelItems/modelItemsCreate";
	}

	@RequestMapping(value = "/create-modelItem", method = RequestMethod.POST)
	public String createModelItemSubmit(@Valid ModelItemWrapper modelItem, BindingResult bindingResult, Model model) {
		if (!bindingResult.hasErrors()) {
			if (modelItemController.createModelItem(modelItem.getModelId(), modelItem.getDimensionId(),
					modelItem.getFactorId(), modelItem.getImpact(), modelItem.getWeight(),
					modelItem.getInterpretation(), modelItem.getHelp())) {
				return "jsp/home";
			} else {
				bindingResult.rejectValue("name", "error.model", "Model ya existente");
			}
		}
		return "jsp/model-modelItems/modelItemCreate";
	}
*/
	@RequestMapping(value = "/create-modelItems/{modelid}", method = RequestMethod.GET)
	public ModelAndView createModelItems(Model model, @PathVariable int modelid,
			@RequestParam(value = "dimensionid", required = false, defaultValue = "0") int dimensionid) {
		ModelAndView modelAndView = new ModelAndView("jsp/model-modelItems/modelItemsCreate");
		modelAndView.addObject("model", modelController.showModel(modelid));
		if (dimensionid != 0) {
			modelAndView.addObject("dimensionDetail", dimensionController.showDimension(dimensionid));
		} else {
			modelAndView.addObject("dimensionList", dimensionController.showDimensions());
		}
		ListFactor listFactor = new ListFactor();
		listFactor.setFactorList(factorController.showFactors());
		modelAndView.addObject("listFactor", listFactor);
		return modelAndView;
	}

	@RequestMapping(value = { "/create-modelItems/{modelid}/dimension/{dimensionid}" }, method = RequestMethod.POST)
	public ModelAndView createModelItemsSubmit(Model model, @PathVariable int modelid, @PathVariable int dimensionid,
			@ModelAttribute("listFactor") ListFactor listFactor) {
		ModelAndView modelAndView = new ModelAndView("jsp/model-modelItems/modelItemsCreateConfirm");
		ModelWrapper modelw = modelController.showModel(modelid);
		modelAndView.addObject("model", modelw);
		DimensionWrapper dimensionw = dimensionController.showDimension(dimensionid);
		modelAndView.addObject("dimensionDetail", dimensionw);
		List<FactorWrapper> listFactorFinal = new ArrayList<>();
		List<ModelItemWrapper> listModelItemWrapper = new ArrayList<>();
		ModelItemWrapper modelItem;
		for (FactorWrapper factor : listFactor.getFactorList()) {
			if (factor.getRadioValue() != null) {
				listFactorFinal.add(factor);
				modelItem = new ModelItemWrapper(modelid, modelw.getName(), dimensionid, dimensionw.getName(),
						factor.getId(), factor.getName(), null, null, factor.getName(), factor.getDefinition());
				listModelItemWrapper.add(modelItem);
			}
		}
		modelAndView.addObject("factorList", listFactorFinal);
		ListModelItem listModelItem = new ListModelItem();
		listModelItem.setModelItemList(listModelItemWrapper);
		modelAndView.addObject("listModelItem", listModelItem);
		return modelAndView;
	}

	@RequestMapping(value = { "/create-modelItemsExecute" }, method = RequestMethod.POST)
	public ModelAndView createModelItemsExecute(Model model,
			@ModelAttribute("listModelItem") ListModelItem listModelItem) {
		for (ModelItemWrapper modelItem : listModelItem.getModelItemList()) {
			modelItemController.createModelItem(modelItem.getModelId(), modelItem.getDimensionId(),
					modelItem.getFactorId(), modelItem.getImpact(), modelItem.getWeight(),
					modelItem.getInterpretation(), modelItem.getHelp());
		}
		ModelAndView modelAndView = new ModelAndView("jsp/model-modelItems/modelItemList");
		modelAndView.addObject("modelItemList", modelItemController.showModelItemsOrderByIdDesc());
		return modelAndView;
	}

	@RequestMapping("/model-list")
	public ModelAndView listModel(Model model) {
		ModelAndView modelAndView = new ModelAndView("jsp/model-modelItems/modelList");
		modelAndView.addObject("modelList", modelController.showModels());
		return modelAndView;
	}

	@RequestMapping("/modelitem-list")
	public ModelAndView listModelItem(Model model) {
		ModelAndView modelAndView = new ModelAndView("jsp/model-modelItems/modelItemList");
		modelAndView.addObject("modelItemList", modelItemController.showModelItems());
		return modelAndView;
	}

	@RequestMapping(value = { "/delete-model/{id}" })
	public String deleteModel(@PathVariable int id, Model model) {
		modelController.deleteModel(id);
		model.addAttribute("modelList", modelController.showModels());
		return "jsp/model-modelItems/modelList";
	}

}
