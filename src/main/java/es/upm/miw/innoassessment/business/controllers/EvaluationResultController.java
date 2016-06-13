package es.upm.miw.innoassessment.business.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.upm.miw.innoassessment.data.daos.EvaluationResultDao;
import es.upm.miw.innoassessment.data.entities.EvaluationResult;

@Controller
public class EvaluationResultController {
	private EvaluationResultDao evaluationResultDao;
	
	@Autowired
	public void setEvaluationResultDao(EvaluationResultDao evaluationResultDao){
		this.evaluationResultDao = evaluationResultDao;
	}
	
	public List<EvaluationResult> findByEvaluationId(int evaluationId){
		return evaluationResultDao.findByEvaluationIdOrderByDimensionId(evaluationId);
	}
	
}
