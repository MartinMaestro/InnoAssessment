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
import es.upm.miw.innoassessment.business.controllers.ModelController;
import es.upm.miw.innoassessment.business.controllers.ModelItemController;
import es.upm.miw.innoassessment.business.controllers.QuestionnaireController;
import es.upm.miw.innoassessment.business.wrapper.ListModelItem;
import es.upm.miw.innoassessment.business.wrapper.ModelItemWrapper;
import es.upm.miw.innoassessment.business.wrapper.QuestionnaireWrapper;
import javax.validation.Valid;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
@SessionAttributes("name")
public class AdministrationQuestionnairePresenter {

	@Autowired
	private AssessmentLineController assessmentLineController;

	@Autowired
	private ModelController modelController;

	@Autowired
	private ModelItemController modelItemController;

	@Autowired
	private QuestionnaireController questionnaireController;


	@RequestMapping("/administration-list-questionnaire")
	public ModelAndView listQuestionnaire(Model model) {
		ModelAndView modelAndView = new ModelAndView("jsp/administration/administrationQuestionnaireList");
		modelAndView.addObject("questionnaireList", questionnaireController.showQuestionnaires());
		return modelAndView;
	}
	
	@RequestMapping("/administration-list-assessment")
	public ModelAndView listAssessmentLines(Model model) {
		ModelAndView modelAndView = new ModelAndView("jsp/administration/administrationAssessmentList");
		modelAndView.addObject("assessmentLineList", assessmentLineController.showAssessmentLines());
		return modelAndView;
	}
	
	@RequestMapping("/administration-create-questionnaire-select-model")
	public ModelAndView createQuestionnaireSelectModel(Model model,
			@RequestParam(value = "modelId", required = false, defaultValue = "0") int modelId) {
		ModelAndView modelAndView = new ModelAndView("jsp/administration/administrationQuestionnaireCreateSelectModel");
		modelAndView.addObject("modelList", modelController.showModels());
		return modelAndView;
	}
	
	@RequestMapping(value = "/administration-create-questionnaire/{modelid}", method = RequestMethod.GET)
	public ModelAndView createQuestionnaire(Model model, @PathVariable int modelid) {
		ModelAndView modelAndView = new ModelAndView("jsp/administration/administrationQuestionnaireCreate");
		modelAndView.addObject("model", modelController.showModel(modelid));
		modelAndView.addObject("questionnaire", new QuestionnaireWrapper());
		return modelAndView;
	}

	@RequestMapping(value = "/administration-create-questionnaire/{modelid}", method = RequestMethod.POST)
	public ModelAndView createQuestionnaireSubmit(@Valid QuestionnaireWrapper questionnaire,
			BindingResult bindingResult, Model model, @PathVariable int modelid) {
		if (!bindingResult.hasErrors()) {
			questionnaireController.createQuestionnaire(questionnaire.getName(), questionnaire.getVersion(), modelid);
		} else {
			bindingResult.rejectValue("name", "error.questionnaire", "Questionnaire exist");
		}
		ModelAndView modelAndView = new ModelAndView("jsp/administration/administrationQuestionnaireList");
		modelAndView.addObject("questionnaireList", questionnaireController.showQuestionnaires());
		return modelAndView;
	}
	
	@RequestMapping(value = { "/administration-delete-questionnaire/{id}" })
	public String deleteQuestionnaire(@PathVariable int id, Model model) {
		questionnaireController.deleteQuestionnaire(id);
		model.addAttribute("questionnaireList", questionnaireController.showQuestionnaires());
		return "jsp/administration/administrationQuestionnaireList";
	}
	
	
	@RequestMapping("/administration-create-assessment-select-questionnaire")
	public ModelAndView listQuestionnaire(Model model,
			@RequestParam(value = "questionnaireId", required = false, defaultValue = "0") int questionnaireId) {
		ModelAndView modelAndView = new ModelAndView("jsp/administration/administrationAssessmentsCreateSelectQuestionnaire");
		modelAndView.addObject("questionnaireList", questionnaireController.showQuestionnaires());
		return modelAndView;
	}
	
	@RequestMapping(value = "/administration-create-assessments/{questionnaireid}", method = RequestMethod.GET)
	public ModelAndView createAssessments(Model model, @PathVariable int questionnaireid) {
		ModelAndView modelAndView = new ModelAndView("jsp/administration/administrationAssessmentCreate");
		modelAndView.addObject("questionnaire", questionnaireController.showQuestionnaire(questionnaireid));
		ListModelItem listModelItem = new ListModelItem();
		listModelItem.setModelItemList(modelItemController.showModelItems());
		modelAndView.addObject("listModelItem", listModelItem);
		return modelAndView;
	}

	@RequestMapping(value = "/administration-create-assessments/{questionnaireid}", method = RequestMethod.POST)
	public ModelAndView createAssessmentsSubmit(Model model, @PathVariable int questionnaireid,
			@ModelAttribute("listModelItem") ListModelItem listModelItem) {

		for (ModelItemWrapper modelItem : listModelItem.getModelItemList()) {
			if (modelItem.getRadioValue() != null) {
				assessmentLineController.createAssessmentLine(questionnaireid, modelItem.getId(),
						modelItem.getImpact());
			}
		}
		ModelAndView modelAndView = new ModelAndView("jsp/questionnaire/assessmentLineList");
		modelAndView.addObject("assessmentLineList", assessmentLineController.showAssessmentLines());
		return modelAndView;
	}
	
	
	
	/*
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
	*/
}
