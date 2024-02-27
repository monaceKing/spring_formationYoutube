package edu.akg.formationSpringBoot.services;

import java.util.List;

import edu.akg.formationSpringBoot.entities.Utilisateur;

public interface UtilisateurService {

	//Methodes CRUD basiques
	public List<Utilisateur> getAllUtilisateurs();
	public Utilisateur findUtilisateurById(Long id);
	public Utilisateur createUtilisateur(Utilisateur utilisateur);
	public Utilisateur updateUtilisateur(Utilisateur utilisateur);
	public void deleteUtilisateur(Long id);
	
	
	
	//Methodes avancées
	public List<Utilisateur>findByFirstName(String firstName);
	
}
