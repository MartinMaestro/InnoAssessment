package es.upm.miw.innoassessment.data.daos;

import es.upm.miw.innoassessment.data.entities.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Integer> {

	Product findByName(String name);

}
