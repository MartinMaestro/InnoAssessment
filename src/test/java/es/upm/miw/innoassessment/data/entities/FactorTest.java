package es.upm.miw.innoassessment.data.entities;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class FactorTest {

	@Test
	public void Test01_CreateFactor() {
		Factor factor = new Factor("testFactor", "test Factor");
		assertTrue(factor.getName() == "testFactor");
	}

	@Test
	public void Test02_ChangeFactor() {
		Factor factor = new Factor("testFactor", "test Factor");
		assertTrue(factor.getName() == "testFactor");
		factor.setName("testFactor2");
		assertFalse(factor.getName() == "testFactor");
		assertTrue(factor.getName() == "testFactor2");
	}

}
