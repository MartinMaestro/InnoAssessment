package es.upm.miw.innoassessment.business.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.upm.miw.innoassessment.business.wrapper.ProductWrapper;
import es.upm.miw.innoassessment.data.daos.ProductDao;
import es.upm.miw.innoassessment.data.entities.Product;

@Controller
public class ProductController {

	private ProductDao productDao;

	@Autowired
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public List<ProductWrapper> showProducts() {
		List<ProductWrapper> productWrapperList = new ArrayList<>();
		for (Product product : productDao.findAll()) {
			productWrapperList.add(new ProductWrapper(product));
		}
		return productWrapperList;
	}

	public boolean deleteProduct(int id) {
		// return dimensionDao.deleteDimensionDao(id);
		productDao.delete(id);
		return true;
	}

	public boolean createProduct(String name, String description, String provider) {
		// return dimensionDao.createDimensionDao(name);
		productDao.saveAndFlush(new Product(name, description, provider));
		return true;
	}
}
