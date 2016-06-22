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
	private Float weight;

	@Column(nullable = false, length = 2048)
	private String interpretation;

	@Column(nullable = false, length = 2048)
	private String help;

	public ModelItem() {

	}

	public ModelItem(Model model, Dimension dimension, Factor factor, String impact, Float weight,
			String interpretation, String help) {
		this.model = model;
		this.dimension = dimension;
		this.factor = factor;
		this.impact = impact;
		this.weight = weight;
		this.interpretation = interpretation;
		this.help = help;
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

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	public Factor getFactor() {
		return factor;
	}

	public void setFactor(Factor factor) {
		this.factor = factor;
	}

	public String getImpact() {
		return impact;
	}

	public void setImpact(String impact) {
		this.impact = impact;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public String getInterpretation() {
		return interpretation;
	}

	public void setInterpretation(String interpretation) {
		this.interpretation = interpretation;
	}

	public String getHelp() {
		return help;
	}

	public void setHelp(String help) {
		this.help = help;
	}

}
