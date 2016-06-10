package es.upm.miw.innoassessment.data.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AssessmentLine {
	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	private Questionnaire questionnaire;

	@ManyToOne
	@JoinColumn
	private ModelItem modelItem;

	@Enumerated(EnumType.STRING)
	private AssessmentType type;

	public AssessmentLine() {
	}

	public AssessmentLine(Questionnaire questionnaire, ModelItem modelItem, AssessmentType type) {
		this.questionnaire = questionnaire;
		this.modelItem = modelItem;
		this.type = type;
	}

	public AssessmentLine(AssessmentType type) {
		this.type = type;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	public ModelItem getModelItem() {
		return modelItem;
	}

	public void setModelItem(ModelItem modelItem) {
		this.modelItem = modelItem;
	}
	
	public AssessmentType getType() {
		return type;
	}

	public void setType(AssessmentType type) {
		this.type = type;
	}
	

}
