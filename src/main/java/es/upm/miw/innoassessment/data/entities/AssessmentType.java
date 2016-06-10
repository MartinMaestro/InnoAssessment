package es.upm.miw.innoassessment.data.entities;

public enum AssessmentType {
    BOTH("RadioBoth"), 
    POSITIVE("RadioPositive"), 
    NEGATIVE("RadioNegative");
	
	private final String name;
	
	private AssessmentType(String name) {
		this.name = name;
	}

    public static AssessmentType getAssessmentTypeById(int i){
    	switch(i){
    		case 0:
    			return BOTH;
    		case 1:
    			return POSITIVE;
    		case 2:
    			return NEGATIVE;
    		default:
    			return null;
    	}
    }	

    public String assessmentTypeName(){
    	return name;
    }
    
}
