package es.upm.miw.innoassessment.business.charts.representation;

import java.util.HashMap;

import es.upm.miw.innoassessment.data.entities.ValueName;

public class RadioPositive extends Representation {
	private static final HashMap<ValueName, Float> VALUES = new HashMap<ValueName, Float>();
	static{
		VALUES.put(ValueName.UNKNOWN, 0f);
		VALUES.put(ValueName.NOT_APPLICABLE, 9f);
		VALUES.put(ValueName.VERY_FEW, 1f);
		VALUES.put(ValueName.FEW, 2f);
		VALUES.put(ValueName.MEDIUM, 3f);
		VALUES.put(ValueName.HIGH, 4f);
		VALUES.put(ValueName.VERY_HIGH, 5f);
	}

	public RadioPositive(ValueName valueName, Float weight) {		
		super(valueName, weight);
		this.setValue(VALUES.get(valueName));
	}

	@Override
	public float getMinimum() {
		return this.getWeight() != null? VALUES.get(ValueName.VERY_FEW)*this.getWeight(): VALUES.get(ValueName.VERY_FEW);
	}

	@Override
	public float getMaximum() {
		return this.getWeight() != null? VALUES.get(ValueName.VERY_HIGH)*this.getWeight(): VALUES.get(ValueName.VERY_HIGH);
	}

	@Override
	public float getOptimum() {
		return this.getWeight() != null? VALUES.get(ValueName.VERY_HIGH)*this.getWeight(): VALUES.get(ValueName.VERY_HIGH);
	}

}
