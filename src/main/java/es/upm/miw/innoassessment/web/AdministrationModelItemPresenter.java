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

import javax.validation.Valid;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
@SessionAttributes("name")
public class AdministrationModelItemPresenter {

	@Autowired
	private DimensionController dimensionController;

	@Autowired
	private FactorController factorController;

	@Autowired
	private ModelController modelController;

	@Autowired
	private ModelItemController modelItemController;

	@RequestMapping("/administration-list-model")
	public ModelAndView listModel(Model model) {
		ModelAndView modelAndView = new ModelAndView("jsp/administration/administrationModelList");
		modelAndView.addObject("modelList", modelController.showModels());
		return modelAndView;
	}

	@RequestMapping("/administration-list-modelitem")
	public ModelAndView listModelItem(Model model) {
		ModelAndView modelAndView = new ModelAndView("jsp/administration/administrationModelItemList");
		modelAndView.addObject("modelItemList", modelItemController.showModelItems());
		return modelAndView;
	}

	@RequestMapping(value = "/administration-create-model", method = RequestMethod.GET)
	public String createModel(Model model) {
		model.addAttribute("model", new ModelWrapper());
		return "jsp/administration/administrationModelCreate";
	}

	@RequestMapping(value = "/administration-create-model", method = RequestMethod.POST)
	public String createModelSubmit(@Valid ModelWrapper modelw, BindingResult bindingResult, Model model) {
		if (!bindingResult.hasErrors()) {
			if (modelController.createModel(modelw.getName(), modelw.getYear(), modelw.getVersion(),
					modelw.getDescription())) {
				model.addAttribute("modelList", modelController.showModels());
				return "jsp/administration/administrationModelList";
			} else {
				bindingResult.rejectValue("name", "error.model", "Model ya existente");
			}
		}
		return "jsp/administration/administrationModelCreate";
	}

	@RequestMapping(value = "/administration-create-modelitem", method = RequestMethod.GET)
	public String createModelItem(Model model) {
		model.addAttribute("modelList", modelController.showModels());
		model.addAttribute("modelItem", new ModelItemWrapper());
		model.addAttribute("impactValuesList", modelItemController.showAssessmentTypes());
		model.addAttribute("dimensionList", dimensionController.showDimensions());
		model.addAttribute("factorList", factorController.showFactors());
		return "jsp/administration/administrationModelItemCreate";
	}

	@RequestMapping(value = "/administration-create-modelitem", method = RequestMethod.POST)
	public String createModelItemSubmit(@Valid ModelItemWrapper modelItem, BindingResult bindingResult, Model model) {
		if (!bindingResult.hasErrors()) {
			if (modelItemController.createModelItem(modelItem.getModelId(), modelItem.getDimensionId(),
					modelItem.getFactorId(), modelItem.getImpact(), modelItem.getWeight(),
					modelItem.getInterpretation(), modelItem.getHelp())) {
				model.addAttribute("modelItemList", modelItemController.showModelItemsOrderByIdDesc());
				return "jsp/administration/administrationModelItemList";
			} else {
				bindingResult.rejectValue("name", "error.model", "Model ya existente");
			}
		}
		return "jsp/administration/administrationModelItemCreate";
	}

	@RequestMapping("/administration-create-modelitems-select-model")
	public ModelAndView createModelItemsSelectModel(Model model,
			@RequestParam(value = "modelId", required = false, defaultValue = "0") int modelId) {
		ModelAndView modelAndView = new ModelAndView("jsp/administration/administrationCreateModelItemsSelectModel");
		modelAndView.addObject("modelList", modelController.showModels());
		return modelAndView;
	}

	@RequestMapping(value = "/administration-create-modelitems/{modelid}", method = RequestMethod.GET)
	public ModelAndView createModelItems(Model model, @PathVariable int modelid,
			@RequestParam(value = "dimensionid", required = false, defaultValue = "0") int dimensionid) {
		ModelAndView modelAndView = new ModelAndView("jsp/administration/administrationModelItemsCreate");
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

	@RequestMapping(value = {
			"/administration-create-modelitems/{modelid}/dimension/{dimensionid}" }, method = RequestMethod.POST)
	public ModelAndView createModelItemsSubmit(Model model, @PathVariable int modelid, @PathVariable int dimensionid,
			@ModelAttribute("listFactor") ListFactor listFactor) {
		ModelAndView modelAndView = new ModelAndView("jsp/administration/administrationModelItemsCreateConfirm");
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

	@RequestMapping(value = { "/administration-create-modelitems-confirm" }, method = RequestMethod.POST)
	public ModelAndView createModelItemsExecute(Model model,
			@ModelAttribute("listModelItem") ListModelItem listModelItem) {
		for (ModelItemWrapper modelItem : listModelItem.getModelItemList()) {
			modelItemController.createModelItem(modelItem.getModelId(), modelItem.getDimensionId(),
					modelItem.getFactorId(), modelItem.getImpact(), modelItem.getWeight(),
					modelItem.getInterpretation(), modelItem.getHelp());
		}
		ModelAndView modelAndView = new ModelAndView("jsp/administration/administrationModelItemList");
		modelAndView.addObject("modelItemList", modelItemController.showModelItemsOrderByIdDesc());
		return modelAndView;
	}	

	@RequestMapping(value = { "/administration-delete-model/{id}" })
	public String deleteModel(@PathVariable int id, Model model) {
		modelController.deleteModel(id);
		model.addAttribute("modelList", modelController.showModels());
		return "jsp/administration/administrationModelList";
	}

}
