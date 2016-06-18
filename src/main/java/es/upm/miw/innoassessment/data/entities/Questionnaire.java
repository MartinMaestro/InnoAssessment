package es.upm.miw.innoassessment.data.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

@Entity
public class Questionnaire {
	@Id
	@GeneratedValue
	private int id; 

	@ManyToOne
	@JoinColumn
	private Model model;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String version;

	public Questionnaire() {

	}
	public Questionnaire(int id){
		this.id = id;
		
	}
	
	public Questionnaire(Model model, String name, String version) {
		this.model = model;
		this.name = name;
		this.version = version;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	

}
