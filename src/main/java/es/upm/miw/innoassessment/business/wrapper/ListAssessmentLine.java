package es.upm.miw.innoassessment.business.wrapper;

import java.util.List;

public class ListAssessmentLine {

	List<AssessmentLineWrapper> assessmentList;

	public ListAssessmentLine() {
	}

	public ListAssessmentLine(List<AssessmentLineWrapper> assessmentList) {
		super();
		this.assessmentList = assessmentList;

	}

	public List<AssessmentLineWrapper> getAssessmentList() {
		return assessmentList;
	}

	public void setAssessmentList(List<AssessmentLineWrapper> assessmentList) {
		this.assessmentList = assessmentList;
	}

	
	

}
