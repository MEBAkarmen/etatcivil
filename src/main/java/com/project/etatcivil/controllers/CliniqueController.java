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
import com.project.etatcivil.services.CliniqueService;
@Controller
@RequestMapping

public class CliniqueController {
private CliniqueService cliniqueService;
	
	
	@PostMapping(value ="/cliniques/edit")
	public String edit(Model model, Long id) {
		Clinique clinique = new Clinique();
		if(Objects.nonNull(id)) {
			clinique = cliniqueService.getOne(id);
		}
		
		model.addAttribute("/cliniques/clinique", clinique);
		
		 return "editClinique";
	}
	
	
	@PostMapping(value = "/cliniques/edit/save")
	public String saveEdit(BindingResult bindingResult, @RequestBody Clinique clinique) {
		if(bindingResult.hasErrors()) {
			return "editClinique";
		}
		
		cliniqueService.create(clinique);
		return "redirect:/cliniques/list";
	}
	
	@GetMapping(value = "/cliniques/list")
	public String listClinique(Model model, 
									@RequestParam(name = "page", defaultValue = "0") int page, 
									@RequestParam(name = "size", defaultValue = "20") int size) {
		
		Pageable pageable = PageRequest.of(page, size);
		
		Page<Clinique> pageClinique= cliniqueService.getAll(pageable);
		int[] pages =new int[pageClinique.getTotalPages()];
		model.addAttribute("pages", pages);
		model.addAttribute("pageCourante", page);
		model.addAttribute("listPersonne", pageClinique.getContent());
		return "ficheClinique";
	}

	
   @Autowired
	public void setCliniqueService(CliniqueService cliniqueService) {
		this.cliniqueService = cliniqueService;
	}
	
	
}
