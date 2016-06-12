package es.upm.miw.innoassessment.data.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.upm.miw.innoassessment.data.entities.Evaluation;

public interface EvaluationDao extends JpaRepository<Evaluation, Integer>{
	public List<Evaluation> findByProductVersionIdOrderByQuestionnaireId(int productVersionId);
}
