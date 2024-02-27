package edu.akg.formationSpringBoot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.akg.formationSpringBoot.entities.Utilisateur;
import edu.akg.formationSpringBoot.services.UtilisateurServiceImpl;

@RestController
@RequestMapping("utilisateur")//localhost:8080/utilisateur
public class UtilisateurController {
	
	
	@Autowired
	private UtilisateurServiceImpl utilisateurService;

	@GetMapping
	public List<Utilisateur> getAllUtilisateurs() {
		return utilisateurService.getAllUtilisateurs();
	}
	
	
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Utilisateur> findUtilisateurById(@PathVariable Long id) {
		Utilisateur utilisateur = utilisateurService.findUtilisateurById(id);
		
		if (utilisateur==null) {
			return new ResponseEntity<Utilisateur>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Utilisateur>(utilisateur,HttpStatus.OK);
		}
	}
	
	
	
	@GetMapping(path = "/findByFirstName/{firstName}")
	public ResponseEntity<List<Utilisateur>> findUtilisateurByFirstName(@PathVariable String firstName) {
		List<Utilisateur> utilisateurs = utilisateurService.findByFirstName(firstName);

		if (utilisateurs.isEmpty()) {
			return new ResponseEntity<List<Utilisateur>>(HttpStatus.NO_CONTENT);
		}else{
			return new ResponseEntity<List<Utilisateur>>(utilisateurs,HttpStatus.OK);
		}
	}
	
	
	@PostMapping
	public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur) {
	return utilisateurService.createUtilisateur(utilisateur);
	}
	
	
	@PutMapping
	public Utilisateur updateUtilisateur(@RequestBody Utilisateur utilisateur) {
		return utilisateurService.updateUtilisateur(utilisateur);
	}
	
	
	@DeleteMapping(path = "/{id}")
	public void deleteUtilisateur(@PathVariable Long id) {
		utilisateurService.deleteUtilisateur(id);
	}
	
}
