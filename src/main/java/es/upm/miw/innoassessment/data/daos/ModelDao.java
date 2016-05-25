package es.upm.miw.innoassessment.data.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import es.upm.miw.innoassessment.data.entities.Model;

public interface ModelDao extends JpaRepository<Model, Integer>{

}
