package es.upm.miw.innoassessment.data.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import es.upm.miw.innoassessment.data.entities.Dimension;


public interface DimensionDao extends JpaRepository<Dimension, Integer>{

}