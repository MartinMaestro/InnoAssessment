package es.upm.miw.innoassessment.data.entities;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ModelItemTest {

	@Test
	public void Test01_CreateModelItem() {
		Model model = new Model("testModel", "2016", "v.1.0", "demo model");
		assertTrue(model.getName() == "testModel");
		Dimension dimension = new Dimension("testDimension");
		assertTrue(dimension.getName() == "testDimension");
		Factor factor = new Factor("testFactor", "test Factor");
		assertTrue(factor.getName() == "testFactor");
		ModelItem modelItem = new ModelItem(model, dimension, factor, "Positive", 0.1f, "demo model Item",
				"help model Item");
		assertTrue(modelItem.getModel().getName() == "testModel");
	}

	@Test
	public void Test02_ChangeModelItem() {
		Model model = new Model("testModel", "2016", "v.1.0", "demo model");
		Dimension dimension = new Dimension("testDimension");
		Factor factor = new Factor("testFactor", "test Factor");
		ModelItem modelItem = new ModelItem(model, dimension, factor, "Positive", 0.1f, "demo model Item",
				"help model Item");
		assertTrue(modelItem.getModel().getName() == "testModel");
		modelItem.getModel().setName("testModel2");
		assertFalse(modelItem.getModel().getName() == "testModel");
		assertTrue(modelItem.getModel().getName() == "testModel2");
	}

}
