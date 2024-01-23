package squad25.comercioFacil.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import squad25.comercioFacil.models.Contact;
import squad25.comercioFacil.services.ContactService;

@Controller
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	private ContactService contactServ;
	
	@PostMapping("/save")
	public String save(@ModelAttribute("contact") Contact contact) {
		this.contactServ.save(contact);
		
		return "redirect:/isRegistered=" + true + "?showAlert=true";
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.contactServ.deleteById(id);
		
		return "redirect:/isRegistered=" + true + "?showAlert=true";
	}
	
}