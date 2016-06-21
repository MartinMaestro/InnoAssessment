package es.upm.miw.innoassessment.business.charts.representation;

import es.upm.miw.innoassessment.data.entities.AssessmentType;
import es.upm.miw.innoassessment.data.entities.ValueName;

public class RepresentationFactory implements RepresentationFactoryMethod {

	@Override
	public Representation createRepresentation(AssessmentType assessmentType, ValueName valueName) {
		switch(assessmentType){
		case POSITIVE:
			return new RadioPositive(valueName);
		case NEGATIVE:
			return new RadioNegative(valueName);
		case BOTH:
			return new RadioBoth(valueName);
		default:
			return null;
		}
	}

}
