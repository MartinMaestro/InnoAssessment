package es.upm.miw.innoassessment.business.wrapper;

import es.upm.miw.innoassessment.data.entities.AssessmentLine;
import es.upm.miw.innoassessment.data.entities.AssessmentType;
import es.upm.miw.innoassessment.data.entities.Dimension;

public class DimensionWrapper {

	private int id;
    private String name;

    public DimensionWrapper() {
    }

    public DimensionWrapper(int id, String name) {
        super();
        this.id = id;
        this.name = name;
      
    }

    public DimensionWrapper(Dimension  dimension) {
        this(dimension.getId(), dimension.getName());
    }

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public Object getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

    

}
