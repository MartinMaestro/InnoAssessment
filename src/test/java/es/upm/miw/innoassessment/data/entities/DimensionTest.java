package es.upm.miw.innoassessment.data.entities;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class DimensionTest {

	@Test
	public void Test01_CreateDimension() {
		Dimension dimension = new Dimension("testDimension");
		assertTrue(dimension.getName() == "testDimension");
	}

	@Test
	public void Test02_ChangeDimension() {
		Dimension dimension = new Dimension("testDimension");
		assertTrue(dimension.getName() == "testDimension");
		dimension.setName("testDimension2");
		assertFalse(dimension.getName() == "testDimension");
		assertTrue(dimension.getName() == "testDimension2");
	}

}
