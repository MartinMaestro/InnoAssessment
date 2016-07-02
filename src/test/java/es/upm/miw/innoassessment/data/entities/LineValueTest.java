package es.upm.miw.innoassessment.data.entities;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import static org.junit.Assert.assertFalse;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class LineValueTest {

	@Test
	public void Test01_CreateLineValue() {
		Dimension dimension = new Dimension("testDimension");
		assertTrue(dimension.getName() == "testDimension");
		Factor factor = new Factor("testFactor", "test Factor");
		assertTrue(factor.getName() == "testFactor");
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
		ModelItem modelItem = new ModelItem(model, dimension, factor, "Positive", 0.1f, "demo model Item",
				"help model Item");
		assertTrue(modelItem.getModel().getName() == "testModel");
		AssessmentLine assessmentLine = new AssessmentLine(questionnaire, modelItem, AssessmentType.BOTH);
		assertTrue(assessmentLine.getType() == AssessmentType.BOTH);
		LineValue lineValue = new LineValue(evaluation, assessmentLine, ValueName.FEW, 0, null, null);
		assertTrue(lineValue.getValueName() == ValueName.FEW);
	}

	@Test
	public void Test02_ChangeLineValue() {
		Dimension dimension = new Dimension("testDimension");
		Factor factor = new Factor("testFactor", "test Factor");
		Model model = new Model("testModel", "2016", "v.1.0", "demo model");
		Questionnaire questionnaire = new Questionnaire(model, "testQuestionnaire", "v.1.0");
		Product product = new Product("test", "v0", "demo provider");
		ProductVersion productVersion = new ProductVersion("testProductVersion", product);
		Evaluation evaluation = new Evaluation(questionnaire, productVersion, new Date());
		ModelItem modelItem = new ModelItem(model, dimension, factor, "Positive", 0.1f, "demo model Item",
				"help model Item");
		AssessmentLine assessmentLine = new AssessmentLine(questionnaire, modelItem, AssessmentType.BOTH);
		LineValue lineValue = new LineValue(evaluation, assessmentLine, ValueName.FEW, 0, null, null);
		assertTrue(lineValue.getValueName() == ValueName.FEW);
		lineValue.setValueName(ValueName.MEDIUM);		
		assertFalse(lineValue.getValueName() == ValueName.FEW);
		assertTrue(lineValue.getValueName() == ValueName.MEDIUM);
	}

}
