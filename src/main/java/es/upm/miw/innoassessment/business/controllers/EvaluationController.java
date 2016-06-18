package es.upm.miw.innoassessment.business.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.upm.miw.innoassessment.data.daos.EvaluationDao;
import es.upm.miw.innoassessment.data.daos.ProductVersionDao;
import es.upm.miw.innoassessment.data.daos.QuestionnaireDao;
import es.upm.miw.innoassessment.data.entities.Evaluation;
import es.upm.miw.innoassessment.data.entities.ProductVersion;
import es.upm.miw.innoassessment.data.entities.Questionnaire;

@Controller
public class EvaluationController {
	
	private EvaluationDao evaluationDao;
	
	private QuestionnaireDao questionnaireDao;
	
	private ProductVersionDao productVersionDao;

	
	@Autowired
	public void setEvaluationDao(EvaluationDao evaluationDao){
		this.evaluationDao = evaluationDao;
	}
	
	@Autowired
	public void setQuestionnaireDao(QuestionnaireDao questionnaireDao) {
		this.questionnaireDao = questionnaireDao;
	}
	
	@Autowired
	public void setproductVersionDao(ProductVersionDao productVersionDao) {
		this.productVersionDao = productVersionDao;
	}
	
	public List<Evaluation> findByProductVersionId(int productVersionId){
		return evaluationDao.findByProductVersionIdOrderByQuestionnaireId(productVersionId);
	}
	
	public Evaluation findOne(int evaluationId){
		return evaluationDao.findOne(evaluationId);
	}
	
	public int createEvaluation(int questionnaireId,int productVersionId) {
		//Calendar fecha = Calendar.getInstance();	
		//TODO MIRAR TIPO FECHA EVALUATION Date --> Calendar
		System.out.println("------------- CONTROLLER PRESENTER QuestionnaireId: "+ questionnaireId+ " - ProductId"+productVersionId  );
		Date fecha = new Date();
		Evaluation evaluation = new Evaluation(new Questionnaire(questionnaireId), new ProductVersion(productVersionId),fecha);
		evaluationDao.saveAndFlush(evaluation);
		return evaluation.getId();
	}
}
