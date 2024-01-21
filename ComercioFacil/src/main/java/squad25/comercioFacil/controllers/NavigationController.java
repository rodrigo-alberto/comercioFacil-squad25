package squad25.comercioFacil.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import squad25.comercioFacil.enums.SystemAlert;

@Controller
public class NavigationController { //Atualizado;
	
//	@GetMapping("/")
//	public String home() {
//		return "index";
//	}
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("alert", SystemAlert.SUCCESSFUL_OPERATION);
		
		return "index";
	}
	
	@GetMapping("/about")
    public String about() {
        return "about";
    }
	
	@GetMapping("/contact")
    public String contact() {
        return "contacts";
    }
	
	@GetMapping("/partnersClients")
	public String partClie() {
		return "partnersClients";
	}
	
	@GetMapping("/testeSide")
	public String testeSide() {
		return "admin/testeSide";
	}
}