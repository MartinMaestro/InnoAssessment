package es.upm.miw.innoassessment.data.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.GeneratedValue;

import java.util.Date;

import javax.persistence.Column;

@Entity
public class LineValue {
	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	@JoinColumn
	private Questionnaire questionnaire;

	@ManyToOne
	@JoinColumn
	private AssessmentLine assessmentLine;

	@ManyToOne
	@JoinColumn
	private Product product;

	@Column(nullable = false)
	private String selectedValue;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date creationDate;

	@Temporal(TemporalType.TIME)
	@Column(nullable = false)
	private Date creationTime;

	public LineValue(Questionnaire questionnaire, AssessmentLine assessmentLine, Product product, String selectedValue, Date creationDate, Date creationTime) {
		this.questionnaire = questionnaire;
		this.assessmentLine = assessmentLine;
		this.product = product;
		this.selectedValue = selectedValue;
		this.creationDate = creationDate;
		this.creationTime = creationTime;
	}

}
