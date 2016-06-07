package es.upm.miw.innoassessment.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProductVersion {
	@Id
	@GeneratedValue
	private int id;

	@Column(nullable = false)
	private String name;	

	@ManyToOne
	@JoinColumn
	private Product product;

	public ProductVersion(String name, Product product) {
		this.name = name;
		this.product = product;
	}
	
}
