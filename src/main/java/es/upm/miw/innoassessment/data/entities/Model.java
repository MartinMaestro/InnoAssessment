package es.upm.miw.innoassessment.data.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

@Entity
public class Model {
	@Id
	@GeneratedValue
	private int id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String year;

	@Column(nullable = false)
	private String version;

	@Column(nullable = false)
	private String description;
	
	@OneToMany(cascade=CascadeType.ALL, 
	        mappedBy = "model", orphanRemoval = true)
	private List<ModelItem> modelItems;

	public Model() {
	}

	public Model (int id){
		this.id = id;
	}
	public Model(String name, String year, String version, String description) {
		this.name = name;
		this.year = year;
		this.version = version;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ModelItem> getModelItems() {
		return modelItems;
	}

	public void setModelItems(List<ModelItem> modelItems) {
		this.modelItems = modelItems;
	}

}
