package sn.esmt.proxibank.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.esmt.proxibank.domaine.Transaction;
import sn.esmt.proxibank.domaine.Client;
import sn.esmt.proxibank.domaine.Compte;
import sn.esmt.proxibank.domaine.Compte;

/**
 * @author yabyoure
 *
 */

public interface ICompteService {
	public List<Compte> findByNumero(String numero);
	public List<Compte> findBySolde(double solde);
	public List<Compte> findByDateCreation(LocalDateTime dateCreation);
	public List<Compte> findByCategorieOrStatut(String Categorie,String statut);
	
	public List<Compte> findByProprietaire(Client proprietaire);
	public List<Compte> findByListeDebits(List<Transaction> listeDebits);
	public List<Compte> findByListeCredits(List<Transaction> listeCredits);
	
	//CRUD
	public Compte enregistrer(Compte e);
	public Compte miseAJour(Compte e);
	public Compte trouver(Long id);
	public void suprimer(Long id);
	public List<Compte> lister();


}
