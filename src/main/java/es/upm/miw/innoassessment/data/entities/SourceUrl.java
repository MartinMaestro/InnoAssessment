package es.upm.miw.innoassessment.data.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

import javax.persistence.Column;

@Entity
public class SourceUrl {
	@Id
	@GeneratedValue
	private int id;

	@Column(nullable = false)
	private String url;

	public SourceUrl(String url) {
		this.url = url;
	}

}
