package es.upm.miw.innoassessment.business.wrapper;

import java.util.List;

public class ListLineValue {

	List<LineValueWrapper> lineValueWrapperList;

	public ListLineValue() {
	}

	public ListLineValue(List<LineValueWrapper> lineValueWrapperList) {
		super();
		this.lineValueWrapperList = lineValueWrapperList;

	}

	public List<LineValueWrapper> getLineValueWrapperList() {
		return lineValueWrapperList;
	}

	public void setLineValueWrapperList(List<LineValueWrapper> lineValueList) {
		this.lineValueWrapperList = lineValueList;
	}

	
	

}
