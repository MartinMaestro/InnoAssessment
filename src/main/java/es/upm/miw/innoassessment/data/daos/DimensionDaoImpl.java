package es.upm.miw.innoassessment.data.daos;

import org.springframework.beans.factory.annotation.Autowired;

import es.upm.miw.innoassessment.data.entities.Dimension;

public class DimensionDaoImpl implements DimensionDaoExtended {

    @Autowired
    DimensionDao dimensionDao;
    
	@Override
	public boolean createDimensionDao(String name) {
		// TODO Auto-generated method stub
		System.out.println("------------ CREATE DIMENSION DAO " +  name);
		Dimension dimension = new Dimension(name);
		dimensionDao.saveAndFlush(dimension);
		return true;
	}

}
