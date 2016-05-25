package es.upm.miw.innoassessment.data.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import es.upm.miw.innoassessment.data.entities.Factor;


public interface FactorDao extends JpaRepository<Factor, Integer>{

}
