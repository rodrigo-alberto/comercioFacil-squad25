package squad25.comercioFacil.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import squad25.comercioFacil.services.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@GetMapping("/getAllMarkets")
	public String showMarketsPage(Model model) {
		
		return "/admin/marketsPage";
	}
	
	@GetMapping("/updateMarket/{id}")
	public String showFormUpdateMarket(@PathVariable("id") Long id, Model model) {
		
		return "/admin/formUpdateMarket";
	}
	
	@GetMapping("/saveMarket")
	public String showFormCreateMarket(Model model) {
		
		return "/admin/formCreateMarket";
	}
	
	@DeleteMapping("/deleteMarket/{id}")
	public String deleteMarketById(@PathVariable("id") Long id) {
//		this.clientServ.deleteById(id);
		
		return "redirect:/admin/getAllMarkets";
	}

	@GetMapping("/getAllEnterprises")
	public String showEnterprisesPage(Model model) {
		
		return "/admin/enterprisesPage";
	}
	
	@GetMapping("/updateEnterprise/{id}")
	public String showFormUpdateEnterprise(@PathVariable("id") Long id, Model model) {
		
		return "/admin/formUpdateEnterprise";
	}
	
	@GetMapping("/saveEnterprise")
	public String showFormCreateEnterprise(Model model) {
		
		return "/admin/formCreateEnterprise";
	}
	
	@DeleteMapping("/deleteEnterprise/{id}")
	public String deleteEnterpriseById(@PathVariable("id") Long id) {
//		this.clientServ.deleteById(id);
		
		return "redirect:/admin/getAllEnterprises";
	}
	
}
