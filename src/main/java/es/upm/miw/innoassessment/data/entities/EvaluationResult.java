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

}
