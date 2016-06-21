package es.upm.miw.innoassessment.data.entities;

import java.util.Arrays;
import java.util.List;

public enum AssessmentType {
	BOTH("RadioBoth"), POSITIVE("RadioPositive"), NEGATIVE("RadioNegative");

	private final String name;

	private AssessmentType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static String getByName(String name) {
		switch (name) {
		case "RadioBoth":
			return "BOTH";
		case "RadioPositive":
			return "POSITIVE";
		case "RadioNegative":
			return "NEGATIVE";
		default:
			return null;
		}
	}

}
