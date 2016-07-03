package es.upm.miw.innoassessment.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import es.upm.miw.innoassessment.business.controllers.DimensionController;
import es.upm.miw.innoassessment.business.controllers.EvaluationController;
import es.upm.miw.innoassessment.business.controllers.EvaluationResultController;
import es.upm.miw.innoassessment.business.controllers.LineValueController;
import es.upm.miw.innoassessment.business.controllers.ProductController;
import es.upm.miw.innoassessment.business.controllers.ProductVersionController;
import es.upm.miw.innoassessment.business.controllers.ModelController;
import es.upm.miw.innoassessment.business.controllers.QuestionnaireController;
import es.upm.miw.innoassessment.business.wrapper.LineValueWrapper;
import es.upm.miw.innoassessment.business.wrapper.ListLineValue;
import es.upm.miw.innoassessment.business.wrapper.ModelWrapper;
import es.upm.miw.innoassessment.business.wrapper.ProductVersionWrapper;
import es.upm.miw.innoassessment.business.wrapper.ProductWrapper;
import es.upm.miw.innoassessment.business.wrapper.QuestionnaireWrapper;
import es.upm.miw.innoassessment.data.entities.AssessmentLine;
import es.upm.miw.innoassessment.data.entities.Evaluation;
import es.upm.miw.innoassessment.data.entities.LineValue;
import es.upm.miw.innoassessment.data.entities.ValueName;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
@SessionAttributes("name")
public class AssessmentProductPresenter {

	@Autowired
	private ProductController productController;

	@Autowired
	private ProductVersionController productVersionController;

	@Autowired
	private EvaluationController evaluationController;

	@Autowired
	private DimensionController dimensionController;

	@Autowired
	private EvaluationResultController evaluationResultController;

	@Autowired
	private LineValueController lineValueController;
	
	@Autowired
	private ModelController modelController;
	
	@Autowired
	private QuestionnaireController questionnaireController;

	@RequestMapping("/assessment-product-search")
	public ModelAndView listAssessmentByProductClassic(Model model, @RequestParam(value="productId", required=false, defaultValue="0") int productId
			, @RequestParam(value="productVersionId", required=false, defaultValue="0") int productVersionId){
		return listAssessmentByProduct(model, productId, productVersionId, "");
	}

	@RequestMapping("/modern/assessment-product-search")
	public ModelAndView listAssessmentByProductModern(Model model, @RequestParam(value="productId", required=false, defaultValue="0") int productId
			, @RequestParam(value="productVersionId", required=false, defaultValue="0") int productVersionId){
		return listAssessmentByProduct(model, productId, productVersionId, "/public");		
	}

	@RequestMapping("/assessment-questionnaire-search")
	public ModelAndView listAssessmentByQuestionnaireClassic(Model model, @RequestParam(value="modelId", required=false, defaultValue="0") int modelId
			, @RequestParam(value="questionnaireId", required=false, defaultValue="0") int questionnaireId) {
		return listAssessmentByQuestionnaire(model, modelId, questionnaireId, "");
	}

	@RequestMapping("/modern/assessment-questionnaire-search")
	public ModelAndView listAssessmentByQuestionnaireModern(Model model, @RequestParam(value="modelId", required=false, defaultValue="0") int modelId
			, @RequestParam(value="questionnaireId", required=false, defaultValue="0") int questionnaireId) {
		return listAssessmentByQuestionnaire(model, modelId, questionnaireId, "/public");
	}

	@RequestMapping("/assessment-product-view")
	public ModelAndView showAssessmentLineClassic(Model model, @RequestParam(value="evaluationId", required=false, defaultValue="0") int evaluationId){
		return showAssessmentLine(model, evaluationId, "");
	}

	@RequestMapping("/modern/assessment-product-view")
	public ModelAndView showAssessmentLineModern(Model model, @RequestParam(value="evaluationId", required=false, defaultValue="0") int evaluationId){
		return showAssessmentLine(model, evaluationId, "/public");
	}

	@RequestMapping(value = {"/assessment-product-update" }, method = RequestMethod.POST)
	public RedirectView updateAssessmentProductClassic(@ModelAttribute("listLineValue") ListLineValue listLineValue, BindingResult bindingResult,
			Model model) {
		return updateAssessmentProduct(listLineValue, bindingResult, model, "");
	}

	@RequestMapping(value = {"/modern/assessment-product-update" }, method = RequestMethod.POST)
	public RedirectView updateAssessmentProductModern(@ModelAttribute("listLineValue") ListLineValue listLineValue, BindingResult bindingResult,
			Model model) {
		return updateAssessmentProduct(listLineValue, bindingResult, model, "/modern");
	}

	@RequestMapping("/assessment-product-chart")
	public ModelAndView showAssessmentLineChartClassic(Model model, @RequestParam(value="evaluationId", required=false, defaultValue="0") int evaluationId){
		return showAssessmentLineChart(model, evaluationId, "");
	}

	@RequestMapping("/modern/assessment-product-chart")
	public ModelAndView showAssessmentLineChartModern(Model model, @RequestParam(value="evaluationId", required=false, defaultValue="0") int evaluationId){
		return showAssessmentLineChart(model, evaluationId, "/public");
	}
	
	private ModelAndView listAssessmentByProduct(Model model, int productId, int productVersionId, String route) {
		ModelAndView modelAndView = new ModelAndView("jsp" + route + "/assessment-product-visualization/assessmentProductSearch");
		if(productId == 0){
			modelAndView.addObject("productList", productController.showProducts());
		} else if(productVersionId == 0){
			modelAndView.addObject("productList", new ArrayList<ProductWrapper>(){
				private static final long serialVersionUID = 1L;
			{add(productController.showProduct(productId));}
			});
			modelAndView.addObject("productVersionList", productVersionController.showProductVersionsByProduct(productId));
		} else {
			modelAndView.addObject("productList", new ArrayList<ProductWrapper>(){
				private static final long serialVersionUID = 1L;
			{add(productController.showProduct(productId));}
			});
			modelAndView.addObject("productVersionList", new ArrayList<ProductVersionWrapper>(){
				private static final long serialVersionUID = 1L;
			{add(productVersionController.showProductVersion(productVersionId));}
			});
			modelAndView.addObject("evaluationList", evaluationController.findByProductVersionId(productVersionId));		
		}
		return modelAndView;
	}

	private ModelAndView listAssessmentByQuestionnaire(Model model, int modelId, int questionnaireId, String route) {
		ModelAndView modelAndView = new ModelAndView("jsp" + route + "/assessment-product-visualization/assessmentQuestionnaireSearch");
		if(modelId == 0){
			modelAndView.addObject("modelList", modelController.showModels());
		} else if(questionnaireId == 0){
			modelAndView.addObject("modelList", new ArrayList<ModelWrapper>(){
				private static final long serialVersionUID = 1L;
			{add(modelController.showModel(modelId));}
			});
			modelAndView.addObject("questionnaireList", questionnaireController.showQuestionnairesByModel(modelId));
		} else {
			modelAndView.addObject("modelList", new ArrayList<ModelWrapper>(){
				private static final long serialVersionUID = 1L;
			{add(modelController.showModel(modelId));}
			});
			modelAndView.addObject("questionnaireList", new ArrayList<QuestionnaireWrapper>(){
				private static final long serialVersionUID = 1L;
			{add(questionnaireController.showQuestionnaire(questionnaireId));}
			});
			modelAndView.addObject("evaluationList", evaluationController.findByQuestionnaireId(questionnaireId));		
		}
		return modelAndView;
	}

	private ModelAndView showAssessmentLine(Model model, int evaluationId, String route){
		ModelAndView modelAndView = new ModelAndView("jsp" + route + "/assessment-product-visualization/assessmentProductView");
		Evaluation evaluation = evaluationController.findOne(evaluationId);
		modelAndView.addObject("evaluation", evaluation);
		modelAndView.addObject("dimensionList", dimensionController.showDimensionsByQuestionnaireId(evaluation.getQuestionnaire().getId()));
		modelAndView.addObject("evaluationResultList", evaluationResultController.findByEvaluationId(evaluationId));
		List<LineValue> lineValueList = lineValueController.findByEvaluationId(evaluationId);
		modelAndView.addObject("lineValueList", lineValueList);
		List<LineValueWrapper> lineValueWrapperList = new ArrayList<>();
		for(LineValue lineValue : lineValueList){
			lineValueWrapperList.add(new LineValueWrapper(lineValue.getId(), lineValue.getEvaluation().getId(), lineValue.getAssessmentLine().getId(), lineValue.getValueName().getName(), lineValue));
		}
		modelAndView.addObject("listLineValue", new ListLineValue(lineValueWrapperList));

		return modelAndView;
	}

	private RedirectView updateAssessmentProduct(ListLineValue listLineValue, BindingResult bindingResult, Model model, String route) {
		ArrayList<LineValue> lineValues = new ArrayList<LineValue>();
		for (LineValueWrapper lineValueWrapper : listLineValue.getLineValueWrapperList()) {
			LineValue lineValue = new LineValue(new Evaluation(lineValueWrapper.getEvaluationId()), new AssessmentLine(lineValueWrapper.getAssessmentLineId()), ValueName.getByName(lineValueWrapper.getRadioValue()), 0,
					null, null);
			lineValue.setId(lineValueWrapper.getId());
			lineValues.add(lineValue);
		}
		lineValueController.saveLineValues(lineValues);
		
		RedirectView redirectView = new RedirectView("/innoassessment" + route + "/assessment-product-view");
		redirectView.addStaticAttribute("evaluationId", lineValues.get(0).getEvaluation().getId());
		
		return redirectView;
	}

	private ModelAndView showAssessmentLineChart(Model model, int evaluationId, String route){
		ModelAndView modelAndView = new ModelAndView("jsp" + route + "/assessment-product-visualization/assessmentProductChart");
		Evaluation evaluation = evaluationController.findOne(evaluationId);
		modelAndView.addObject("evaluation", evaluation);
		modelAndView.addObject("dimensionList", dimensionController.showDimensionsByQuestionnaireId(evaluation.getQuestionnaire().getId()));
		modelAndView.addObject("evaluationResultList", evaluationResultController.findByEvaluationId(evaluationId));

		return modelAndView;
	}
	

}
