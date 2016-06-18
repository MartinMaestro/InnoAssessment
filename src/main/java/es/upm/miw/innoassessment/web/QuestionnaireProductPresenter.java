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
import es.upm.miw.innoassessment.business.controllers.EvaluationController;
import es.upm.miw.innoassessment.business.controllers.LineValueController;
import es.upm.miw.innoassessment.business.controllers.ModelController;
import es.upm.miw.innoassessment.business.controllers.ModelItemController;
import es.upm.miw.innoassessment.business.controllers.ProductController;
import es.upm.miw.innoassessment.business.controllers.ProductVersionController;
import es.upm.miw.innoassessment.business.controllers.QuestionnaireController;
import es.upm.miw.innoassessment.business.wrapper.AssessmentLineWrapper;
import es.upm.miw.innoassessment.business.wrapper.ListAssessmentLine;
import es.upm.miw.innoassessment.business.wrapper.ProductWrapper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
@SessionAttributes("name")
public class QuestionnaireProductPresenter {

	@Autowired
	private AssessmentLineController assessmentLineController;

	@Autowired
	private DimensionController dimensionController;

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

	@Autowired
	private EvaluationController evaluationController;

	@Autowired
	private LineValueController lineValueController;

	@RequestMapping("/model-questionnaire")
	public ModelAndView listModelQuestionnaire(Model model,
			@RequestParam(value = "modelId", required = false, defaultValue = "0") int modelId) {
		ModelAndView modelAndView = new ModelAndView("jsp/list/selectModelQuestionnaire");
		modelAndView.addObject("modelList", modelController.showModels());
		if (modelId != 0) {
			modelAndView.addObject("questionnaireList", questionnaireController.showQuestionnairesByModel(modelId));
		}
		return modelAndView;
	}

	@RequestMapping("/questionnaire-product/{id}")
	public ModelAndView listQuestionnaireProduct(Model model, @PathVariable int id,
			// @RequestParam(value = "questionnaireId", required = false,
			// defaultValue = "0") int questionnaireId,
			@RequestParam(value = "productId", required = false, defaultValue = "0") int productId) {
		ModelAndView modelAndView = new ModelAndView("jsp/list/selectQuestionnaireProduct");
		modelAndView.addObject("questionnaireDetail", questionnaireController.showQuestionnaire(id));
		modelAndView.addObject("fecha", new SimpleDateFormat("d/MM/yyyy").format(new Date()));
		modelAndView.addObject("hora", new SimpleDateFormat("H:mm").format(new Date()));
		modelAndView.addObject("productList", productController.showProducts());
		if (productId != 0) {
			modelAndView.addObject("product", productController.showProduct(productId));
			modelAndView.addObject("productVersionList",
					productVersionController.showProductVersionsByProduct(productId));
			modelAndView.addObject("dimensionList", dimensionController.showDimensionsByQuestionnaireId(id));
		}
		return modelAndView;
	}

	@RequestMapping(value = { "/build-questionnaire/{id}" })
	public ModelAndView buildQuestionnaire(@PathVariable int id, Model model,
			@RequestParam(value = "productVersionId", required = true) int productVersionId,
			@RequestParam(value = "processQuestionnaire", required = false, defaultValue = "0") int processQuestionnaire) {
		if (processQuestionnaire == 1) {
			System.out.println("------------- PRESENTER buildQuestionnaire : PROCESAR QUESTIONNARIO");
			int evaluationId = evaluationController.createEvaluation(id, productVersionId);
			System.out.println("------------- PRESENTER buildQuestionnaire : EVALUACION CREADA ID: " + evaluationId);
			System.out.println("-----PRESENTER buildQuestionnaire  - assestmentLine valor");

			// recorrer todos los assesstmente: y crear un assestmen +
			// evaluation = LINEVALUE
			// CREACIÓN ASSESSTEMENT: QUESTIONARIO Y MODELITEM
			// lineValue: seria listAssestment? no uno solo, pero entonces
			// EVALUATION se repite con ASSESMENTE, cuando es solo uno
			// lineValueController.createLineValue(evaluationId,
			// assessmentLineId, valueName, valueData, sourcesUrls,
			// sourcesFiles)
		}
		System.out.println(
				"------------- PRESENTER buildQuestionnaire questionnaire: " + id + "-productId: " + productVersionId);
		ModelAndView modelAndView = new ModelAndView("jsp/create/questionnaireBuild");
		modelAndView.addObject("questionnaireDetail", questionnaireController.showQuestionnaire(id));
		modelAndView.addObject("productVersion", productVersionController.showProductVersion(productVersionId));
		modelAndView.addObject("fecha", new SimpleDateFormat("d/MM/yyyy").format(new Date()));
		modelAndView.addObject("hora", new SimpleDateFormat("H:mm").format(new Date()));
		modelAndView.addObject("dimensionList", dimensionController.showDimensionsByQuestionnaireId(id));
		ListAssessmentLine listAssessmentLine = new ListAssessmentLine();
		listAssessmentLine.setAssessmentList(assessmentLineController.showAssessmentLinesByQuestionnaire(id));
		modelAndView.addObject("listAssessmentLine", listAssessmentLine);
		return modelAndView;
		// return new
		// ModelAndView("jsp/create/questionnaireBuild","listAssessmentLine",
		// listAssessmentLine);
	}

	@RequestMapping(value = {
			"/build-questionnaire/{questionnaireId}/productversion/{productVersionId}" }, method = RequestMethod.POST)
	public String buildQuestionnaireSubmit(@PathVariable int questionnaireId, @PathVariable int productVersionId,
			@ModelAttribute("listAssessmentLine") ListAssessmentLine listAssessmentLine, BindingResult bindingResult,
			Model model) {
		System.out.println("------------- PRESENTER POST buildQuestionnaire : PROCESAR QUESTIONNARIO_ " + questionnaireId + " - Id productVersion:" +productVersionId);
		System.out.println("------------- PRESENTER ASSESSTEMENT LIST: ");
		for (AssessmentLineWrapper assessmentLine : listAssessmentLine.getAssessmentList()) {
			System.out.println("------------- assessmentLine id: " + assessmentLine.getId()
					+ " getModelItemDimensionName: " + assessmentLine.getRadioValue());
		}
		int evaluationId = evaluationController.createEvaluation(questionnaireId, productVersionId);
		return "jsp/home"; 
	}

}
