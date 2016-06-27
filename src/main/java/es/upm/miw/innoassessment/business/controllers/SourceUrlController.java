package es.upm.miw.innoassessment.business.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.upm.miw.innoassessment.data.daos.SourceUrlDao;
import es.upm.miw.innoassessment.data.entities.SourceUrl;

@Controller
public class SourceUrlController {

	private SourceUrlDao sourceUrlDao;

	@Autowired
	public void setSourceUrlDao(SourceUrlDao sourceUrlDao) {
		this.sourceUrlDao = sourceUrlDao;
	}

	public boolean createSourceUrl(List<SourceUrl> listSourceUrl) {
		sourceUrlDao.save(listSourceUrl);
		sourceUrlDao.flush();
		return true;
	}
}
