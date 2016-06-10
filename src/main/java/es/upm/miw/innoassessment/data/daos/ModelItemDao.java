package es.upm.miw.innoassessment.data.daos;

import es.upm.miw.innoassessment.data.entities.Dimension;
import es.upm.miw.innoassessment.data.entities.Model;
import es.upm.miw.innoassessment.data.entities.ModelItem;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelItemDao extends JpaRepository<ModelItem, Integer> {
	 //List<ModelItem> findByModelByDimension(Model model,Dimension dimension);
	
	//List<ModelItem> findByModel(Model model);
	//Model findByModelItem(ModelItem modelItem);
	/*
	@Query("select modelItem from ModelItem modelItem where modelItem.model = ?1 and modelItem.dimension = ?2")
	public List<ModelItem> findByModelAndDimension(Model model, Dimension dimension);
	*/
	
}
