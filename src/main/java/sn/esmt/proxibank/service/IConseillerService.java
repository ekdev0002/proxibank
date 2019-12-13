package sn.esmt.proxibank.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.esmt.proxibank.domaine.Conseiller;
import sn.esmt.proxibank.domaine.Conseiller;
import sn.esmt.proxibank.domaine.Transaction;
import sn.esmt.proxibank.domaine.User;

/**
 * @author yabyoure
 *
 */

public interface IConseillerService{
	
	public List<Conseiller> findByNomOrPrenom(String nom,String prenom);
	public List<Conseiller> findByEmailOrTelephone(String email,String telephone);
	public Conseiller findByLoginAndPassword(String login, String password);
	public List<Conseiller> findByEmailAndPassword(String email,String password);
	
	public List <Conseiller> findByStatut(String statut);
	
	public List<Conseiller> findByListeTransactions(List<Transaction> listeTransactions);

	//CRUD
	public Conseiller enregistrer(Conseiller e);
	public Conseiller miseAJour(Conseiller e);
	public Conseiller trouver(Long id);
	public void suprimer(Long id);
	public List<Conseiller> lister();

}
