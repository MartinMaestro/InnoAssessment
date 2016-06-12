package es.upm.miw.innoassessment.business.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.upm.miw.innoassessment.business.wrapper.DimensionWrapper;
import es.upm.miw.innoassessment.data.daos.DimensionDao;
import es.upm.miw.innoassessment.data.entities.Dimension;

@Controller
public class DimensionController {

	private DimensionDao dimensionDao;

	@Autowired
	public void setDimensionDao(DimensionDao dimensionDao) {
		this.dimensionDao = dimensionDao;
	}

	public List<DimensionWrapper> showDimensions() {
		List<DimensionWrapper> dimensionWrapperList = new ArrayList<>();
		for (Dimension dimension : dimensionDao.findAllByOrderByIdAsc()) {
			dimensionWrapperList.add(new DimensionWrapper(dimension));
		}
		return dimensionWrapperList;
	}

	public List<DimensionWrapper> showDimensionsByQuestionnaireId(int questionnaireId) {
		List<DimensionWrapper> dimensionWrapperList = new ArrayList<>();
		for (Dimension dimension : dimensionDao.findByQuestionnaireId(questionnaireId)) {
			dimensionWrapperList.add(new DimensionWrapper(dimension));
		}
		return dimensionWrapperList;
	}

	public boolean deleteDimension(int id) {
		// return dimensionDao.deleteDimensionDao(id);
		dimensionDao.delete(id);
		return true;
	}

	public boolean createDimension(String name) {
		// return dimensionDao.createDimensionDao(name);
		dimensionDao.saveAndFlush(new Dimension(name));
		return true;
	}
}
