package es.upm.miw.innoassessment.business.wrapper;

import java.util.List;


public class ListModelItem {

	List<ModelItemWrapper> modelItemList;

	public ListModelItem() {
	}

	public ListModelItem(List<ModelItemWrapper> modelItemList) {
		super();
		this.modelItemList = modelItemList;

	}

	public List<ModelItemWrapper> getModelItemList() {
		return modelItemList;
	}

	public void setModelItemList(List<ModelItemWrapper> modelItemList) {
		this.modelItemList = modelItemList;
	}
	
	public void deleteFactorList(ModelItemWrapper modelItem) {
		modelItemList.remove(modelItem);
	}	

}
