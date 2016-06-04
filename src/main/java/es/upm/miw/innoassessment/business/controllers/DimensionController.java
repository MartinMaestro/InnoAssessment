package es.upm.miw.innoassessment.business.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.upm.miw.innoassessment.business.wrapper.AssessmentLineWrapper;
import es.upm.miw.innoassessment.business.wrapper.DimensionWrapper;
import es.upm.miw.innoassessment.data.daos.AssessmentLineDao;
import es.upm.miw.innoassessment.data.daos.DimensionDao;
import es.upm.miw.innoassessment.data.entities.AssessmentLine;
import es.upm.miw.innoassessment.data.entities.Dimension;

@Controller
public class DimensionController {

    private DimensionDao dimensionDao;
    
    @Autowired
    public void setDimensionDao(DimensionDao dimensionDao) {
        this.dimensionDao = dimensionDao;
    }

    
    public List<DimensionWrapper> showDimensions() {
    	System.out.println("------------ CONTROLLER SHOWDIMENSIONS num dime: " + dimensionDao.count());

        List<DimensionWrapper> dimensionWrapperList = new ArrayList<>();
        for (Dimension dimension : dimensionDao.findAll()) {
        	System.out.println("------------ CONTROLLER SHOWDIMENSIONS FOR id:"+dimension.getId() + "-name: " + dimension.getName());
        	dimensionWrapperList.add(new DimensionWrapper(dimension));
        }
        return dimensionWrapperList;
    }


	public void deleteDimension(int id) {
		// TODO Auto-generated method stub
		
	}


	public boolean createDimension(String name) {
		// TODO Auto-generated method stub
		System.out.println("------------ CREATE DIMENSION CONTROLLER " +  name);
		return dimensionDao.createDimensionDao(name);		
		
	}

 
   

}
