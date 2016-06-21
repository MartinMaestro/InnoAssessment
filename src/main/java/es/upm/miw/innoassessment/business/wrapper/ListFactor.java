package es.upm.miw.innoassessment.business.wrapper;

import java.util.List;


public class ListFactor {

	List<FactorWrapper> factorList;

	public ListFactor() {
	}

	public ListFactor(List<FactorWrapper> factorList) {
		super();
		this.factorList = factorList;

	}

	public List<FactorWrapper> getFactorList() {
		return factorList;
	}

	public void setFactorList(List<FactorWrapper> factorList) {
		this.factorList = factorList;
	}
	
	public void deleteFactorList(FactorWrapper factor) {
		factorList.remove(factor);
	}

}
