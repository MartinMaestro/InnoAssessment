package es.upm.miw.innoassessment.data.entities;

public enum EvaluationResultType {
    REAL_DIMENSION_IMPACT("Real Dimension Impact"), 
    MAXIMUM_ACHIEVABLE_IMPACT("Maximum Achievable Impact"), 
    MINIMUM_ACHIEVABLE_IMPACT("Minimum Achievable Impact"),
    OPTIMUM_ACHIEVABLE_IMPACT("Optimum Achievable Impact"), 
    UPPER_LIMIT_IMPACT("Upper Limit Impact"),
    LOWER_LIMIT_IMPACT("Lower Limit Impact"), 
    OPTIMUM_LIMIT_IMPACT("Optimum Upper Limit Impact");
	
	private final String name;
	
	private EvaluationResultType(String name) {
		this.name = name;
	}

    public String getName(){
    	return name;
    }

}
