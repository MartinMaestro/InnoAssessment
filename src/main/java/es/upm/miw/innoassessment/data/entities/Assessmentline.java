package es.upm.miw.innoassessment.data.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

@Entity
public class Assessmentline {
	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	@JoinColumn
	private Questionnarie questionnarie;

	@ManyToOne
	@JoinColumn
	private ModelItem modelItem;
	
	
	@Column(nullable = false)
	private String type;


	public Assessmentline(int id, Questionnarie questionnarie, ModelItem modelItem, String type) {
		super();
		this.id = id;
		this.questionnarie = questionnarie;
		this.modelItem = modelItem;
		this.type = type;
	}
	
}
