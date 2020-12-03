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
import entity.Personne;
import services.PersonneService;
@Controller
@RequestMapping("personnes")
public class PersonneController {
	private PersonneService personneService;
@PostMapping(value ="edit")
	public String edit(Model model, Long id) {
		Personne personne = new Personne();
		if(Objects.nonNull(id)) {
			personne = personneService.getOne(id);
		}
		model.addAttribute("personne", personne);
		return "editPersonne";
	}
	@PostMapping(value ="edit/save")
	public String saveEdit(BindingResult bindingResult, @RequestBody Personne personne) {
		if(bindingResult.hasErrors()) {
			return "editPersonne";
		}
		personneService.create(personne);
		return "redirect:/personnes/list";
	}
	@GetMapping(value ="/list")
	public String listPersonne(Model model, 
									@RequestParam(name = "page", defaultValue = "0") int page, 
									@RequestParam(name = "size", defaultValue = "20") int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Personne> pagePersonne = personneService.getAll(pageable);
		int[] pages =new int[pagePersonne.getTotalPages()];
		model.addAttribute("pages", pages);
		model.addAttribute("pageCourante", page);
		model.addAttribute("listPersonne", pagePersonne.getContent());
		return "fichePersonne";
	}
@Autowired
	public void setPersonneService(PersonneService personneService) {
		this.personneService = personneService;
	}
		

}
