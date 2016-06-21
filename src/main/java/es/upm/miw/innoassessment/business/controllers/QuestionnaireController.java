package es.upm.miw.innoassessment.business.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.upm.miw.innoassessment.business.wrapper.QuestionnaireWrapper;
import es.upm.miw.innoassessment.data.daos.QuestionnaireDao;
import es.upm.miw.innoassessment.data.entities.Model;
import es.upm.miw.innoassessment.data.entities.Questionnaire;

@Controller
public class QuestionnaireController {

	private QuestionnaireDao questionnaireDao;

	@Autowired
	public void setQuestionnaireDao(QuestionnaireDao questionnaireDao) {
		this.questionnaireDao = questionnaireDao;
	}

	public List<QuestionnaireWrapper> showQuestionnaires() {
		List<QuestionnaireWrapper> questionnaireWrapperList = new ArrayList<>();
		for (Questionnaire questionnaire : questionnaireDao.findAll()) {
			questionnaireWrapperList.add(new QuestionnaireWrapper(questionnaire));
		}
		return questionnaireWrapperList;
	}

	public QuestionnaireWrapper showQuestionnaire(int questionnaireId) {
		return new QuestionnaireWrapper(questionnaireDao.findOne(questionnaireId));
	}

	public List<QuestionnaireWrapper> showQuestionnairesByModel(int modelId) {
		List<QuestionnaireWrapper> questionnaireWrapperList = new ArrayList<>();
		for (Questionnaire questionnaire : questionnaireDao.findByModelId(modelId)) {
			questionnaireWrapperList.add(new QuestionnaireWrapper(questionnaire));
		}
		return questionnaireWrapperList;
	}

	public boolean createQuestionnaire(String name, String version, int modelId) {
		Model model = new Model(modelId);
		questionnaireDao.saveAndFlush(new Questionnaire(model, name, version));
		return true;
	}

	public boolean deleteQuestionnaire(int id) {
		questionnaireDao.delete(id);
		return true;
	}
}
