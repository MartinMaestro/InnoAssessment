package es.upm.miw.innoassessment.data.daos;

import es.upm.miw.innoassessment.data.entities.ModelItem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ModelItemDao extends JpaRepository<ModelItem, Integer> {
}
