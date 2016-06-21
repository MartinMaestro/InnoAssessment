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

    public String getName(){
    	return name;
    }    
    
    public static ValueName getByName(String name){
    	switch(name){
			case "Unknown":
				return UNKNOWN;
			case "Not Applicable":
				return NOT_APPLICABLE;
			case "Very Few":
				return VERY_FEW;
			case "Few":
				return FEW;
			case "Medium":
				return MEDIUM;
			case "High":
				return HIGH;
			case "Very High":
				return VERY_HIGH;
    		default:
    			return null;
    	}
    }
    
}
