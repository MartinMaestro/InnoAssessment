package es.upm.miw.innoassessment.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;

@Entity
public class LineValue {	
	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	@JoinColumn
	Evaluation evaluation;	
	
	@ManyToOne
	@JoinColumn
	private AssessmentLine assessmentLine;

	@Enumerated(EnumType.STRING)
	private ValueName valueName;
	
	@Column(nullable = false)
	private int valueData;

	public LineValue(Evaluation evaluation, AssessmentLine assessmentLine, ValueName valueName, int valueData) {
		this.evaluation = evaluation;
		this.assessmentLine = assessmentLine;
		this.valueName = valueName;
		this.valueData = valueData;
	}

}
