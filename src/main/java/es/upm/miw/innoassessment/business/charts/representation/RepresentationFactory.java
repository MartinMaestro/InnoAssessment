package es.upm.miw.innoassessment.business.charts.representation;

import es.upm.miw.innoassessment.data.entities.AssessmentType;
import es.upm.miw.innoassessment.data.entities.ValueName;

public class RepresentationFactory implements RepresentationFactoryMethod {

	@Override
	public Representation createRepresentation(AssessmentType assessmentType, ValueName valueName, Float weight) {
		switch(assessmentType){
		case POSITIVE:
			return new RadioPositive(valueName, weight);
		case NEGATIVE:
			return new RadioNegative(valueName, weight);
		case BOTH:
			return new RadioBoth(valueName, weight);
		default:
			return null;
		}
	}

}
