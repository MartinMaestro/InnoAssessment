package es.upm.miw.innoassessment.business.charts.representation;

import java.util.HashMap;

import es.upm.miw.innoassessment.data.entities.ValueName;

public class RadioBoth extends Representation {
	private static final HashMap<ValueName, Float> VALUES = new HashMap<ValueName, Float>();
	static{
		VALUES.put(ValueName.UNKNOWN, 0f);
		VALUES.put(ValueName.NOT_APPLICABLE, 9f);
		VALUES.put(ValueName.VERY_FEW, -5f);
		VALUES.put(ValueName.FEW, -2.5f);
		VALUES.put(ValueName.MEDIUM, 0f);
		VALUES.put(ValueName.HIGH, 2.5f);
		VALUES.put(ValueName.VERY_HIGH, 5f);
	}

	public RadioBoth(ValueName valueName) {		
		super(valueName);
		this.setValue(VALUES.get(valueName));
	}

	@Override
	public float getMinimum() {
		return VALUES.get(ValueName.VERY_FEW);
	}

	@Override
	public float getMaximum() {
		return VALUES.get(ValueName.VERY_HIGH);
	}

}
