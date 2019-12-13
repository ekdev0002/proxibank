package sn.esmt.proxibank.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import sn.esmt.proxibank.domaine.Client;
import sn.esmt.proxibank.domaine.Compte;
import sn.esmt.proxibank.domaine.Conseiller;
import sn.esmt.proxibank.domaine.Transaction;

/**
 * @author yabyoure
 *
 */

public interface ITransactionService  {
	public List<Transaction> findByMontant(double montant);
	public List<Transaction> findByDateRealisation(LocalDateTime dateRealisation);
	public List<Transaction> findByTypeOrStatut(String type,String statut);
	
	public List<Transaction> findByCompte(Compte compte);
	public List<Transaction> findByRealisateur(Conseiller realisateur);


	//CRUD
	public Transaction enregistrer(Transaction e);
	public Transaction miseAJour(Transaction e);
	public Transaction trouver(Long id);
	public void suprimer(Long id);
	public List<Transaction> lister();

}
