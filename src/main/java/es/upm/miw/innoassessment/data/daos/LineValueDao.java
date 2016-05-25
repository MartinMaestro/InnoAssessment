package es.upm.miw.innoassessment.data.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import es.upm.miw.innoassessment.data.entities.LineValue;


public interface LineValueDao extends JpaRepository<LineValue, Integer>{

}
