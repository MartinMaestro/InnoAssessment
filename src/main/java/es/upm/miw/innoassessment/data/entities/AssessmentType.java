package es.upm.miw.innoassessment.data.entities;

public enum AssessmentType {
    NETRAL, POSITIVE, NEGATIVE;

    public static AssessmentType getRoleById(int i){
    	switch(i){
    		case 0:
    			return NETRAL;
    		case 1:
    			return POSITIVE;
    		case 2:
    			return NEGATIVE;
    		default:
    			return null;
    	}
    }	

}
