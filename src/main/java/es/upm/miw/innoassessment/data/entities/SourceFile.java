package es.upm.miw.innoassessment.data.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

@Entity
public class SourceFile {
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
	private String filename;

	@Column(nullable = false)
	private String realpath;

	public SourceFile(int id, Questionnarie questionnarie, LineValue lineValue, Product product, String date,
			String time, String filename, String realpath) {
		super();
		this.id = id;
		this.questionnarie = questionnarie;
		this.lineValue = lineValue;
		this.product = product;
		this.date = date;
		this.time = time;
		this.filename = filename;
		this.realpath = realpath;
	}

	

}
