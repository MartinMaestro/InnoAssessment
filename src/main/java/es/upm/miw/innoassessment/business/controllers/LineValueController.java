package es.upm.miw.innoassessment.business.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.upm.miw.innoassessment.data.daos.LineValueDao;
import es.upm.miw.innoassessment.data.entities.LineValue;

@Controller
public class LineValueController {

	private LineValueDao lineValueDao;

	@Autowired
	public void setModelDao(LineValueDao lineValueDao) {
		this.lineValueDao = lineValueDao;
	}
	
	List<LineValue> findByEvaluationId(int evaluationId){
		return lineValueDao.findByEvaluationIdOrderByAssessmentLineId(evaluationId);
	}
}
