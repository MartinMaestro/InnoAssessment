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

import es.upm.miw.innoassessment.business.controllers.EvaluationController;
import es.upm.miw.innoassessment.business.controllers.ProductController;
import es.upm.miw.innoassessment.business.controllers.ProductVersionController;
import es.upm.miw.innoassessment.business.wrapper.ProductVersionWrapper;
import es.upm.miw.innoassessment.business.wrapper.ProductWrapper;

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

	@RequestMapping("/assessment-product")
	public ModelAndView listAssessmentLines(Model model, @RequestParam(value="productId", required=false, defaultValue="0") int productId
			, @RequestParam(value="productVersionId", required=false, defaultValue="0") int productVersionId) {
		System.out.println("******************************************* productId: " + productId);
		ModelAndView modelAndView = new ModelAndView("jsp/selectAssessmentProduct");
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

}
