package es.upm.miw.innoassessment.business.charts.representation;

import es.upm.miw.innoassessment.data.entities.ValueName;

public abstract class Representation {

	private float value;
	private Float weight;
	private ValueName valueName;
	
	public Representation(ValueName valueName, Float weight) {
		this.valueName = valueName;
		this.weight = weight;
	}
	
	protected void setValue(float value){
		this.value = value;
	}

	public float getValue(){
		return value;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public ValueName getValueName(){
		return valueName;
	}
	
	public float getWeighedValue(){
		return weight != null? value*weight: value;
	}
	
	public abstract float getMinimum();
	
	public abstract float getMaximum();
	
	public abstract float getOptimum();
}
