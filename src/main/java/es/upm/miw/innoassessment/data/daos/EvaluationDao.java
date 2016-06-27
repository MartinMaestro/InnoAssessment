package es.upm.miw.innoassessment.data.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.upm.miw.innoassessment.data.entities.Evaluation;

public interface EvaluationDao extends JpaRepository<Evaluation, Integer>{
	public List<Evaluation> findByProductVersionIdOrderByQuestionnaireId(int productVersionId);

	@Query(value = "SELECT DISTINCT Evaluation.id, Evaluation.creationTimeStamp , Evaluation.productVersion_id , Evaluation.questionnaire_id FROM Evaluation JOIN(ProductVersion, Product) ON ( ProductVersion.id = Evaluation.productVersion_id AND Product.id = ProductVersion.product_id ) WHERE Evaluation.questionnaire_id = ?1 ORDER BY Product.id", nativeQuery = true)
	public List<Evaluation> findByQuestionnaireIdOrderByProductId(int questionnarireId);
}
