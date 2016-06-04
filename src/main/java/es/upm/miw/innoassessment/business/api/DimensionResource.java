package es.upm.miw.innoassessment.business.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import es.upm.miw.innoassessment.business.controllers.DimensionController;
import es.upm.miw.innoassessment.business.wrapper.DimensionWrapper;

@RestController
@RequestMapping(Uris.SERVLET_MAP + Uris.DIMENSIONS)
public class DimensionResource {

    private DimensionController dimensionController;

    @Autowired
    public void setDimensionController(DimensionController dimensionController) {
        this.dimensionController = dimensionController;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createDimension(@RequestParam(required = true) String name) {
    	this.dimensionController.createDimension(name);        
    }

    @RequestMapping(value = Uris.ID, method = RequestMethod.DELETE)
    public void deleteDimension(@PathVariable int id)  {
    	this.dimensionController.deleteDimension(id);          
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public List<DimensionWrapper> showDimensions() {
        return dimensionController.showDimensions();
    }

}
