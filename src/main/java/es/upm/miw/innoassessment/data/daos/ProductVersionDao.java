package es.upm.miw.innoassessment.data.daos;

import es.upm.miw.innoassessment.data.entities.Product;
import es.upm.miw.innoassessment.data.entities.ProductVersion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductVersionDao extends JpaRepository<ProductVersion, Integer> {

	List<ProductVersion> findByProduct(Product product);

	List<ProductVersion> findByProductId(int id);
}
