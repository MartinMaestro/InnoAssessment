package es.upm.miw.innoassessment.data.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

@Entity
public class Factor {	
	@Id
	@GeneratedValue
	private int id;

	@Column(unique = true, nullable = false)
	private String name;

	@Column(nullable = false, length = 2048)
	private String definition;

	public Factor(String name, String definition) {
		this.name = name;
		this.definition = definition;
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

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	
	
	

	
}
