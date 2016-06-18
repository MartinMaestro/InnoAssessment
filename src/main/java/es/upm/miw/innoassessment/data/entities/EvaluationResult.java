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
	
	@Column(nullable = false)	
	private float percentageValue;	
	

	public EvaluationResult(Evaluation evaluation, Dimension dimension, EvaluationResultType evaluationResultType,
			float value, float percentageValue) {
		this.evaluation = evaluation;
		this.dimension = dimension;
		this.evaluationResultType = evaluationResultType;
		this.value = value;
		this.percentageValue = percentageValue;
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

	public float getPercentageValue() {
		return percentageValue;
	}

	public void setPercentageValue(float percentageValue) {
		this.percentageValue = percentageValue;
	}
	
	@Override
	public String toString(){
		return "{ \"id\":"+this.id+",\"evaluationId\":"+this.evaluation.getId()+",\"dimensionId\":"+this.dimension.getId()+",\"evaluationResultType\":\""+this.evaluationResultType.getName()+"\",\"value\":"+this.value+",\"percentageValue\":"+this.percentageValue+"}";
	}

}
