package es.upm.miw.innoassessment.business.charts.representation;

import es.upm.miw.innoassessment.data.entities.AssessmentType;
import es.upm.miw.innoassessment.data.entities.ValueName;

public interface RepresentationFactoryMethod {

	Representation createRepresentation(AssessmentType assessmentType, ValueName valueName, Float weight);
	
}
