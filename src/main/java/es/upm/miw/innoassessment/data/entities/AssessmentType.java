package es.upm.miw.innoassessment.data.entities;

public enum AssessmentType {
    BOTH("RadioBoth"), 
    POSITIVE("RadioPositive"), 
    NEGATIVE("RadioNegative");
	
	private final String name;
	
	private AssessmentType(String name) {
		this.name = name;
	}

    public String getName(){
    	return name;
    }
    
}
