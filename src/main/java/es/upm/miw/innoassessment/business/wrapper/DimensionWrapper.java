package es.upm.miw.innoassessment.business.wrapper;

import es.upm.miw.innoassessment.data.entities.AssessmentLine;
import es.upm.miw.innoassessment.data.entities.AssessmentType;
import es.upm.miw.innoassessment.data.entities.Dimension;

public class DimensionWrapper {

	private int id;
    private String name;

    public DimensionWrapper() {
    }

    public DimensionWrapper(String name) {
        super();
        this.name = name;
      
    }

    public DimensionWrapper(Dimension  dimension) {
        this(dimension.getName());
    }

	public Object getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public Object getId() {
		// TODO Auto-generated method stub
		return id;
	}

    

}
