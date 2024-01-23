package squad25.comercioFacil.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/enterprise")
public class EnterpriseController {


	@GetMapping("/show")
	public String showPublicPageEnterprise(Model model) {
		
		return "/enterprise/publicPageEnterprise";
	}
}