package com.project.etatcivil.controllers;

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

import com.project.etatcivil.entity.Clinique;
import com.project.etatcivil.entity.Declaration;
import com.project.etatcivil.services.CliniqueService;
import com.project.etatcivil.services.DeclarationService;

@Controller
@RequestMapping
public class DeclarationController {
	private DeclarationService declarationService;
	@PostMapping(value ="/Declarations/edit")
	public String edit(Model model, Long id) {
		Declaration declaration = new Declaration();
		if(Objects.nonNull(id)) {
			declaration = declarationService.getOne(id);
		}
		
		model.addAttribute("/declarations/declaration", declaration);
		
		 return "editDeclaration";
	}
	
	
	@PostMapping(value = "/declarations/edit/save")
	public String saveEdit(BindingResult bindingResult, @RequestBody Declaration declaration) {
		if(bindingResult.hasErrors()) {
			return "editDeclaration";
		}
		
		declarationService.create(declaration);
		return "redirect:/declarations/list";
	}
	
	@GetMapping(value = "/declarations/list")
	public String listDeclaration(Model model, 
									@RequestParam(name = "page", defaultValue = "0") int page, 
									@RequestParam(name = "size", defaultValue = "20") int size) {
		
		Pageable pageable = PageRequest.of(page, size);
		
		Page<Declaration> pageDeclaration= declarationService.getAll(pageable);
		int[] pages =new int[pageDeclaration.getTotalPages()];
		model.addAttribute("pages", pages);
		model.addAttribute("pageCourante", page);
		model.addAttribute("listPersonne", pageDeclaration.getContent());
		return "ficheDeclaration";
	}

	
   @Autowired
	public void setDeclarationService(DeclarationService declarationService) {
		this.declarationService = declarationService;
	}

}
