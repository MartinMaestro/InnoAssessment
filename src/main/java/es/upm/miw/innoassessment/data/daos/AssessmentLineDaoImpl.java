package es.upm.miw.innoassessment.data.daos;

import org.springframework.beans.factory.annotation.Autowired;

public class AssessmentLineDaoImpl implements AssessmentLineDaoExtended {

    @Autowired
    AssessmentLineDao assessmentLineDao;
    
	@Override
	public boolean createAssessmentLineDao(String type) {
		// TODO Auto-generated method stub
		return false;
	}

}
