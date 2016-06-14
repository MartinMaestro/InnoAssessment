package es.upm.miw.innoassessment.data.daos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import es.upm.miw.innoassessment.data.entities.Factor;

public interface FactorDao extends JpaRepository<Factor, Integer> {

	List<Factor> findAllByOrderByIdAsc();

	@Query(value = "SELECT DISTINCT Factor.id, Factor.name, Factor.definition FROM Factor JOIN(ModelItem, AssessmentLine, Questionnaire) ON ( Factor.id = ModelItem.factor_id AND ModelItem.id = AssessmentLine.modelItem_id AND Questionnaire.id = AssessmentLine.questionnaire_id ) WHERE Questionnaire.id = ?1 ORDER BY Dimension.id", nativeQuery = true)
	List<Factor> findByQuestionnaireId(int questionnaireId);
	
	Factor findByName(String name);

}
