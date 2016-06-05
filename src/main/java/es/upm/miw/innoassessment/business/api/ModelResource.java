package es.upm.miw.innoassessment.business.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import es.upm.miw.innoassessment.business.controllers.ModelController;
import es.upm.miw.innoassessment.business.wrapper.ModelWrapper;

@RestController
@RequestMapping(Uris.SERVLET_MAP + Uris.MODELS)
public class ModelResource {

	private ModelController modelController;

	@Autowired
	public void setModelController(ModelController modelController) {
		this.modelController = modelController;
	}

	@RequestMapping(method = RequestMethod.POST)
	public void createModel(@RequestParam(required = true) String name, String year, String version,
			String description) {
		this.modelController.createModel(name, year, version, description);
	}

	@RequestMapping(value = Uris.ID, method = RequestMethod.DELETE)
	public void deleteModel(@PathVariable int id) {
		this.modelController.deleteModel(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<ModelWrapper> showModels() {
		return modelController.showModels();
	}

}
