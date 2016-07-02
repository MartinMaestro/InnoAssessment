package es.upm.miw.innoassessment.data.entities;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import es.upm.miw.innoassessment.data.entities.Product;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ModelTest {

	@Test
	public void Test01_CreateModel() {
		Model model = new Model("testModel", "2016", "v.1.0", "demo model");
		assertTrue(model.getName() == "testModel");
	}

	@Test
	public void Test02_ChangeModel() {
		Model model = new Model("testModel", "2016", "v.1.0", "demo model");
		assertTrue(model.getName() == "testModel");
		model.setName("testModel2");
		assertFalse(model.getName() == "testModel");
		assertTrue(model.getName() == "testModel2");
	}

}
