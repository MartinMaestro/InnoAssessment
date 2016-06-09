package es.upm.miw.innoassessment.data.entities;

public enum EvaluationResultType {
    REAL_DIMENSION_IMPACT("Real Dimension impact"), 
    MAXIMUM_ACHIEVABLE_IMPACT("Maximum achievable impact"), 
    MINIMUM_ACHIEVABLE_IMPACT("Minimum achievable impact"),
    OPTIMUM_ACHIEVABLE_IMPACT("Optimum achievable impact"), 
    UPPER_LIMIT_IMPACT("Upper limit impact"),
    LOWER_LIMIT_IMPACT("Lower limit impact"), 
    OPTIMUM_LIMIT_IMPACT("Optimum Upper limit impact");
	
	private final String name;
	
	private EvaluationResultType(String name) {
		this.name = name;
	}

    public static EvaluationResultType getEvaluationResultTypeById(int i){
    	switch(i){
    		case 0:
    			return REAL_DIMENSION_IMPACT;
    		case 1:
    			return MAXIMUM_ACHIEVABLE_IMPACT;
    		case 2:
    			return MINIMUM_ACHIEVABLE_IMPACT;
    		case 3:
    			return OPTIMUM_ACHIEVABLE_IMPACT;
    		case 4:
    			return UPPER_LIMIT_IMPACT;
    		case 5:
    			return LOWER_LIMIT_IMPACT;
    		case 6:
    			return OPTIMUM_LIMIT_IMPACT;
    		default:
    			return null;
    	}
    }	

    public String getName(){
    	return name;
    }

}
