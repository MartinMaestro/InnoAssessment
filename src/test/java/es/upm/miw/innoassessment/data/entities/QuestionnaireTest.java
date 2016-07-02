package es.upm.miw.innoassessment.data.entities;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class QuestionnaireTest {

	@Test
	public void Test01_CreateQuestionnaire() {
		Model model = new Model("testModel", "2016", "v.1.0", "demo model");
		assertTrue(model.getName() == "testModel");
		Questionnaire questionnaire = new Questionnaire(model, "testQuestionnaire", "v.1.0");
		assertTrue(questionnaire.getName() == "testQuestionnaire");
	}

	@Test
	public void Test02_ChangeQuestionnaire() {
		Model model = new Model("testModel", "2016", "v.1.0", "demo model");
		Questionnaire questionnaire = new Questionnaire(model, "testQuestionnaire", "v.1.0");
		assertTrue(questionnaire.getName() == "testQuestionnaire");
		questionnaire.setName("testQuestionnaire2");
		assertFalse(questionnaire.getName() == "testQuestionnaire");
		assertTrue(questionnaire.getName() == "testQuestionnaire2");
	}

}
