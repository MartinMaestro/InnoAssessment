package es.upm.miw.innoassessment.business.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import es.upm.miw.innoassessment.business.wrapper.ModelWrapper;
import es.upm.miw.innoassessment.data.daos.ModelDao;
import es.upm.miw.innoassessment.data.entities.Model;

@Controller
public class ModelController {

	private ModelDao modelDao;

	@Autowired
	public void setModelDao(ModelDao modelDao) {
		this.modelDao = modelDao;
	}

	public List<ModelWrapper> showModels() {
		List<ModelWrapper> modelWrapperList = new ArrayList<>();
		for (Model model : modelDao.findAll()) {
			modelWrapperList.add(new ModelWrapper(model));
		}
		return modelWrapperList;
	}
	
	public ModelWrapper showModel(int modelId) {
		return new ModelWrapper(modelDao.findOne(modelId));
	}
	

	public boolean createModel(String name, String year, String version, String description) {
		if (exist(name)) {
			return false;
		}
		modelDao.saveAndFlush(new Model(name, year, version, description));
		return true;
	}

	public boolean deleteModel(int id) {
		modelDao.delete(id);
		return true;
	}
	
	public boolean exist(String name) {
		return modelDao.findByName(name) != null;
	}
}
