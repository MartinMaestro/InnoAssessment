package es.upm.miw.innoassessment.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import es.upm.miw.innoassessment.business.controllers.DimensionController;
import es.upm.miw.innoassessment.business.controllers.EvaluationController;
import es.upm.miw.innoassessment.business.controllers.EvaluationResultController;
import es.upm.miw.innoassessment.business.controllers.LineValueController;
import es.upm.miw.innoassessment.business.controllers.ProductController;
import es.upm.miw.innoassessment.business.controllers.ProductVersionController;
import es.upm.miw.innoassessment.business.wrapper.ProductVersionWrapper;
import es.upm.miw.innoassessment.business.wrapper.ProductWrapper;
import es.upm.miw.innoassessment.data.entities.Evaluation;

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

	@RequestMapping("/assessment-product-search")
	public ModelAndView listAssessmentLines(Model model, @RequestParam(value="productId", required=false, defaultValue="0") int productId
			, @RequestParam(value="productVersionId", required=false, defaultValue="0") int productVersionId) {
		ModelAndView modelAndView = new ModelAndView("jsp/assessment-product-visualization/assessmentProductSearch");
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

	@RequestMapping("/assessment-product-view")
	public ModelAndView showAssessmentLine(Model model, @RequestParam(value="evaluationId", required=false, defaultValue="0") int evaluationId){
		ModelAndView modelAndView = new ModelAndView("jsp/assessment-product-visualization/assessmentProductView");
		Evaluation evaluation = evaluationController.findOne(evaluationId);
		modelAndView.addObject("evaluation", evaluation);
		modelAndView.addObject("dimensionList", dimensionController.showDimensionsByQuestionnaireId(evaluation.getQuestionnaire().getId()));
		modelAndView.addObject("evaluationResultList", evaluationResultController.findByEvaluationId(evaluationId));
		modelAndView.addObject("lineValueList", lineValueController.findByEvaluationId(evaluationId));

		return modelAndView;
	}

	@RequestMapping("/assessment-product-chart")
	public ModelAndView showAssessmentLineChart(Model model, @RequestParam(value="evaluationId", required=false, defaultValue="0") int evaluationId){
		ModelAndView modelAndView = new ModelAndView("jsp/assessment-product-visualization/assessmentProductChart");
		Evaluation evaluation = evaluationController.findOne(evaluationId);
		modelAndView.addObject("dimensionList", dimensionController.showDimensionsByQuestionnaireId(evaluation.getQuestionnaire().getId()));
		modelAndView.addObject("evaluationResultList", evaluationResultController.findByEvaluationId(evaluationId));

		return modelAndView;
	}
	

}
