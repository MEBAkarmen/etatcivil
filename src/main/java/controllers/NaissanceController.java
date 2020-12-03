package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Naissance;
import services.NaissanceService;

@Controller
public class NaissanceController {
	 @Autowired
	    private NaissanceService service;
	    
	    @RequestMapping("/")
	    public String viewHomePage(Model model){
	        
	        List<Naissance> list = service.listAll();
	        model.addAttribute("listNaissance",list);
	        return "index";
	    }
}
