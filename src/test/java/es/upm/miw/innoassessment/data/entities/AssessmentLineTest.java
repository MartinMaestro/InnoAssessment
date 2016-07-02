package es.upm.miw.innoassessment.data.entities;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class AssessmentLineTest {

	
	@Test
	public void Test01_CreateAssessmentLine() {
		Model model = new Model("testModel", "2016", "v.1.0", "demo model");
		assertTrue(model.getName() == "testModel");
		Dimension dimension = new Dimension("testDimension");
		assertTrue(dimension.getName() == "testDimension");
		Factor factor = new Factor("testFactor", "test Factor");
		assertTrue(factor.getName() == "testFactor");
		Questionnaire questionnaire = new Questionnaire(model, "testQuestionnaire", "v.1.0");
		assertTrue(questionnaire.getName() == "testQuestionnaire");		
		ModelItem modelItem = new ModelItem(model, dimension, factor, "Positive", 0.1f, "demo model Item",
				"help model Item");
		assertTrue(modelItem.getModel().getName() == "testModel");
		AssessmentLine assessmentLine = new AssessmentLine(questionnaire,modelItem,AssessmentType.BOTH);
		assertTrue(assessmentLine.getType() == AssessmentType.BOTH);
	}

	@Test
	public void Test02_ChangeAssessmentLine() {
		Model model = new Model("testModel", "2016", "v.1.0", "demo model");
		Dimension dimension = new Dimension("testDimension");
		Factor factor = new Factor("testFactor", "test Factor");
		Questionnaire questionnaire = new Questionnaire(model, "testQuestionnaire", "v.1.0");
		ModelItem modelItem = new ModelItem(model, dimension, factor, "Positive", 0.1f, "demo model Item",
				"help model Item");
		AssessmentLine assessmentLine = new AssessmentLine(questionnaire,modelItem,AssessmentType.BOTH);
		assertTrue(assessmentLine.getType() == AssessmentType.BOTH);
		assessmentLine.setType(AssessmentType.POSITIVE);		
		assertFalse(assessmentLine.getType() == AssessmentType.BOTH);
		assertTrue(assessmentLine.getType() == AssessmentType.POSITIVE);
	}

}
