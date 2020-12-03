package controllers;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import entity.CompteUser;
import services.CompteUserService;
@Controller
@RequestMapping("comptes")

public class CompteUserController {
private CompteUserService compteUserService;
	
	
	@PostMapping(value ="edit")
	public String edit(Model model, Long id) {
		CompteUser compteUser = new CompteUser();
		if(Objects.nonNull(id)) {
			compteUser = compteUserService.getOne(id);
		}
		
		model.addAttribute("compteUser", compteUser);
		
		 return "editCompteUser";
	}
	
	
	@PostMapping(value = "edit/save")
	public String saveEdit(BindingResult bindingResult, @RequestBody CompteUser compteUser) {
		if(bindingResult.hasErrors()) {
			return "editCompteUser";
		}
		
		compteUserService.create(compteUser);
		return "redirect:/compteUsers/list";
	}
	
	@GetMapping(value = "list")
	public String listCompteUser(Model model, 
									@RequestParam(name = "page", defaultValue = "0") int page, 
									@RequestParam(name = "size", defaultValue = "20") int size) {
		
		Pageable pageable = PageRequest.of(page, size);
		
		Page<CompteUser> pageCompteUser = compteUserService.getAll(pageable);
		int[] pages =new int[pageCompteUser.getTotalPages()];
		model.addAttribute("pages", pages);
		model.addAttribute("pageCourante", page);
		model.addAttribute("listPersonne", pageCompteUser.getContent());
		return "ficheCompteUser";
	}

	
   @Autowired
	public void setPersonneService(CompteUserService compteUserService) {
		this.compteUserService = compteUserService;
	}
	
	

}
