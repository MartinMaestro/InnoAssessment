package es.upm.miw.innoassessment.data.daos;

import es.upm.miw.innoassessment.data.entities.SourceFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SourceFileDao extends JpaRepository<SourceFile, Integer> {
}
