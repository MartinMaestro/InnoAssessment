package es.upm.miw.innoassessment.data.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import es.upm.miw.innoassessment.data.entities.AssessmentLine;

public interface AssessmentLineDao extends JpaRepository<AssessmentLine, Integer>{

	
}