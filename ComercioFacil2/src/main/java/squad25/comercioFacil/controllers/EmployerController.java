package squad25.comercioFacil.controllers;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import squad25.comercioFacil.models.Enterprise;

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
	
//	@PostMapping("/atualizarPreRegistro")
//	public ModelAndView atualizarRegistroEnterprise(@ModelAttribute("enterprise") Enterprise enterprise, @RequestParam("image") MultipartFile fileImage){	
//		ModelAndView modelAndview = new ModelAndView("redirect:/enterprise/listarProducts");	
//		this.selectedEnterprise.setDescription(enterprise.getDescription());
//		
//		try {
//			this.selectedEnterprise.setImagem(fileImage.getBytes());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		this.enterpriseRepository.save(this.selectedEnterprise);
//		
//		return modelAndview;
//	}
	
//	@GetMapping("/updateEnterprise/{id}")
//	public String showFormUpdateEnterprise(@PathVariable("id") Long id, Model model) {
//		model.addAttribute("enterprise", this.enterpriseSv.getById(id));
//		
//		return "/employer/formUpdateEnterprise";
//	}
//	
//	@PostMapping("/updateEnterprise/{id}")
//	public String updateEnterprise(@PathVariable("id") Long id, @ModelAttribute("enterprise") Enterprise enterprise) {
//		this.enterpriseSv.update(id, enterprise);
//		
//		return "redirect:/admin/getAllEnterprises";
//	}
}
