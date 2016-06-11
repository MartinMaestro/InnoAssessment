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

}
