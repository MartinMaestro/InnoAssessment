package es.upm.miw.innoassessment.business.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.upm.miw.innoassessment.data.daos.AssessmentLineDao;
import es.upm.miw.innoassessment.data.daos.EvaluationDao;
import es.upm.miw.innoassessment.data.daos.LineValueDao;
import es.upm.miw.innoassessment.data.entities.AssessmentLine;
import es.upm.miw.innoassessment.data.entities.Evaluation;
import es.upm.miw.innoassessment.data.entities.LineValue;
import es.upm.miw.innoassessment.data.entities.SourceFile;
import es.upm.miw.innoassessment.data.entities.SourceUrl;

@Controller
public class LineValueController {

	private LineValueDao lineValueDao;

	@Autowired
	public void setLineValueDao(LineValueDao lineValueDao) {
		this.lineValueDao = lineValueDao;
	}

	@Autowired
	public void setEvaluationDao(EvaluationDao evaluationDao) {
	}

	@Autowired
	public void setAssessmentLineDao(AssessmentLineDao assessmentLineDao) {
	}

	public List<LineValue> findByEvaluationId(int evaluationId) {
		return lineValueDao.findByEvaluationIdOrderByAssessmentLineId(evaluationId);
	}

	public boolean createLineValue(int evaluationId, int assessmentLineId, String valueName, int valueData,
			List<SourceUrl> sourcesUrls, List<SourceFile> sourcesFiles) {
		lineValueDao.saveAndFlush(new LineValue(new Evaluation(evaluationId), new AssessmentLine(assessmentLineId),
				valueName, valueData, sourcesUrls, sourcesFiles));
		return true;
	}
}
