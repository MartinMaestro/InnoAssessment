package es.upm.miw.innoassessment.business.controllers;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.upm.miw.innoassessment.business.wrapper.ModelItemWrapper;
import es.upm.miw.innoassessment.data.daos.DimensionDao;
import es.upm.miw.innoassessment.data.daos.FactorDao;
import es.upm.miw.innoassessment.data.daos.ModelDao;
import es.upm.miw.innoassessment.data.daos.ModelItemDao;
import es.upm.miw.innoassessment.data.entities.ModelItem;
import es.upm.miw.innoassessment.data.entities.Model;
import es.upm.miw.innoassessment.data.entities.Dimension;

@Controller
public class ModelItemController {

	private ModelItemDao modelItemDao;

	private ModelDao modelDao;

	private DimensionDao dimensionDao;

	private FactorDao factorDao;

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
	
	/*
	public List<ModelItemWrapper> showModelItemsByModelAndDimension(int modelId, int dimensionId) {
		System.out.println("--- CONTROLLER - showModelItemsByModelByDimension - modelId:" + modelId + "-dimensionId:"+dimensionId);
		
		System.out.println("--- CONTROLLER - " + modelDao.count());
		Model model = modelDao.findOne(modelId);
		System.out.println("--- CONTROLLER - showModelItemsByModelByDimension - MODEL" + model);
		Dimension dimension = dimensionDao.findOne(dimensionId);
		System.out.println("--- CONTROLLER - showModelItemsByModelByDimension - DIMENSION" + dimension);
		List<ModelItemWrapper> modelItemWrapperList = new ArrayList<>();
		for (ModelItem modelItem : modelItemDao.findByModelAndDimension(model, dimension)) {
			modelItemWrapperList.add(new ModelItemWrapper(modelItem));
		}
		
		return modelItemWrapperList;
	}
*/

	public boolean createModelItem(int modelId, int dimensionId, int factorId, String impact, String weight,
			String interpretation, String help) {
		modelItemDao.saveAndFlush(new ModelItem(modelDao.findOne(modelId), dimensionDao.findOne(dimensionId),
				factorDao.findOne(factorId), impact, weight, interpretation, help));
		return true;
	}

	public boolean deleteModel(int id) {
		modelItemDao.delete(id);
		return true;
	}
}
