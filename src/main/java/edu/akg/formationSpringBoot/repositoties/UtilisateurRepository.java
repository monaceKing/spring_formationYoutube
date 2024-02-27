package edu.akg.formationSpringBoot.repositoties;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.akg.formationSpringBoot.entities.Utilisateur;
import java.util.List;


@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	
	public List<Utilisateur> findByFirstName(String firstName);
}
