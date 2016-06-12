package es.upm.miw.innoassessment.business.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.upm.miw.innoassessment.business.wrapper.ProductVersionWrapper;
import es.upm.miw.innoassessment.data.daos.ProductDao;
import es.upm.miw.innoassessment.data.daos.ProductVersionDao;
import es.upm.miw.innoassessment.data.entities.Product;
import es.upm.miw.innoassessment.data.entities.ProductVersion;

@Controller
public class ProductVersionController {

	private ProductVersionDao productVersionDao;

	private ProductDao productDao;

	@Autowired
	public void setProductVersionDao(ProductVersionDao productVersionDao) {
		this.productVersionDao = productVersionDao;
	}

	@Autowired
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public List<ProductVersionWrapper> showProductVersions() {
		List<ProductVersionWrapper> productVersionWrapperList = new ArrayList<>();
		for (ProductVersion productVersion : productVersionDao.findAll()) {
			productVersionWrapperList.add(new ProductVersionWrapper(productVersion));
		}
		return productVersionWrapperList;
	}

	public List<ProductVersionWrapper> showProductVersionsByProduct(int productId) {
		List<ProductVersionWrapper> productVersionWrapperList = new ArrayList<>();
		for (ProductVersion productVersion : productVersionDao.findByProductId(productId)) {
			productVersionWrapperList.add(new ProductVersionWrapper(productVersion));
		}
		return productVersionWrapperList;
	}

	public boolean createProductVersion(String name, int productId) {
		Product product = productDao.findOne(productId);
		productVersionDao.saveAndFlush(new ProductVersion(name, product));
		return true;
	}

	public boolean deleteProductVersion(int id) {
		productVersionDao.delete(id);
		return true;
	}

	public ProductVersionWrapper showProductVersion(int productVersionId) {
		return new ProductVersionWrapper(productVersionDao.findOne(productVersionId));
	}
}
