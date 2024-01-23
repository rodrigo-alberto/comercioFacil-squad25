package squad25.comercioFacil.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employer")
public class EmployerController {
	
	
	@GetMapping("/getAllEnterprises")
	public String getAllEnterprisesByIdUser() {
		return "/employer/enterprisesPage";
	}
	
	@GetMapping("/getAllNotifications")
	public String getAllContactsByEmailRecipient() {
		return "/employer/notificationsPage";
	}
}
