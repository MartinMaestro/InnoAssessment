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
import es.upm.miw.innoassessment.business.wrapper.AssessmentLineWrapper;
import es.upm.miw.innoassessment.business.wrapper.DimensionWrapper;
import es.upm.miw.innoassessment.business.wrapper.FactorWrapper;
import es.upm.miw.innoassessment.business.wrapper.ListAssessmentLine;
import es.upm.miw.innoassessment.business.wrapper.ListFactor;
import es.upm.miw.innoassessment.business.wrapper.ListModelItem;
import es.upm.miw.innoassessment.business.wrapper.ModelItemWrapper;
import es.upm.miw.innoassessment.business.wrapper.ModelWrapper;
import es.upm.miw.innoassessment.business.wrapper.ProductVersionWrapper;
import es.upm.miw.innoassessment.business.wrapper.ProductWrapper;
import es.upm.miw.innoassessment.business.wrapper.QuestionnaireWrapper;
import es.upm.miw.innoassessment.data.entities.AssessmentType;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
@SessionAttributes("name")
public class QuestionnairePresenter {

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

	@RequestMapping("/modelq-select")
	public ModelAndView listModel(Model model,
			@RequestParam(value = "modelId", required = false, defaultValue = "0") int modelId) {
		ModelAndView modelAndView = new ModelAndView("jsp/questionnaire/selectModelq");
		modelAndView.addObject("modelList", modelController.showModels());
		return modelAndView;
	}

	@RequestMapping("/questionnaire-select")
	public ModelAndView listQuestionnaire(Model model,
			@RequestParam(value = "questionnaireId", required = false, defaultValue = "0") int questionnaireId) {
		ModelAndView modelAndView = new ModelAndView("jsp/questionnaire/selectQuestionnaire");
		modelAndView.addObject("questionnaireList", questionnaireController.showQuestionnaires());
		return modelAndView;
	}

	@RequestMapping(value = "/create-questionnaire/{modelid}", method = RequestMethod.GET)
	public ModelAndView createQuestionnaire(Model model, @PathVariable int modelid) {
		ModelAndView modelAndView = new ModelAndView("jsp/questionnaire/questionnaireCreate");
		modelAndView.addObject("model", modelController.showModel(modelid));
		modelAndView.addObject("questionnaire", new QuestionnaireWrapper());
		return modelAndView;
	}

	@RequestMapping(value = "/create-questionnaire/{modelid}", method = RequestMethod.POST)
	public ModelAndView createQuestionnaireSubmit(@Valid QuestionnaireWrapper questionnaire,
			BindingResult bindingResult, Model model, @PathVariable int modelid) {
		if (!bindingResult.hasErrors()) {
			questionnaireController.createQuestionnaire(questionnaire.getName(), questionnaire.getVersion(), modelid);
		} else {
			bindingResult.rejectValue("name", "error.questionnaire", "Questionnaire exist");
		}
		ModelAndView modelAndView = new ModelAndView("jsp/questionnaire/questionnaireList");
		modelAndView.addObject("questionnaireList", questionnaireController.showQuestionnaires());
		return modelAndView;
	}

	@RequestMapping(value = "/create-assessments/{questionnaireid}", method = RequestMethod.GET)
	public ModelAndView createAssessments(Model model, @PathVariable int questionnaireid) {
		ModelAndView modelAndView = new ModelAndView("jsp/questionnaire/assessmentsCreate");
		modelAndView.addObject("questionnaire", questionnaireController.showQuestionnaire(questionnaireid));
		ListModelItem listModelItem = new ListModelItem();
		listModelItem.setModelItemList(modelItemController.showModelItems());
		modelAndView.addObject("listModelItem", listModelItem);
		return modelAndView;
	}

	@RequestMapping(value = "/create-assessments/{questionnaireid}", method = RequestMethod.POST)
	public ModelAndView createAssessmentsSubmit(Model model, @PathVariable int questionnaireid,
			@ModelAttribute("listModelItem") ListModelItem listModelItem) {

		for (ModelItemWrapper modelItem : listModelItem.getModelItemList()) {
			if (modelItem.getRadioValue() != null) {
				System.out.println("Questionnaire Presenter: impact " + modelItem.getImpact());
				System.out
						.println("Questionnaire Presenter: impact " + AssessmentType.getByName(modelItem.getImpact()));

				assessmentLineController.createAssessmentLine(questionnaireid, modelItem.getId(),
						modelItem.getImpact());
			}
		}
		ModelAndView modelAndView = new ModelAndView("jsp/questionnaire/assessmentLineList");
		modelAndView.addObject("assessmentLineList", assessmentLineController.showAssessmentLines());
		return modelAndView;
	}

	@RequestMapping(value = { "/delete-questionnaire/{id}" })
	public ModelAndView deleteQuestionnaire(@PathVariable int id, Model model) {
		questionnaireController.deleteQuestionnaire(id);
		ModelAndView modelAndView = new ModelAndView("jsp/questionnaire/questionnaireList");
		modelAndView.addObject("questionnaireList", questionnaireController.showQuestionnaires());
		return modelAndView;
	}

	/*
	 * 
	 * @RequestMapping(value = "/create-model", method = RequestMethod.GET)
	 * public String createModel(Model model) { model.addAttribute("model", new
	 * ModelWrapper()); return "jsp/model-modelItems/modelCreate"; }
	 * 
	 * @RequestMapping(value = "/create-model", method = RequestMethod.POST)
	 * public String createModelSubmit(@Valid ModelWrapper modelw, BindingResult
	 * bindingResult, Model model) { if (!bindingResult.hasErrors()) { if
	 * (modelController.createModel(modelw.getName(), modelw.getYear(),
	 * modelw.getVersion(), modelw.getDescription())) {
	 * model.addAttribute("name", modelw.getName()); model.addAttribute("year",
	 * modelw.getYear()); model.addAttribute("version", modelw.getVersion());
	 * model.addAttribute("description", modelw.getDescription());
	 * model.addAttribute("id", modelw.getId()); return
	 * "jsp/registrationSuccess"; } else { bindingResult.rejectValue("name",
	 * "error.model", "Model ya existente"); } } return
	 * "jsp/model-modelItems/createModel"; }
	 * 
	 * @RequestMapping(value = "/create-modelItem", method = RequestMethod.GET)
	 * public String createModelItem(Model model) {
	 * model.addAttribute("modelList", modelController.showModels());
	 * model.addAttribute("modelItem", new ModelItemWrapper());
	 * model.addAttribute("impactValuesList",
	 * modelItemController.showAssessmentTypes());
	 * 
	 * model.addAttribute("dimensionList",
	 * dimensionController.showDimensions()); model.addAttribute("factorList",
	 * factorController.showFactors()); return
	 * "jsp/model-modelItems/modelItemsCreate"; }
	 * 
	 * @RequestMapping(value = "/create-modelItem", method = RequestMethod.POST)
	 * public String createModelItemSubmit(@Valid ModelItemWrapper modelItem,
	 * BindingResult bindingResult, Model model) { if
	 * (!bindingResult.hasErrors()) { if
	 * (modelItemController.createModelItem(modelItem.getModelId(),
	 * modelItem.getDimensionId(), modelItem.getFactorId(),
	 * modelItem.getImpact(), modelItem.getWeight(),
	 * modelItem.getInterpretation(), modelItem.getHelp())) { return "jsp/home";
	 * } else { bindingResult.rejectValue("name", "error.model",
	 * "Model ya existente"); } } return "jsp/model-modelItems/modelItemCreate";
	 * }
	 * 
	 * 
	 * 
	 * @RequestMapping(value = {
	 * "/create-modelItems/{modelid}/dimension/{dimensionid}" }, method =
	 * RequestMethod.POST) public ModelAndView createModelItemsSubmit(Model
	 * model, @PathVariable int modelid, @PathVariable int dimensionid,
	 * 
	 * @ModelAttribute("listFactor") ListFactor listFactor) {
	 * System.out.println(" createModelItemsSubmit - POST : " + modelid + " - "
	 * + dimensionid); ModelAndView modelAndView = new
	 * ModelAndView("jsp/model-modelItems/modelItemsCreateConfirm");
	 * ModelWrapper modelw = modelController.showModel(modelid);
	 * modelAndView.addObject("model", modelw); DimensionWrapper dimensionw =
	 * dimensionController.showDimension(dimensionid);
	 * modelAndView.addObject("dimensionDetail", dimensionw);
	 * List<FactorWrapper> listFactorFinal = new ArrayList<>();
	 * List<ModelItemWrapper> listModelItemWrapper = new ArrayList<>();
	 * ModelItemWrapper modelItem; for (FactorWrapper factor :
	 * listFactor.getFactorList()) { if (factor.getRadioValue() != null) {
	 * listFactorFinal.add(factor); //modelItem = new
	 * ModelItemWrapper(modelid,dimensionid, factor.getId(), null, null,
	 * factor.getName(),factor.getDefinition()); modelItem = new
	 * ModelItemWrapper(modelid,modelw.getName(),dimensionid,
	 * dimensionw.getName(), factor.getId(),factor.getName(), null, null,
	 * factor.getName(),factor.getDefinition());
	 * listModelItemWrapper.add(modelItem); } }
	 * modelAndView.addObject("factorList",listFactorFinal); ListModelItem
	 * listModelItem = new ListModelItem();
	 * listModelItem.setModelItemList(listModelItemWrapper);
	 * modelAndView.addObject("listModelItem", listModelItem); return
	 * modelAndView; }
	 * 
	 * 
	 * @RequestMapping(value = { "/create-modelItemsExecute" }, method =
	 * RequestMethod.POST) public ModelAndView createModelItemsExecute(Model
	 * model,@ModelAttribute("listModelItem") ListModelItem listModelItem ) {
	 * //ModelAndView modelAndView = new
	 * ModelAndView("jsp/model-modelItems/modelItemsCreateConfirm");
	 * 
	 * for (ModelItemWrapper modelItem : listModelItem.getModelItemList()) {
	 * modelItemController.createModelItem(modelItem.getModelId(),
	 * modelItem.getDimensionId(),modelItem.getFactorId(),modelItem.getImpact(),
	 * modelItem.getWeight(),modelItem.getInterpretation(),
	 * modelItem.getHelp()); System.out.println(
	 * " CREATE MODEL ITEM: dimensionID: " + modelItem.getDimensionId() +
	 * " - WEIGHT: " + modelItem.getWeight() +" - HELP" + modelItem.getHelp() +
	 * "- INTERPRETATION: " +modelItem.getInterpretation() ); } ModelAndView
	 * modelAndView = new ModelAndView("jsp/model-modelItems/modelItemList");
	 * modelAndView.addObject("modelItemList",
	 * modelItemController.showModelItemsOrderByIdDesc()); return modelAndView;
	 * }
	 * 
	 * 
	 * @RequestMapping("/model-list") public ModelAndView listModel(Model model)
	 * { ModelAndView modelAndView = new
	 * ModelAndView("jsp/model-modelItems/modelList");
	 * modelAndView.addObject("modelList", modelController.showModels()); return
	 * modelAndView; }
	 * 
	 * @RequestMapping("/modelitem-list") public ModelAndView
	 * listModelItem(Model model) { ModelAndView modelAndView = new
	 * ModelAndView("jsp/model-modelItems/modelItemList");
	 * modelAndView.addObject("modelItemList",
	 * modelItemController.showModelItems()); //
	 * modelAndView.addObject("modelItemList", //
	 * modelItemController.showModelItemsByModelAndDimension(1, 1)); return
	 * modelAndView; }
	 * 
	 * @RequestMapping(value = { "/delete-model/{id}" }) public String
	 * deleteModel(@PathVariable int id, Model model) {
	 * modelController.deleteModel(id); model.addAttribute("modelList",
	 * modelController.showModels()); return "jsp/model-modelItems/modelList"; }
	 */
}
