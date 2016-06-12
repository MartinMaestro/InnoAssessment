package es.upm.miw.innoassessment.data.daos;

import es.upm.miw.innoassessment.data.entities.Model;
import es.upm.miw.innoassessment.data.entities.Questionnaire;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionnaireDao extends JpaRepository<Questionnaire, Integer> {
	List<Questionnaire> findByModel(Model model);
	List<Questionnaire> findByModelId(int id);
	
	
}
