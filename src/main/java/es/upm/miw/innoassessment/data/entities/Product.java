package es.upm.miw.innoassessment.data.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

@Entity
public class Product {
	@Id
	@GeneratedValue
	private int id;

	@Column(nullable = false, unique = true)
	private String name;

	@Column(nullable = false)
	private String provider;

	@Column(nullable = false)
	private String description;

	public Product() {

	}

	public Product(String name, String description, String provider) {
		this.name = name;
		this.provider = provider;
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

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
