package es.upm.miw.innoassessment.data.daos;

import es.upm.miw.innoassessment.data.entities.Dimension;
import es.upm.miw.innoassessment.data.entities.ModelItem;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelItemDao extends JpaRepository<ModelItem, Integer> {

	List<ModelItem> findByDimension(Dimension dimension);

	List<ModelItem> findAllByOrderByIdDesc();

}
