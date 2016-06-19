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
import es.upm.miw.innoassessment.business.controllers.FactorController;
import es.upm.miw.innoassessment.business.controllers.ModelController;
import es.upm.miw.innoassessment.business.controllers.ModelItemController;
import es.upm.miw.innoassessment.business.controllers.ProductController;
import es.upm.miw.innoassessment.business.controllers.ProductVersionController;
import es.upm.miw.innoassessment.business.controllers.QuestionnaireController;
import es.upm.miw.innoassessment.business.wrapper.DimensionWrapper;
import es.upm.miw.innoassessment.business.wrapper.ListAssessmentLine;
import es.upm.miw.innoassessment.business.wrapper.ListFactor;
import es.upm.miw.innoassessment.business.wrapper.ModelItemWrapper;
import es.upm.miw.innoassessment.business.wrapper.ModelWrapper;
import es.upm.miw.innoassessment.business.wrapper.ProductVersionWrapper;
import es.upm.miw.innoassessment.business.wrapper.ProductWrapper;
import es.upm.miw.innoassessment.business.wrapper.QuestionnaireWrapper;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.Valid;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
@SessionAttributes("name")
public class ModelItemPresenter {

	@Autowired
	private AssessmentLineController assessmentLineController;

	@Autowired
	private DimensionController dimensionController;

	@Autowired
	private FactorController factorController;

	@Autowired
	private ProductController productController;

	@Autowired
	private ProductVersionController productVersionController;

	@Autowired
	private ModelController modelController;

	@Autowired
	private ModelItemController modelItemController;

	@Autowired
	private QuestionnaireController questionnaireController;

	
	@RequestMapping("/model-select")
	public ModelAndView listModelDimension(Model model,
			@RequestParam(value = "modelId", required = false, defaultValue = "0") int modelId) {
		ModelAndView modelAndView = new ModelAndView("jsp/list/selectModel");
		modelAndView.addObject("modelList", modelController.showModels());		
		return modelAndView;
	}
		
	@RequestMapping("/factor-select/{modelid}")
	public ModelAndView listFactor(Model model,@PathVariable int modelid) {
		ModelAndView modelAndView = new ModelAndView("jsp/model-modelItems/factorList");
		modelAndView.addObject("model", modelid);
		modelAndView.addObject("factorList", factorController.showFactors());
		
		ListFactor listFactor = new ListFactor();
		listFactor.setFactorList(factorController.showFactors());
		modelAndView.addObject("listFactor", listFactor);
		
		return modelAndView;
	}
	
	@RequestMapping(value={"/factor-select/{modelid}"}, method = RequestMethod.POST)
	public String listFactorSubmit(Model model,@PathVariable int modelid
			,@ModelAttribute("listAssessmentLine") ListAssessmentLine listAssessmentLine) {
		System.out.println("---- LIST FACTOR SUBMIT - MODELID: " + modelid);
		ModelAndView modelAndView = new ModelAndView("jsp/model-modelItems/factorList");
		modelAndView.addObject("factorList", factorController.showFactors());
		return "/innoassessment/factor-select/{modelid}"; 
	}
	
	

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
	
	
	@RequestMapping(value = "/create-modelItems/{modelid}", method = RequestMethod.GET)
	public String createModelItems(Model model, @PathVariable int modelid) {
		model.addAttribute("model", modelController.showModel(modelid));
		model.addAttribute("modelItem", new ModelItemWrapper());
		model.addAttribute("impactValuesList", modelItemController.showAssessmentTypes());
		model.addAttribute("dimensionList", dimensionController.showDimensions());
		model.addAttribute("factorList", factorController.showFactors());
		return "jsp/model-modelItems/modelItemsCreate";
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
		// modelAndView.addObject("modelItemList",
		// modelItemController.showModelItemsByModelAndDimension(1, 1));
		return modelAndView;
	}
	
	
	@RequestMapping(value = { "/delete-model/{id}" })
	public String deleteModel(@PathVariable int id, Model model) {
		modelController.deleteModel(id);
		model.addAttribute("modelList", modelController.showModels());
		return "jsp/model-modelItems/modelList";
	}

}
