package es.upm.miw.innoassessment.business.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import es.upm.miw.innoassessment.business.controllers.ModelItemController;
import es.upm.miw.innoassessment.business.wrapper.ModelItemWrapper;

@RestController
@RequestMapping(Uris.SERVLET_MAP + Uris.MODELITEMS)
public class ModelItemResource {

	private ModelItemController modelItemController;

	@Autowired
	public void setModelItemController(ModelItemController modelItemController) {
		this.modelItemController = modelItemController;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<ModelItemWrapper> showModelItems() {
		return modelItemController.showModelItems();
	}

}
