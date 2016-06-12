package es.upm.miw.innoassessment.business.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.upm.miw.innoassessment.data.daos.EvaluationDao;
import es.upm.miw.innoassessment.data.entities.Evaluation;

@Controller
public class EvaluationController {
	
	private EvaluationDao evaluationDao;
	
	@Autowired
	public void setEvaluationDao(EvaluationDao evaluationDao){
		this.evaluationDao = evaluationDao;
	}
	
	public List<Evaluation> findByProductVersionId(int productVersionId){
		return evaluationDao.findByProductVersionIdOrderByQuestionnaireId(productVersionId);
	}
}
