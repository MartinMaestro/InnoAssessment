package es.upm.miw.innoassessment.business.charts.representation;

import es.upm.miw.innoassessment.data.entities.ValueName;

public abstract class Representation {
	
	private float value;
	private ValueName valueName;
	
	public Representation(ValueName valueName) {
		this.valueName = valueName;
	}
	
	protected void setValue(float value){
		this.value = value;
	}

	public float getValue(){
		return value;
	}

	public ValueName getValueName(){
		return valueName;
	}
	
	public abstract float getMinimum();
	
	public abstract float getMaximum();
}
