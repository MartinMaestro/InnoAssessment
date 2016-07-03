package es.upm.miw.innoassessment.data.daos;

import org.junit.runners.MethodSorters;

import org.junit.FixMethodOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.upm.miw.innoassessment.config.PersistenceConfig;
import es.upm.miw.innoassessment.config.TestsPersistenceConfig;
import es.upm.miw.innoassessment.data.entities.Product;
import es.upm.miw.innoassessment.data.entities.ProductVersion;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class, TestsPersistenceConfig.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDaoIT {

	@Autowired
	private ProductDao productDao;

	@Autowired
	private ProductVersionDao productVersionDao;

	@Test
	public void Test01_CreateProduct() {
		Product product = new Product("testProductDao", "v0", "demo provider");
		productDao.saveAndFlush(product);
		assertTrue(productDao.count() > 0);
	}

	@Test
	public void Test01_FindAnyProduct() {
		assertNotNull(productDao.findOne(1));
	}

	@Test
	public void Test02_FindByName() {
		Product product = productDao.findByName("testProductDao");
		assertEquals("testProductDao", product.getName());
	}

	@Test
	public void Test03_AddProductVersion() {
		Product product = productDao.findByName("testProductDao");
		assertEquals("testProductDao", product.getName());
		ProductVersion productVersion = new ProductVersion("testProductVersion", product);
		productVersionDao.saveAndFlush(productVersion);
		assertTrue(productVersion.getName() == "testProductVersion");
		assertEquals(1, productVersionDao.findByProduct(product).size());
	}

	@Test
	public void Test04_FindProductVersion() {
		Product product = productDao.findByName("testProductDao");
		assertEquals("testProductDao", product.getName());
		assertEquals(1, productVersionDao.findByProduct(product).size());
		List<ProductVersion> listProductVersion = productVersionDao.findByProduct(product);
		assertEquals(1, listProductVersion.size());
	}

	@Test
	public void Test05_DeleteProductVersion() {
		Product product = productDao.findByName("testProductDao");
		assertEquals(1, productVersionDao.findByProduct(product).size());
		List<ProductVersion> listProductVersion = productVersionDao.findByProduct(product);
		ProductVersion productVersion = listProductVersion.get(0);
		assertEquals("testProductDao", productVersion.getProduct().getName());
		productVersionDao.delete(productVersion);
		productVersionDao.flush();
		// assertNull(productDao.findByName("testProductDao"));
	}

	@Test
	public void Test06_DeleteProduct() {
		Product product = productDao.findByName("testProductDao");
		assertEquals("testProductDao", product.getName());
		productDao.delete(product);
	}
}
