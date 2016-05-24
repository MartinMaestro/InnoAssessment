package es.upm.miw.innoassessment.data.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

@Entity
public class LineValue {
	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	@JoinColumn
	private Questionnarie questionnarie;

	@ManyToOne
	@JoinColumn
	private Product product;

	@Column(nullable = false)
	private String value;

	@Column(nullable = false)
	private String date;

	@Column(nullable = false)
	private String time;

	public LineValue(Questionnarie questionnarie, Product product, String value, String date, String time) {
		this.questionnarie = questionnarie;
		this.product = product;
		this.value = value;
		this.date = date;
		this.time = time;
	}

}
