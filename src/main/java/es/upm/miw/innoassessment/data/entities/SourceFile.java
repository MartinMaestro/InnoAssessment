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
public class SourceFile {
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

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date creationDate;

	@Temporal(TemporalType.TIME)
	@Column(nullable = false)
	private Date creationTime;

	@Column(nullable = false)
	private String filename;

	@Column(nullable = false)
	private String realpath;

	public SourceFile(Questionnaire questionnaire, AssessmentLine assessmentLine, Product product, Date creationDate,
					  Date creationTime, String filename, String realpath) {
		this.questionnaire = questionnaire;
		this.assessmentLine = assessmentLine;
		this.product = product;
		this.creationDate = creationDate;
		this.creationTime = creationTime;
		this.filename = filename;
		this.realpath = realpath;
	}

	

}
