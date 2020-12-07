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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.etatcivil.entity.AgentSante;
import com.project.etatcivil.services.AgentSanteService;
@Controller
public class AgentSanteController {
private AgentSanteService agentSanteService;
	
	
	@PostMapping(value ="/agent-santes/edit")
	public String edit(Model model, Long id) {
		AgentSante agentSante = new AgentSante();
		if(Objects.nonNull(id)) {
			agentSante = agentSanteService.getOne(id);
		}
		
		model.addAttribute("agentSante", agentSante);
		
		 return "editAgentService";
	}
	
	
	@PostMapping(value ="/agent-santes/edit/save")
	public String saveEdit(BindingResult bindingResult, @RequestBody AgentSante agentSante) {
		if(bindingResult.hasErrors()) {
			return "editAgentSante";
		}
		
		agentSanteService.create(agentSante);
		return "redirect:/agent-santes/list";
	}
	
	@GetMapping(value ="/agent-santes/list")
	public String listAgentService(Model model, 
									@RequestParam(name = "page", defaultValue = "0") int page, 
									@RequestParam(name = "size", defaultValue = "20") int size) {
		
		Pageable pageable = PageRequest.of(page, size);
		
		Page<AgentSante> pageAgentSante = agentSanteService.getAll(pageable);
		
		model.addAttribute("listAgentSante", pageAgentSante.getContent());
		return "ficheAgentSante";
	}

	
   @Autowired
	public void setAgentServiceService(AgentSanteService agentSanteService) {
		this.agentSanteService = agentSanteService;
	}
	
	
	

}
