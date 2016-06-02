package es.upm.miw.innoassessment.business.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.upm.miw.innoassessment.business.wrapper.AssessmentLineWrapper;
import es.upm.miw.innoassessment.data.daos.AssessmentLineDao;
import es.upm.miw.innoassessment.data.entities.AssessmentLine;

@Controller
public class AssessmentLineController {

    private AssessmentLineDao assessmentLineDao;
    
    @Autowired
    public void setAssessmentLineDao(AssessmentLineDao assessmentLineDao) {
        this.assessmentLineDao = assessmentLineDao;
    }

    
    public List<AssessmentLineWrapper> showAssessmentLines() {
        List<AssessmentLineWrapper> assessmentLineWrapperList = new ArrayList<>();
        for (AssessmentLine assessmentLine : assessmentLineDao.findAll()) {
        	assessmentLineWrapperList.add(new AssessmentLineWrapper(assessmentLine));
        }
        return assessmentLineWrapperList;
    }
    
   

}
