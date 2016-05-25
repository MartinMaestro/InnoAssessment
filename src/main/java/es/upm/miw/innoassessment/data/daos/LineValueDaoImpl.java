package es.upm.miw.innoassessment.data.daos;

import org.springframework.beans.factory.annotation.Autowired;

public class LineValueDaoImpl implements LineValueDaoExtended {

    @Autowired
    LineValueDao lineValueDao;
    
	@Override
	public boolean createLineValueDao(String value, String date, String time) {
		// TODO Auto-generated method stub
		return false;
	}

}
