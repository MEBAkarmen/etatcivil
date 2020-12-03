package services;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.resource.HttpResource;

import entity.Utilisateur;
import repository.UtilisateurRepository;


@Service
public class UtilisateurService {

	@Autowired
    private UtilisateurRepository repository;
    private static String URL="";
    
    public List<Utilisateur> listAll(){
        return repository.findAll();
    }
    @PostConstruct
    @Scheduled(cron="* 1 * * * *")
    public void fetchUrl() throws IOException, InterruptedException{
		 List<Utilisateur> newNaissances=new ArrayList<>();
		Utilisateur utilisateur= Utilisateur.newUtilisateur();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(URL))
				.build();
		
		newNaissances.add(utilisateur);


	  }
    
    
    public void save(Utilisateur utilisateur){
        repository.save(utilisateur);
    }
    
    public Utilisateur get(Long id){
        return repository.findById(id).get();
    }
    
    public void delete(Long id){
        repository.deleteById(id);
    }
    
   
}

