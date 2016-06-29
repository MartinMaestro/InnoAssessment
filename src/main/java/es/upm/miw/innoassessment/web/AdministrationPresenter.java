package es.upm.miw.innoassessment.web;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
@SessionAttributes("name")
public class AdministrationPresenter {

	@RequestMapping("/home-administration")
	public String homeAdministration(Model model) {
		return "jsp/administration/administrationHome";
	}
	

	
	

}
