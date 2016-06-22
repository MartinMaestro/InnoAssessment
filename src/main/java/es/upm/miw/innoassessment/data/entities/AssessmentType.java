package es.upm.miw.innoassessment.data.entities;

public enum AssessmentType {
	BOTH("RadioBoth"), POSITIVE("RadioPositive"), NEGATIVE("RadioNegative");

	private final String name;

	private AssessmentType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}


	public static AssessmentType getByName(String name) {
		switch (name) {
		case "RadioBoth":
			return BOTH;
		case "RadioPositive":
			return POSITIVE;
		case "RadioNegative":
			return NEGATIVE;
		default:
			return null;
		}
	}
	
	public static AssessmentType getByName2(String name) {
		switch (name) {
		case "Both":
			return BOTH;
		case "both":
			return BOTH;
		case "Positive":
			return POSITIVE;
		case "positive":
			return POSITIVE;
		case "Negative":
			return NEGATIVE;
		case "negative":
			return NEGATIVE;
		default:
			return null;
		}
	}

}
