package es.upm.miw.innoassessment.data.entities;

public enum ValueName {
    UNKNOWN("Unknown"), 
    NOT_APPLICABLE("Not Applicable"), 
    VERY_FEW("Very Few"),
    FEW("Few"), 
    MEDIUM("Medium"),
    HIGH("High"), 
    VERY_HIGH("Very High");
	
	private final String name;
	
	private ValueName(String name) {
		this.name = name;
	}

    public static ValueName getValueNameById(int i){
    	switch(i){
    		case 0:
    			return UNKNOWN;
    		case 1:
    			return NOT_APPLICABLE;
    		case 2:
    			return VERY_FEW;
    		case 3:
    			return FEW;
    		case 4:
    			return MEDIUM;
    		case 5:
    			return HIGH;
    		case 6:
    			return VERY_HIGH;
    		default:
    			return null;
    	}
    }	

    public String valueNameName(){
    	return name;
    }

}
