package es.upm.miw.innoassessment.business.wrapper;

import es.upm.miw.innoassessment.data.entities.AssessmentLine;
import es.upm.miw.innoassessment.data.entities.AssessmentType;

public class AssessmentLineWrapper {

    private AssessmentType type;

    public AssessmentLineWrapper() {
    }

    public AssessmentLineWrapper(AssessmentType type) {
        super();
        this.type = type;
      
    }

    public AssessmentLineWrapper(AssessmentLine  assessmentLine) {
        this(assessmentLine.getType());
    }

    

}
