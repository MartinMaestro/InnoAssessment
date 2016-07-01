package es.upm.miw.innoassessment.data.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import es.upm.miw.innoassessment.data.entities.Product;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ProductTest {

	@Test
	public void Test01_CreateProduct() {
		Product product = new Product("test", "v0", "demo provider");
		assertTrue(product.getName() == "test");
	}

	@Test
	public void Test02_ChangeProduct() {
		Product product = new Product("test", "v0", "demo provider");
		assertTrue(product.getName() == "test");
		product.setName("test2");
		assertFalse(product.getName() == "test");
		assertTrue(product.getName() == "test2");
	}

	@Test
	public void Test03_AddProductVersion() {
		Product product = new Product("test", "v0", "demo provider");
		assertTrue(product.getName() == "test");
		ProductVersion productVersion = new ProductVersion("testProductVersion", product);
		assertTrue(productVersion.getName() == "testProductVersion");
	}

	@Test
	public void Test04_DeleteProductVersion() {
		Product product = new Product("test", "v0", "demo provider");
		assertTrue(product.getName() == "test");
		ProductVersion productVersion = new ProductVersion("testProductVersion", product);
		assertTrue(productVersion.getName() == "testProductVersion");
	}

}
