package es.upm.miw.innoassessment.data.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

@Entity
public class ModelItem {
	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	@JoinColumn
	private Model model;

	@ManyToOne
	@JoinColumn
	private Dimension dimension;
	
	@ManyToOne
	@JoinColumn
	private Factor factor;
	
	@Column(nullable = false)
	private String impact;

	@Column(nullable = false)
	private String weight;

	@Column(nullable = false)
	private String interpretation;
	
	@Column(nullable = false)
	private String help;

	public ModelItem(Model model, Dimension dimension, Factor factor, String impact, String weight,
			String interpretation, String help) {
		this.model = model;
		this.dimension = dimension;
		this.factor = factor;
		this.impact = impact;
		this.weight = weight;
		this.interpretation = interpretation;
		this.help = help;
	}

	
}
