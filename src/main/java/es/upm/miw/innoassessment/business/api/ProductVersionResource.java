package es.upm.miw.innoassessment.business.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import es.upm.miw.innoassessment.business.controllers.ProductVersionController;
import es.upm.miw.innoassessment.business.wrapper.ProductVersionWrapper;

@RestController
@RequestMapping(Uris.SERVLET_MAP + Uris.PRODUCTVERSIONS)
public class ProductVersionResource {

	private ProductVersionController productVersionController;

	@Autowired
	public void setProductVersionController(ProductVersionController productVersionController) {
		this.productVersionController = productVersionController;
	}

	@RequestMapping(method = RequestMethod.POST)
	public void createProductVersion(@RequestParam(required = true) String name, int productId) {
		this.productVersionController.createProductVersion(name, productId);
	}

	@RequestMapping(value = Uris.ID, method = RequestMethod.DELETE)
	public void deleteProductVersion(@PathVariable int id) {
		this.productVersionController.deleteProductVersion(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<ProductVersionWrapper> showProductVersions() {
		return productVersionController.showProductVersions();
	}

}
