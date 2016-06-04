package es.upm.miw.innoassessment.data.daos;

import org.springframework.beans.factory.annotation.Autowired;

import es.upm.miw.innoassessment.data.entities.Dimension;

public class DimensionDaoImpl implements DimensionDaoExtended {

	@Autowired
	DimensionDao dimensionDao;

	@Override
	public boolean createDimensionDao(String name) {
		Dimension dimension = new Dimension(name);
		dimensionDao.saveAndFlush(dimension);
		return true;
	}

	@Override
	public boolean deleteDimensionDao(int id) {
		dimensionDao.delete(id);
		return true;
	}

}
