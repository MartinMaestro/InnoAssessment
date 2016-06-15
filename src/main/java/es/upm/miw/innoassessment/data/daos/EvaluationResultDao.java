package es.upm.miw.innoassessment.data.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.upm.miw.innoassessment.data.entities.EvaluationResult;

public interface EvaluationResultDao extends JpaRepository<EvaluationResult, Integer> {
	List<EvaluationResult> findByEvaluationIdOrderByEvaluationResultType(int evaluationId);
}
