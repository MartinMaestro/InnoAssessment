package es.upm.miw.innoassessment.business.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.upm.miw.innoassessment.business.wrapper.AssessmentLineWrapper;
import es.upm.miw.innoassessment.data.daos.AssessmentLineDao;
import es.upm.miw.innoassessment.data.daos.DimensionDao;
import es.upm.miw.innoassessment.data.daos.ModelItemDao;
import es.upm.miw.innoassessment.data.daos.QuestionnaireDao;
import es.upm.miw.innoassessment.data.entities.AssessmentLine;
import es.upm.miw.innoassessment.data.entities.AssessmentType;
import es.upm.miw.innoassessment.data.entities.ModelItem;
import es.upm.miw.innoassessment.data.entities.Questionnaire;

@Controller
public class AssessmentLineController {

	private AssessmentLineDao assessmentLineDao;

	private DimensionDao dimensionDao;

	private ModelItemDao modelItemDao;

	private QuestionnaireDao questionnaireDao;

	@Autowired
	public void setAssessmentLineDao(AssessmentLineDao assessmentLineDao) {
		this.assessmentLineDao = assessmentLineDao;
	}

	@Autowired
	public void setDimensionDao(DimensionDao dimensionDao) {
		this.dimensionDao = dimensionDao;
	}

	@Autowired
	public void setModelItemDao(ModelItemDao modelItemDao) {
		this.modelItemDao = modelItemDao;
	}

	@Autowired
	public void setQuestionnaireDao(QuestionnaireDao questionnaireDao) {
		this.questionnaireDao = questionnaireDao;
	}

	public List<AssessmentLineWrapper> showAssessmentLines() {
		List<AssessmentLineWrapper> assessmentLineWrapperList = new ArrayList<>();
		for (AssessmentLine assessmentLine : assessmentLineDao.findAll()) {
			assessmentLineWrapperList.add(new AssessmentLineWrapper(assessmentLine));
		}
		return assessmentLineWrapperList;
	}

	public List<AssessmentLineWrapper> showAssessmentLinesByDimension(int dimensionId) {
		List<AssessmentLineWrapper> assessmentLineWrapperList = new ArrayList<>();
		for (AssessmentLine assessmentLine : assessmentLineDao.findAll()) {
			if (assessmentLine.getModelItem().getDimension().getId() == dimensionId) {
				assessmentLineWrapperList.add(new AssessmentLineWrapper(assessmentLine));
			}
		}
		return assessmentLineWrapperList;
	}

	public List<AssessmentLineWrapper> showAssessmentLinesByQuestionnaire(int questionnaireId) {
		List<AssessmentLineWrapper> assessmentLineWrapperList = new ArrayList<>();
		for (AssessmentLine assessmentLine : assessmentLineDao.findByQuestionnaireId(questionnaireId)) {
			assessmentLineWrapperList.add(new AssessmentLineWrapper(assessmentLine));
		}
		return assessmentLineWrapperList;
	}

	public boolean createAssessmentLine(int questionnaireId, int modelItemId, String type) {
		Questionnaire questionnaire = questionnaireDao.findOne(questionnaireId);
		ModelItem modelItem = modelItemDao.findOne(modelItemId);
		assessmentLineDao.saveAndFlush(new AssessmentLine(questionnaire, modelItem, type));
		return true;
	}

}
