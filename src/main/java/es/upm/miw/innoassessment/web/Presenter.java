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
import es.upm.miw.innoassessment.business.controllers.ModelController;
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
public class Presenter {

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
	private QuestionnaireController questionnaireController;

	// Se ejecuta siempre y antes. Añade un atributo al Model
	@ModelAttribute("now")
	public String now() {
		return new SimpleDateFormat("EEEE, d MMM yyyy HH:mm:ss").format(new Date());
	}

	@RequestMapping("/home")
	public String home(Model model) {
		// La vista resultante no lleva extensión (.jsp) configurado en
		// WebConfig.java
		return "jsp/home";
	}

	@RequestMapping("/assessmentLine-list")
	public ModelAndView listAssessmentLines(Model model) {
		ModelAndView modelAndView = new ModelAndView("jsp/list/assessmentLineList");
		modelAndView.addObject("assessmentLine", assessmentLineController.showAssessmentLines());
		return modelAndView;
	}

	@RequestMapping("/dimension-list")
	public ModelAndView listDimension(Model model) {
		ModelAndView modelAndView = new ModelAndView("jsp/list/dimensionList");
		modelAndView.addObject("dimensionList", dimensionController.showDimensions());
		return modelAndView;
	}

	@RequestMapping("/product-list")
	public ModelAndView listProduct(Model model) {
		ModelAndView modelAndView = new ModelAndView("jsp/list/productList");
		modelAndView.addObject("productList", productController.showProducts());
		return modelAndView;
	}
	
	@RequestMapping("/productversion-list")
	public ModelAndView listProductVersion(Model model) {
		System.out.println("-------------PRESENTER listProductVersion");
		ModelAndView modelAndView = new ModelAndView("jsp/list/productVersionList");
		modelAndView.addObject("productVersionList", productVersionController.showProductVersions());
		return modelAndView;
	}
	
	@RequestMapping(value = { "/search-productversion/{id}" })
	public ModelAndView searchProductVersion(@PathVariable int id, Model model) {
		System.out.println("---- PRESENTER searchProductVersion  " + id);
		ModelAndView modelAndView = new ModelAndView("jsp/list/productVersionList");
		modelAndView.addObject("productVersionList", productVersionController.showProductVersionsByProduct(id));

		//modelAndView.addObject("questionnaireListChoice", questionnaireController.showQuestionnairesByModel(id));

		return modelAndView;

		// return "jsp/list/productQuestionnaireList";
	}

	@RequestMapping("/model-list")
	public ModelAndView listModel(Model model) {
		ModelAndView modelAndView = new ModelAndView("jsp/list/modelList");
		modelAndView.addObject("modelList", modelController.showModels());
		return modelAndView;
	}

	@RequestMapping("/questionnaire-list")
	public ModelAndView listQuestionnaire(Model model) {
		System.out.println("-------------PRESENTER listQuestionnaire");

		ModelAndView modelAndView = new ModelAndView("jsp/list/questionnaireList");
		modelAndView.addObject("questionnaireList", questionnaireController.showQuestionnaires());
		return modelAndView;
	}

	@RequestMapping("/productQuestionnaire-list")
	public ModelAndView listProductQuestionnaire(Model model) {
		System.out.println("-------------PRESENTER listProductQuestionnaire");
		ModelAndView modelAndView = new ModelAndView("jsp/list/productQuestionnaireList");
		modelAndView.addObject("questionnaireList", questionnaireController.showQuestionnaires());
		return modelAndView;
	}

	@RequestMapping(value = "/productQuestionnaire-list", method = RequestMethod.POST)
	public String listProductQuestionnaireSelect(@Valid QuestionnaireWrapper questionnaire, BindingResult bindingResult,
			Model model) {
		System.out.println("-------------PRESENTER listProductQuestionnaireSelect");
		System.out.println("---- PRESENTER  " + questionnaire.getId());

		return "jsp/list/productQuestionnaireList";
	}

	@RequestMapping(value = { "/search-questionnaire/{id}" })
	public ModelAndView searchQuestionnaire(@PathVariable int id, Model model) {
		System.out.println("---- PRESENTER searchQuestionnaire  " + id);
		// model.addAttribute("productList", productController.showProducts());
		ModelAndView modelAndView = new ModelAndView("jsp/list/productQuestionnaireList");
		modelAndView.addObject("questionnaireList", questionnaireController.showQuestionnaires());

		modelAndView.addObject("questionnaireListChoice", questionnaireController.showQuestionnairesByModel(id));

		return modelAndView;

		// return "jsp/list/productQuestionnaireList";
	}

	@RequestMapping(value = "/create-dimension", method = RequestMethod.GET)
	public String createDimension(Model model) {
		model.addAttribute("dimension", new DimensionWrapper());
		return "jsp/create/dimensionCreate";
	}

	@RequestMapping(value = "/create-dimension", method = RequestMethod.POST)
	public String createDimensionSubmit(@Valid DimensionWrapper dimension, BindingResult bindingResult, Model model) {
		if (!bindingResult.hasErrors()) {
			if (dimensionController.createDimension(dimension.getName())) {
				model.addAttribute("name", dimension.getName());
				model.addAttribute("id", dimension.getId());
				return "jsp/registrationSuccess";
			} else {
				bindingResult.rejectValue("name", "error.dimension", "Dimension ya existente");
			}
		}
		return "jsp/create/dimensionCreate";
	}

	@RequestMapping(value = "/create-product", method = RequestMethod.GET)
	public String createProduct(Model model) {
		model.addAttribute("product", new ProductWrapper());
		return "jsp/create/productCreate";
	}

	@RequestMapping(value = "/create-product", method = RequestMethod.POST)
	public String createProductSubmit(@Valid ProductWrapper product, BindingResult bindingResult, Model model) {
		if (!bindingResult.hasErrors()) {
			if (productController.createProduct(product.getName(), product.getDescription(), product.getProvider())) {
				model.addAttribute("name", product.getName());
				model.addAttribute("description", product.getDescription());
				model.addAttribute("name", product.getProvider());
				model.addAttribute("id", product.getId());
				return "jsp/list/productList";
			} else {
				bindingResult.rejectValue("name", "error.product", "Product ya existente");
			}
		}
		return "jsp/create/createProduct";
	}
	
	@RequestMapping(value = "/create-productversion/{id}", method = RequestMethod.GET)
	public String createProductVersion(@PathVariable int id,Model model) {
		System.out.println("-------------PRESENTER createProductVersion");
		model.addAttribute("productVersion", new ProductVersionWrapper());
		return "jsp/create/productVersionCreate";
	}

	@RequestMapping(value = "/create-productversion", method = RequestMethod.POST)
	public String createProductSubmit(@Valid ProductVersionWrapper productVersion, BindingResult bindingResult, Model model) {
		if (!bindingResult.hasErrors()) {
			if (productVersionController.createProductVersion(productVersion.getName(),productVersion.getProductId())) {
				model.addAttribute("name", productVersion.getName());
				model.addAttribute("productId", productVersion.getProductId());
				return "jsp/list/productList";
			} else {
				bindingResult.rejectValue("name", "error.product", "Product version ya existente");
			}
		}
		return "jsp/create/createProductVersion";
	}

	@RequestMapping(value = "/create-model", method = RequestMethod.GET)
	public String createModel(Model model) {
		model.addAttribute("model", new ModelWrapper());
		return "jsp/create/modelCreate";
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
		return "jsp/create/createModel";
	}

	@RequestMapping(value = { "/delete-dimension/{id}" })
	public String deleteDimension(@PathVariable int id, Model model) {
		dimensionController.deleteDimension(id);
		model.addAttribute("dimensionList", dimensionController.showDimensions());
		return "jsp/list/dimensionList";
	}

	@RequestMapping(value = { "/delete-product/{id}" })
	public String deleteProduct(@PathVariable int id, Model model) {
		productController.deleteProduct(id);
		model.addAttribute("productList", productController.showProducts());
		return "jsp/list/productList";
	}

	@RequestMapping(value = { "/delete-model/{id}" })
	public String deleteModel(@PathVariable int id, Model model) {
		modelController.deleteModel(id);
		model.addAttribute("modelList", modelController.showModels());
		return "jsp/list/modelList";
	}

}
