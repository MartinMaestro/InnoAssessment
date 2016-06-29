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
import es.upm.miw.innoassessment.business.controllers.ProductController;
import es.upm.miw.innoassessment.business.controllers.ProductVersionController;
import es.upm.miw.innoassessment.business.controllers.QuestionnaireController;
import es.upm.miw.innoassessment.business.wrapper.ListModelItem;
import es.upm.miw.innoassessment.business.wrapper.ModelItemWrapper;
import es.upm.miw.innoassessment.business.wrapper.ProductVersionWrapper;
import es.upm.miw.innoassessment.business.wrapper.ProductWrapper;
import es.upm.miw.innoassessment.business.wrapper.QuestionnaireWrapper;
import javax.validation.Valid;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
@SessionAttributes("name")
public class AdministrationProductPresenter {
	@Autowired
	private ProductController productController;

	@Autowired
	private ProductVersionController productVersionController;

	@RequestMapping("/administration-list-product")
	public ModelAndView listProduct(Model model) {
		ModelAndView modelAndView = new ModelAndView("jsp/administration/administrationProductList");
		modelAndView.addObject("productList", productController.showProducts());
		return modelAndView;
	}

	@RequestMapping("/administration-list-productversion")
	public ModelAndView listProductVersion(Model model) {
		ModelAndView modelAndView = new ModelAndView("jsp/administration/administrationProductVersionList");
		modelAndView.addObject("productVersionList", productVersionController.showProductVersions());
		return modelAndView;
	}

	@RequestMapping(value = { "/administration-search-productversion/{id}" })
	public ModelAndView searchProductVersion(@PathVariable int id, Model model) {
		ModelAndView modelAndView = new ModelAndView("jsp/administration/administrationProductVersionList");
		modelAndView.addObject("productVersionList", productVersionController.showProductVersionsByProduct(id));
		return modelAndView;
	}

	@RequestMapping(value = "/administration-create-product", method = RequestMethod.GET)
	public String createProduct(Model model) {
		model.addAttribute("product", new ProductWrapper());
		return "jsp/administration/administrationProductCreate";
	}

	@RequestMapping(value = "/administration-create-product", method = RequestMethod.POST)
	public String createProductSubmit(@Valid ProductWrapper product, BindingResult bindingResult, Model model) {
		if (!bindingResult.hasErrors()) {
			if (productController.createProduct(product.getName(), product.getDescription(), product.getProvider())) {
				model.addAttribute("productList", productController.showProducts());
				return "jsp/administration/administrationProductList";
			} else {
				bindingResult.rejectValue("name", "error.product", "Product ya existente");
			}
		}
		return "jsp/administration/administrationProductCreate";
	}

	@RequestMapping(value = "/administration-create-productversion/{id}", method = RequestMethod.GET)
	public ModelAndView createProductVersion(@PathVariable int id, Model model) {
		ModelAndView modelAndView = new ModelAndView("jsp/administration/administrationProductVersionCreate");
		modelAndView.addObject("product", productController.showProduct(id));
		modelAndView.addObject("productVersion", new ProductVersionWrapper(id));
		return modelAndView;
	}

	@RequestMapping(value = "/administration-create-productversion/{id}", method = RequestMethod.POST)
	public String createProductVersionSubmit(@Valid ProductVersionWrapper productVersion, BindingResult bindingResult,
			Model model) {
		if (!bindingResult.hasErrors()) {
			if (productVersionController.createProductVersion(productVersion.getName(),
					productVersion.getProductId())) {
				model.addAttribute("productVersionList", productVersionController.showProductVersions());
				return "jsp/administration/administrationProductVersionList";

			} else {
				bindingResult.rejectValue("name", "error.product", "Product version ya existente");
			}
		}
		return "jsp/administration/administrationProductVersionList";
	}

	@RequestMapping(value = { "/administration-delete-product/{id}" })
	public String deleteProduct(@PathVariable int id, Model model) {
		productController.deleteProduct(id);
		model.addAttribute("productList", productController.showProducts());
		return "jsp/administration/administrationProductList";
	}

	@RequestMapping(value = { "/administration-delete-productversion/{id}" })
	public String deleteProductVersion(@PathVariable int id, Model model) {
		productVersionController.deleteProductVersion(id);
		model.addAttribute("productVersionList", productVersionController.showProductVersions());
		return "jsp/administration/administrationProductVersionList";
	}

}
