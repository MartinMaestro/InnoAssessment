package es.upm.miw.innoassessment.data.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

@Entity
public class SourceUrl {
	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	@JoinColumn
	private Questionnarie questionnarie;

	@ManyToOne
	@JoinColumn
	private LineValue lineValue;

	@ManyToOne
	@JoinColumn
	private Product product;

	@Column(nullable = false)
	private String date;

	@Column(nullable = false)
	private String time;

	@Column(nullable = false)
	private String url;

	public SourceUrl(Questionnarie questionnarie, LineValue lineValue, Product product, String date,
			String time, String url) {
		this.questionnarie = questionnarie;
		this.lineValue = lineValue;
		this.product = product;
		this.date = date;
		this.time = time;
		this.url = url;
	}

}