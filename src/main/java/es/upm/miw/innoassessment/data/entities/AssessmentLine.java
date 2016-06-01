package es.upm.miw.innoassessment.data.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

@Entity
@Table(name="AssessmentLines")
public class AssessmentLine {
	@Id
	@GeneratedValue
	@Column(name="assessmentLineId")
	private int id;

	@ManyToOne
	@JoinColumn(name="questionnaireId")
	private Questionnaire questionnaire;

	@ManyToOne
	@JoinColumn
	private ModelItem modelItem;
	
	
	@Column(nullable = false)
	private String type;

	public AssessmentLine(Questionnaire questionnaire, ModelItem modelItem, String type) {
		this.questionnaire = questionnaire;
		this.modelItem = modelItem;
		this.type = type;
	}
	
}
