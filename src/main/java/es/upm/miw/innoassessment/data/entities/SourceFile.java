package es.upm.miw.innoassessment.data.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;

import javax.persistence.Column;

@Entity
public class SourceFile {
	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	@JoinColumn
	Evaluation evaluation;

	@ManyToOne
	@JoinColumn
	private AssessmentLine assessmentLine;

	@Column(nullable = false)
	private String filename;

	@Column(nullable = false)
	private String realpath;

	public SourceFile(Evaluation evaluation, AssessmentLine assessmentLine, String filename, String realpath) {
		this.evaluation = evaluation;
		this.assessmentLine = assessmentLine;
		this.filename = filename;
		this.realpath = realpath;
	}

	

}
