package squad25.comercioFacil.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {
	
	@GetMapping("/")
	public String home() {
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
