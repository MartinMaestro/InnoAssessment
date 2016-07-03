package es.upm.miw.innoassessment.data.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import es.upm.miw.innoassessment.data.entities.LineValue;


public interface LineValueDao extends JpaRepository<LineValue, Integer> {
	List<LineValue> findByEvaluationIdOrderByAssessmentLineId(int evaluationId);
}
