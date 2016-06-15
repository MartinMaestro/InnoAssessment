package es.upm.miw.innoassessment.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class EvaluationResult {
	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	@JoinColumn
	private Evaluation evaluation;

	@ManyToOne
	@JoinColumn
	private Dimension dimension;
	
	@Enumerated(EnumType.STRING)
	private EvaluationResultType evaluationResultType;
	
	@Column(nullable = false)	
	private float value;

	public EvaluationResult(Evaluation evaluation, Dimension dimension, EvaluationResultType evaluationResultType,
			float value) {
		super();
		this.evaluation = evaluation;
		this.dimension = dimension;
		this.evaluationResultType = evaluationResultType;
		this.value = value;
	}

	public EvaluationResult() {}

	public Evaluation getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	public EvaluationResultType getEvaluationResultType() {
		return evaluationResultType;
	}

	public void setEvaluationResultType(EvaluationResultType evaluationResultType) {
		this.evaluationResultType = evaluationResultType;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}	

}
