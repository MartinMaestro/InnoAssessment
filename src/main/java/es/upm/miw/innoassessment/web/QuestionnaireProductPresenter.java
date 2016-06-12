package es.upm.miw.innoassessment.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import es.upm.miw.innoassessment.business.controllers.AssessmentLineController;
import es.upm.miw.innoassessment.business.controllers.DimensionController;
import es.upm.miw.innoassessment.business.controllers.ModelController;
import es.upm.miw.innoassessment.business.controllers.ModelItemController;
import es.upm.miw.innoassessment.business.controllers.ProductController;
import es.upm.miw.innoassessment.business.controllers.ProductVersionController;
import es.upm.miw.innoassessment.business.controllers.QuestionnaireController;
import es.upm.miw.innoassessment.business.wrapper.DimensionWrapper;
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

	
	/*
	@RequestMapping("/home")
	public String home(Model model) {
		// La vista resultante no lleva extensión (.jsp) configurado en
		// WebConfig.java
		return "jsp/home";
	}

	
	
	@RequestMapping("/productversion-list")
	public ModelAndView listProductVersion(Model model) {
		ModelAndView modelAndView = new ModelAndView("jsp/list/productVersionList");
		modelAndView.addObject("productVersionList", productVersionController.showProductVersions());
		return modelAndView;
	}

	@RequestMapping(value = { "/search-productversion/{id}" })
	public ModelAndView searchProductVersion(@PathVariable int id, Model model) {
		System.out.println("---- PRESENTER searchProductVersion  " + id);
		ModelAndView modelAndView = new ModelAndView("jsp/list/productVersionList");
		modelAndView.addObject("productVersionList", productVersionController.showProductVersionsByProduct(id));
		return modelAndView;		
	}

	
	@RequestMapping("/productAssesmentQuestionnaire-list")
	public ModelAndView listProductAssessmentQuestionnaire(Model model) {
		ModelAndView modelAndView = new ModelAndView("jsp/list/productAssessmentQuestionnaireList");
		modelAndView.addObject("questionnaireList", questionnaireController.showQuestionnaires());
		return modelAndView;
	}
	
	@RequestMapping(value = { "/search-productAssessmentQuestionnaire/{id}" })
	public ModelAndView searchProductAssessmentQuestionnaire(@PathVariable int id, Model model) {
		ModelAndView modelAndView = new ModelAndView("jsp/list/productAssessmentQuestionnaireList");
		modelAndView.addObject("questionnaireList", questionnaireController.showQuestionnaires());
		modelAndView.addObject("questionnaireListChoice", questionnaireController.showQuestionnairesByModel(id));
		return modelAndView;
		// return "jsp/list/productQuestionnaireList";
	}
	*/
	@RequestMapping("/model-questionnaire")
	public ModelAndView listModelQuestionnaire(Model model
			,@RequestParam(value="modelId", required=false, defaultValue="0") int modelId) {
		ModelAndView modelAndView = new ModelAndView("jsp/list/selectModelQuestionnaire");
		modelAndView.addObject("modelList", modelController.showModels());
		if (modelId != 0) {
			modelAndView.addObject("questionnaireList", questionnaireController.showQuestionnairesByModel(modelId));
		}			
		return modelAndView;
	}
	
	@RequestMapping("/questionnaire-product")
	public ModelAndView listQuestionnaireProduct(Model model
			,@RequestParam(value="questionnaireId", required=false, defaultValue="0") int questionnaireId
			,@RequestParam(value="productId", required=false, defaultValue="0") int productId) {
		System.out.println("------------- RequestParam modelId: " + questionnaireId);
		ModelAndView modelAndView = new ModelAndView("jsp/list/selectQuestionnaireProduct");
		modelAndView.addObject("productList", productController.showProducts());
		if (productId != 0)
		{
			System.out.println("------------- RequestParam productId: " + productId);
			modelAndView.addObject("productVersionList", productVersionController.showProductVersionsByProduct(productId));
		}
			
		return modelAndView;
	}
	
	/*
	@RequestMapping(value = { "/build-questionnaire/{id}" })
	public ModelAndView buildQuestionnaire(@PathVariable int id, Model model
			,@RequestParam(value="dimensionId", required=false, defaultValue="1") int dimensionId) {
		System.out.println("------------- RequestParam dimensionId: " + dimensionId);
		ModelAndView modelAndView = new ModelAndView("jsp/create/questionnaireBuild");
		modelAndView.addObject("questionnaireDetail", questionnaireController.showQuestionnaire(id));
		modelAndView.addObject("fecha", new SimpleDateFormat("d/MM/yyyy").format(new Date()));
		modelAndView.addObject("hora", new SimpleDateFormat("H:mm").format(new Date()));
		modelAndView.addObject("productList", productController.showProducts());
		System.out.println("----------------------- PRESENTER BUIDQUESTIONNAIRE " + dimensionId);
		modelAndView.addObject("assessmentLineList", assessmentLineController.showAssessmentLinesByDimension(dimensionId));
		return modelAndView;
		
	}
	*/

	

}
