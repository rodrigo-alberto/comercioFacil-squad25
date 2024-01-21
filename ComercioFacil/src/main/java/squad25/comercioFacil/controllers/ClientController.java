package squad25.comercioFacil.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import squad25.comercioFacil.enums.SystemAlert;
import squad25.comercioFacil.models.Client;
import squad25.comercioFacil.services.ClientService;

@Controller
//@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientService clientServ;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("alert", SystemAlert.USER_SECCESSFULLY_REGISTERED);
		
		return "index";
	}
	
	@GetMapping("/isRegistered={isRegistered}")
	public String showAlert(Model model, @PathVariable("isRegistered") String isRegistered) {			
		model.addAttribute("alert", (Boolean.parseBoolean(isRegistered)) ? SystemAlert.USER_SECCESSFULLY_REGISTERED : SystemAlert.USER_REGISTRATION_ERROR);
		
		return "index";
	}
	
	@GetMapping("/save")
	public String showPage(Model model) {
		model.addAttribute("client", new Client());
		
		return "client/formClient";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("client") Client client) {
		
		if(this.clientServ.save(client) != null) {
//			return "redirect:/client/isRegistered=" + true + "?showAlert=true";
			return "redirect:/isRegistered=" + true + "?showAlert=true";
		}else {
//			return "redirect:/client/isRegistered=" + false + "?showAlert=true";
			return "redirect:/isRegistered=" + false + "?showAlert=true";
		}
	}
}