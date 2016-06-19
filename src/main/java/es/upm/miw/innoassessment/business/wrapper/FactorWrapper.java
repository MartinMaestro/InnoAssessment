package es.upm.miw.innoassessment.business.wrapper;

import es.upm.miw.innoassessment.data.entities.Factor;

public class FactorWrapper {

	private int id;
	private String name;
	private String definition;
	private String radioValue;

	
	public FactorWrapper() {
	}

	public FactorWrapper(int id, String name, String definition,String radioValue) {
		super();
		this.id = id;
		this.name = name;
		this.definition = definition;
		this.radioValue = radioValue;
	}

	public FactorWrapper(Factor factor) {
		this(factor.getId(), factor.getName(), factor.getDefinition(),null);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public String getRadioValue() {
		return radioValue;
	}

	public void setRadioValue(String radioValue) {
		this.radioValue = radioValue;
	}

}
