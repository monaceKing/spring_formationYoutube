package edu.akg.formationSpringBoot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.akg.formationSpringBoot.entities.Utilisateur;
import edu.akg.formationSpringBoot.repositoties.UtilisateurRepository;

@Service
public class UtilisateurServiceImpl implements UtilisateurService{

	@Autowired
	public UtilisateurRepository  utilisateurRepository;
	
	@Override
	public List<Utilisateur> getAllUtilisateurs() {
		
		return utilisateurRepository.findAll();
	}

	@Override
	public Utilisateur findUtilisateurById(Long id) {
		Optional<Utilisateur> Uoptional = utilisateurRepository.findById(id);
		
		if (Uoptional.isEmpty()) {
			return null;
		}
		else {
			return Uoptional.get();
		}
		
	}

	@Override
	public Utilisateur createUtilisateur(Utilisateur utilisateur) {
		return utilisateurRepository.save(utilisateur);
	}
	

	@Override
	public Utilisateur updateUtilisateur(Utilisateur utilisateur) {
		Optional<Utilisateur> Uoptional = utilisateurRepository.findById(utilisateur.getId());
		
		if (Uoptional.isEmpty()) {
			return null;
		}
		else {
			return utilisateurRepository.save(utilisateur);
		}
	}

	public void deleteUtilisateur(Long id) {
		utilisateurRepository.deleteById(id);
	}

	@Override
	public List<Utilisateur> findByFirstName(String firstName) {
		return utilisateurRepository.findByFirstName(firstName);
	}
	
}
