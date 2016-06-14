package es.upm.miw.innoassessment.business.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.upm.miw.innoassessment.business.wrapper.FactorWrapper;
import es.upm.miw.innoassessment.data.daos.FactorDao;
import es.upm.miw.innoassessment.data.entities.Factor;

@Controller
public class FactorController {

	private FactorDao factorDao;

	@Autowired
	public void setFactorDao(FactorDao factorDao) {
		this.factorDao = factorDao;
	}

	public List<FactorWrapper> showFactors() {
		List<FactorWrapper> factorWrapperList = new ArrayList<>();
		for (Factor factor : factorDao.findAllByOrderByIdAsc()) {
			factorWrapperList.add(new FactorWrapper(factor));
		}
		return factorWrapperList;
	}

	public List<FactorWrapper> showFactorsByQuestionnaireId(int questionnaireId) {
		List<FactorWrapper> factorWrapperList = new ArrayList<>();
		for (Factor factor : factorDao.findByQuestionnaireId(questionnaireId)) {
			factorWrapperList.add(new FactorWrapper(factor));
		}
		return factorWrapperList;
	}

	public boolean createFactor(String name, String definition) {
		System.out.println("CONTROLLER create factor:"+ name +" - " +  factorDao.findByName(name).getName() );
		if (factorDao.findByName(name) == null) {
			System.out.println("create NO EXISTE factor: " );
			factorDao.saveAndFlush(new Factor(name, definition));
			return true;
		} else {
			System.out.println("create EXISTE factor: " );

			return false;
		}
	}

	public boolean deleteFactor(int id) {
		factorDao.delete(id);
		return true;
	}
}
