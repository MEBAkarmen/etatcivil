package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Naissance;
import entity.Organisation;
import services.OrganisationService;
@Controller
public class OrganisationController {
 @Autowired
	    private OrganisationService service;
	    
	    @RequestMapping("/")
public String viewHomePage(Model model){
	        
	        List<Organisation> list =service.listAll();
	        model.addAttribute("listOrganisation",list);
	        return "index";
	    }
}
