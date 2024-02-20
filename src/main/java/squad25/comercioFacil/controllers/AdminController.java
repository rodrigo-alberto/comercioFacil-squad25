package squad25.comercioFacil.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import squad25.comercioFacil.enums.State;
import squad25.comercioFacil.models.Address;
import squad25.comercioFacil.models.Employer;
import squad25.comercioFacil.models.Enterprise;
import squad25.comercioFacil.models.MarketPlace;
import squad25.comercioFacil.services.AddressService;
import squad25.comercioFacil.services.EmployerService;
import squad25.comercioFacil.services.EnterpriseService;
import squad25.comercioFacil.services.MarketPlaceService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private MarketPlaceService marketSv;
	
	@Autowired
	private EnterpriseService enterpriseSv;
	
	@Autowired
	private AddressService addressSv;
	
	@Autowired
	private EmployerService employerSv;
	
	//MarketPlaces:
	@GetMapping("/getAllMarkets")
	public String showMarketsPage(Model model) {
		model.addAttribute("markets", this.marketSv.getAll());
		
		return "/admin/marketsPage";
	}
	
	@GetMapping("/saveMarket")
	public String showFormCreateMarket(Model model) {
		model.addAttribute("market", new MarketPlace());
		model.addAttribute("address", new Address());
		model.addAttribute("states", State.values());
		
		return "/admin/formCreateMarket";
	}
	
	@PostMapping("/saveMarket")
	public String saveMarket(@ModelAttribute("market") MarketPlace market, @ModelAttribute("address") Address address) {
		market.setAddress(address);
		this.marketSv.save(market);
		
		return "redirect:/admin/getAllMarkets";
	}
	
	@GetMapping("/updateMarket/{id}")
	public String showFormUpdateMarket(@PathVariable("id") Long id, Model model) {
		model.addAttribute("market", this.marketSv.getById(id));
		model.addAttribute("address", this.addressSv.getByIdMarket(id));
		model.addAttribute("states", State.values());
		
		return "/admin/formUpdateMarket";
	}
	
	@PostMapping("/updateMarket/{id}")
	public String updateMarket(@PathVariable("id") Long id,  @ModelAttribute("market") MarketPlace market, @ModelAttribute("address") Address address) {
		this.marketSv.update(id, market, address);
		
		return "redirect:/admin/getAllMarkets";
	}
	
	@GetMapping("/deleteMarket/{id}")
	public String deleteMarketById(@PathVariable("id") Long id) {
		this.marketSv.deleteById(id);
		
		return "redirect:/admin/getAllMarkets";
	}

	//Enterprises:
	@GetMapping("/getAllEnterprises")
	public String showEnterprisesPage(Model model) {
		model.addAttribute("enterprises", this.enterpriseSv.getAll());
		
		return "/admin/enterprisesPage";
	}
	
	@GetMapping("/getEnterprisesByMarket/{id}")
	public String showEnterprisesPage(@PathVariable("id") Long idMarket ,Model model) {
		model.addAttribute("enterprises", this.enterpriseSv.getAllByIdMarket(idMarket));
		
		return "/admin/enterprisesPage";
	}
	
	@GetMapping("/getImage/{id}")
	@ResponseBody
	public byte[] exibirImagen(@PathVariable("id") Long idEnterprise) {
		Enterprise enterprise = (Enterprise) this.enterpriseSv.getById(idEnterprise);

		return enterprise.getImage();
	}
	
	@GetMapping("/saveEnterprise")
	public String showFormCreateEnterprise(Model model, @ModelAttribute("employer") Employer employer) {
		model.addAttribute("enterprise", new Enterprise());
		model.addAttribute("markets", this.marketSv.getAll());
		model.addAttribute("employer", employer);
		
		return "/admin/formCreateEnterprise";
	}

	@PostMapping("/saveEnterprise")
	public String saveEnterprise(@ModelAttribute("enterprise") Enterprise enterprise, @ModelAttribute("employer") Employer employer, @RequestParam("fileImage") MultipartFile file) {
		enterprise.setEmployer(employer);
		
		try {
			enterprise.setImage(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.enterpriseSv.save(enterprise);
		
		return "redirect:/admin/getAllEnterprises";
	}
	
	@GetMapping("/updateEnterprise/{id}")
	public String showFormUpdateEnterprise(@PathVariable("id") Long id, Model model) {
		model.addAttribute("enterprise", this.enterpriseSv.getById(id));
		model.addAttribute("markets", this.marketSv.getAll());
		
		return "/admin/formUpdateEnterprise";
	}
	
	@PostMapping("/updateEnterprise/{id}")
	public String updateEnterprise(@PathVariable("id") Long id, @ModelAttribute("enterprise") Enterprise enterprise,  @RequestParam("fileImage") MultipartFile file) {
		
		try {
			enterprise.setImage(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.enterpriseSv.update(id, enterprise);
		
		return "redirect:/admin/getAllEnterprises";
	}
	
	@GetMapping("/deleteEnterprise/{id}")
	public String deleteEnterpriseById(@PathVariable("id") Long id) {
		this.enterpriseSv.deleteById(id);
		
		return "redirect:/admin/getAllEnterprises";
	}
	
	//Employers:
	@GetMapping("/checkRegistration")
	public String showFormCheckEmployer(Model model) {
		
		model.addAttribute("employer", null);
		
		return "/admin/formCheckEmployer";
	}
	
	@GetMapping("/getEmployerResgistration")
	public String showFormCheckEmployer(@RequestParam("email") String email, Model model) {		
		model.addAttribute("employer", this.employerSv.getByEmail(email));
		
		return "/admin/formCheckEmployer";
	}
}