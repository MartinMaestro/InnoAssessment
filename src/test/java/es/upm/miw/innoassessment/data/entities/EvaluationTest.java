package es.upm.miw.innoassessment.data.entities;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import static org.junit.Assert.assertFalse;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class EvaluationTest {

	@Test
	public void Test01_CreateEvaluation() {
		Model model = new Model("testModel", "2016", "v.1.0", "demo model");
		assertTrue(model.getName() == "testModel");
		Questionnaire questionnaire = new Questionnaire(model, "testQuestionnaire", "v.1.0");
		assertTrue(questionnaire.getName() == "testQuestionnaire");
		Product product = new Product("test", "v0", "demo provider");
		assertTrue(product.getName() == "test");
		ProductVersion productVersion = new ProductVersion("testProductVersion", product);
		assertTrue(productVersion.getName() == "testProductVersion");
		Evaluation evaluation = new Evaluation(questionnaire, productVersion, new Date());
		assertTrue(evaluation.getQuestionnaire().getName() == "testQuestionnaire");
	}

	@Test
	public void Test02_ChangeEvaluation() {
		Model model = new Model("testModel", "2016", "v.1.0", "demo model");
		Questionnaire questionnaire = new Questionnaire(model, "testQuestionnaire", "v.1.0");
		Product product = new Product("test", "v0", "demo provider");
		ProductVersion productVersion = new ProductVersion("testProductVersion", product);
		Evaluation evaluation = new Evaluation(questionnaire, productVersion, new Date());
		assertTrue(evaluation.getQuestionnaire().getName() == "testQuestionnaire");
		Questionnaire questionnaire2 = new Questionnaire(model, "testQuestionnaire2", "v.1.0");
		evaluation.setQuestionnaire(questionnaire2);
		assertFalse(evaluation.getQuestionnaire().getName() == "testQuestionnaire");
		assertTrue(evaluation.getQuestionnaire().getName() == "testQuestionnaire2");
	}

}
