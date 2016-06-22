package es.upm.miw.innoassessment.business.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.upm.miw.innoassessment.business.wrapper.ModelItemWrapper;
import es.upm.miw.innoassessment.data.daos.ModelItemDao;
import es.upm.miw.innoassessment.data.entities.ModelItem;
import es.upm.miw.innoassessment.data.entities.Model;
import es.upm.miw.innoassessment.data.entities.AssessmentType;
import es.upm.miw.innoassessment.data.entities.Dimension;
import es.upm.miw.innoassessment.data.entities.Factor;

@Controller
public class ModelItemController {

	private ModelItemDao modelItemDao;

	@Autowired
	public void setModelItemDao(ModelItemDao modelItemDao) {
		this.modelItemDao = modelItemDao;
	}

	public List<ModelItemWrapper> showModelItems() {
		List<ModelItemWrapper> modelItemWrapperList = new ArrayList<>();
		for (ModelItem modelItem : modelItemDao.findAll()) {
			modelItemWrapperList.add(new ModelItemWrapper(modelItem));
		}
		return modelItemWrapperList;
	}
	
	public List<ModelItemWrapper> showModelItemsOrderByIdDesc() {
		List<ModelItemWrapper> modelItemWrapperList = new ArrayList<>();
		for (ModelItem modelItem : modelItemDao.findAllByOrderByIdDesc()) {
			modelItemWrapperList.add(new ModelItemWrapper(modelItem));
		}
		return modelItemWrapperList;
	}

	@SuppressWarnings("static-access")
	public AssessmentType[] showAssessmentTypes() {
		AssessmentType assessmentType = null;
		return assessmentType.values();
	}

	public boolean createModelItem(int modelId, int dimensionId, int factorId, String impact, String weight,
			String interpretation, String help) {

		modelItemDao.saveAndFlush(new ModelItem(new Model(modelId), new Dimension(dimensionId), new Factor(factorId),
				impact, weight != null && !"".equals(weight)? Float.parseFloat(weight) :null, interpretation, help));
		return true;
	}

	public boolean deleteModel(int id) {
		modelItemDao.delete(id);
		return true;
	}
}
