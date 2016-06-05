package es.upm.miw.innoassessment.business.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import es.upm.miw.innoassessment.business.controllers.ProductController;
import es.upm.miw.innoassessment.business.wrapper.ProductWrapper;

@RestController
@RequestMapping(Uris.SERVLET_MAP + Uris.PRODUCTS)
public class ProductResource {

	private ProductController productController;

	@Autowired
	public void setProductController(ProductController productController) {
		this.productController = productController;
	}

	@RequestMapping(method = RequestMethod.POST)
	public void createProduct(@RequestParam(required = true) String name, String description, String provider,
			String version) {
		this.productController.createProduct(name, description, provider, version);
	}

	@RequestMapping(value = Uris.ID, method = RequestMethod.DELETE)
	public void deleteProduct(@PathVariable int id) {
		this.productController.deleteProduct(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<ProductWrapper> showProducts() {
		return productController.showProducts();
	}

}
