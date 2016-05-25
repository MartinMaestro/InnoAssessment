package es.upm.miw.innoassessment.data.daos;

import es.upm.miw.innoassessment.data.entities.SourceUrl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SourceUrlDao extends JpaRepository<SourceUrl, Integer>{
}
