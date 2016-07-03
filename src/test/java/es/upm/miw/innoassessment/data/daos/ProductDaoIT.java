package es.upm.miw.innoassessment.data.daos;

import org.junit.runners.MethodSorters;
import org.junit.Before;
import org.junit.FixMethodOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
import es.upm.miw.innoassessment.data.services.DataService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class, TestsPersistenceConfig.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDaoIT {

	@Autowired
	private ProductDao productDao;

	@Autowired
	private ProductVersionDao productVersionDao;

	@Autowired
	private DataService dataService;
	
	@Before
	public void deleteAllBefore(){
		dataService.deleteAll();
	}

	@Test
	public void Test01_CreateProduct() {
		Product product = new Product("testProductDao", "v0", "demo provider");
		productDao.saveAndFlush(product);
		assertTrue(productDao.count() > 0);
	}

	@Test
	public void Test01_FindAnyProduct() {
		Product product = new Product("testProductDao", "v0", "demo provider");
		product = productDao.saveAndFlush(product);
		assertNotNull(productDao.findOne(product.getId()));
	}

	@Test
	public void Test02_FindByName() {
		Product product = new Product("testProductDao", "v0", "demo provider");
		product = productDao.saveAndFlush(product);
		assertEquals("testProductDao", product.getName());
	}

	@Test
	public void Test03_AddProductVersion() {
		Product product = new Product("testProductDao", "v0", "demo provider");
		product = productDao.saveAndFlush(product);
		assertEquals("testProductDao", product.getName());
		ProductVersion productVersion = new ProductVersion("testProductVersion", product);
		productVersionDao.saveAndFlush(productVersion);
		assertTrue(productVersion.getName() == "testProductVersion");
		assertEquals(1, productVersionDao.findByProduct(product).size());
	}

	@Test
	public void Test04_FindProductVersion() {
		Product product = new Product("testProductDao", "v0", "demo provider");
		product = productDao.saveAndFlush(product);
		ProductVersion productVersion = new ProductVersion("testProductVersion", product);
		productVersionDao.saveAndFlush(productVersion);
		assertEquals("testProductDao", product.getName());
		assertEquals(1, productVersionDao.findByProduct(product).size());
		List<ProductVersion> listProductVersion = productVersionDao.findByProduct(product);
		assertEquals(1, listProductVersion.size());
	}

	@Test
	public void Test05_DeleteProductVersion() {
		Product product = new Product("testProductDao", "v0", "demo provider");
		product = productDao.saveAndFlush(product);
		ProductVersion productVersion = new ProductVersion("testProductVersion", product);
		productVersionDao.saveAndFlush(productVersion);
		assertEquals(1, productVersionDao.findByProduct(product).size());
		List<ProductVersion> listProductVersion = productVersionDao.findByProduct(product);
		productVersion = listProductVersion.get(0);
		assertEquals("testProductDao", productVersion.getProduct().getName());
		productVersionDao.delete(productVersion);
		productVersionDao.flush();
		// assertNull(productDao.findByName("testProductDao"));
	}

	@Test
	public void Test06_DeleteProduct() {
		Product product = new Product("testProductDao", "v0", "demo provider");
		product = productDao.saveAndFlush(product);
		assertEquals("testProductDao", product.getName());
		productDao.delete(product);
	}
}
