package es.upm.miw.innoassessment.data.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.upm.miw.innoassessment.data.entities.Dimension;

public interface DimensionDao extends JpaRepository<Dimension, Integer>, DimensionDaoExtended {

	List<Dimension> findAllByOrderByIdAsc();

	@Query(value = "SELECT DISTINCT Dimension.id, Dimension.name FROM Dimension JOIN(ModelItem, AssessmentLine, Questionnaire) ON ( Dimension.id = ModelItem.dimension_id AND ModelItem.id = AssessmentLine.modelItem_id AND Questionnaire.id = AssessmentLine.questionnaire_id ) WHERE Questionnaire.id = ?1 ORDER BY Dimension.id", nativeQuery = true)
	List<Dimension> findByQuestionnaireId(int questionnaireId);
	
	Dimension findByName(String name);
	
}
