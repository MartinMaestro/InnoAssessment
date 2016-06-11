package es.upm.miw.innoassessment.data.daos;

import es.upm.miw.innoassessment.data.entities.AssessmentLine;
import es.upm.miw.innoassessment.data.entities.Dimension;
import es.upm.miw.innoassessment.data.entities.Model;
import es.upm.miw.innoassessment.data.entities.ModelItem;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ModelItemDao extends JpaRepository<ModelItem, Integer> {
	
	List<ModelItem> findByDimension(Dimension dimension); 
	
	//List<ModelItem> findByModelByDimension(Model model,Dimension dimension);
	//@Query("select distinct author.name from Book bookjoin book.authorListauthor") 
	// @Query("select distinct author.name from ModelItem bookjoin book.authorListauthor") 
	// List<AssessmentLine>  findByModelAndDimension(); 
	
	//List<ModelItem> findByModel(Model model);
	//Model findByModelItem(ModelItem modelItem);
	/*
	@Query("select modelItem from ModelItem modelItem where modelItem.model = ?1 and modelItem.dimension = ?2")
	public List<ModelItem> findByModelAndDimension(Model model, Dimension dimension);
	*/
	
}
