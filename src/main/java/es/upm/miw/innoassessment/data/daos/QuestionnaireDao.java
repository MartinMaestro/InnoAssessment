package es.upm.miw.innoassessment.data.daos;

import es.upm.miw.innoassessment.data.entities.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionnaireDao extends JpaRepository<Questionnaire, Integer> {
}
