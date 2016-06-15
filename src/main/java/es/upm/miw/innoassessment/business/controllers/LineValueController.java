package es.upm.miw.innoassessment.business.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.upm.miw.innoassessment.data.daos.AssessmentLineDao;
import es.upm.miw.innoassessment.data.daos.EvaluationDao;
import es.upm.miw.innoassessment.data.daos.LineValueDao;
import es.upm.miw.innoassessment.data.entities.AssessmentLine;
import es.upm.miw.innoassessment.data.entities.Evaluation;
import es.upm.miw.innoassessment.data.entities.LineValue;
import es.upm.miw.innoassessment.data.entities.ProductVersion;
import es.upm.miw.innoassessment.data.entities.Questionnaire;
import es.upm.miw.innoassessment.data.entities.SourceFile;
import es.upm.miw.innoassessment.data.entities.SourceUrl;
import es.upm.miw.innoassessment.data.entities.ValueName;

@Controller
public class LineValueController {

	private LineValueDao lineValueDao;
	
	private EvaluationDao evaluationDao;
	
	private AssessmentLineDao assessmentLineDao;

	@Autowired
	public void setLineValueDao(LineValueDao lineValueDao) {
		this.lineValueDao = lineValueDao;
	}
	
	@Autowired
	public void setEvaluationDao(EvaluationDao evaluationDao){
		this.evaluationDao = evaluationDao;
	}
	
	@Autowired
	public void setAssessmentLineDao(AssessmentLineDao assessmentLineDao) {
		this.assessmentLineDao = assessmentLineDao;
	}
	
	List<LineValue> findByEvaluationId(int evaluationId){
		return lineValueDao.findByEvaluationIdOrderByAssessmentLineId(evaluationId);
	}
	
	public boolean createLineValue(int evaluationId,int assessmentLineId,ValueName valueName, int valueData, List<SourceUrl> sourcesUrls, List<SourceFile> sourcesFiles) {
		Evaluation evaluation = evaluationDao.findOne(evaluationId);
		AssessmentLine assessmentLine = assessmentLineDao.findOne(assessmentLineId);
		lineValueDao.saveAndFlush(new LineValue(evaluation, assessmentLine,valueName,valueData,sourcesUrls,sourcesFiles));
		return true;
	}
}
