package es.upm.miw.innoassessment.business.wrapper;

import es.upm.miw.innoassessment.data.entities.LineValue;

public class LineValueWrapper {
	private int id;
	private int evaluationId;
	private int assessmentLineId;
	private String radioValue;
	private LineValue lineValue;

	public LineValueWrapper() {}
	
	public LineValueWrapper(int id, int evaluationId, int assessmentLineId, String radioValue, LineValue lineValue) {
		super();
		this.id = id;
		this.evaluationId = evaluationId;
		this.assessmentLineId = assessmentLineId;
		this.radioValue = radioValue;
		this.lineValue = lineValue;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEvaluationId() {
		return evaluationId;
	}

	public void setEvaluationId(int evaluationId) {
		this.evaluationId = evaluationId;
	}

	public int getAssessmentLineId() {
		return assessmentLineId;
	}

	public void setAssessmentLineId(int assessmentLineId) {
		this.assessmentLineId = assessmentLineId;
	}

	public String getRadioValue() {
		return radioValue;
	}

	public void setRadioValue(String radioValue) {
		this.radioValue = radioValue;
	}

	public LineValue getLineValue() {
		return lineValue;
	}

	public void setLineValue(LineValue lineValue) {
		this.lineValue = lineValue;
	}
	
}
