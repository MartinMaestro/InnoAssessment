package es.upm.miw.innoassessment.data.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.upm.miw.innoassessment.data.entities.AssessmentLine;
import es.upm.miw.innoassessment.data.entities.Dimension;
import es.upm.miw.innoassessment.data.entities.ModelItem;
import es.upm.miw.innoassessment.data.entities.Questionnaire;

public interface AssessmentLineDao extends JpaRepository<AssessmentLine, Integer>, AssessmentLineDaoExtended {

	List<AssessmentLine> findByModelItem(ModelItem modelItem);
	List<AssessmentLine> findByQuestionnaire(Questionnaire questionnarie);
	
	 
}