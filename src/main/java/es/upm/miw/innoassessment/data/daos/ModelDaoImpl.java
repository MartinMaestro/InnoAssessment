package es.upm.miw.innoassessment.data.daos;

import org.springframework.beans.factory.annotation.Autowired;

public class ModelDaoImpl implements ModelDaoExtended {

    @Autowired
    ModelDao modelDao;
    
	@Override
	public boolean createModelDao(String name, String year, String version, String description) {
		// TODO Auto-generated method stub
		return false;
	}

}
