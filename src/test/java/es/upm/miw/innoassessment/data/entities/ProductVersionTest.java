package es.upm.miw.innoassessment.data.entities;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import es.upm.miw.innoassessment.data.entities.Product;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ProductVersionTest {

	@Test
	public void Test01_CreateProductVersion() {
		Product product = new Product("test", "v0", "demo provider");
		assertTrue(product.getName() == "test");
		ProductVersion productVersion = new ProductVersion("testProductVersion", product);
		assertTrue(productVersion.getName() == "testProductVersion");
	}

	@Test
	public void Test02_ChangeProductVersion() {
		Product product = new Product("test", "v0", "demo provider");
		ProductVersion productVersion = new ProductVersion("testProductVersion", product);
		assertTrue(productVersion.getName() == "testProductVersion");
		product.setName("testProductVersion2");
		assertFalse(product.getName() == "testProductVersion");
		assertTrue(product.getName() == "testProductVersion2");
	}

}
