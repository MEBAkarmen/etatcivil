package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Utilisateur;
import services.UtilisateurService;

@Controller
public class UtilisateurController {

	 @Autowired
	    private UtilisateurService service;
	    
	    @RequestMapping("/")
	    public String viewHomePage(Model model){
	        
	        List<Utilisateur> list = service.listAll();
	        model.addAttribute("listUtilisateur",list);
	        return "index";
	    }
}
