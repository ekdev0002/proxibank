package sn.esmt.proxibank.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.esmt.proxibank.domaine.Transaction;
import sn.esmt.proxibank.domaine.Client;
import sn.esmt.proxibank.domaine.Compte;

/**
 * @author yabyoure
 *
 */
@Repository
public interface ICompteDao extends JpaRepository<Compte, Long> {
	public List<Compte> findByNumero(String numero);
	public List<Compte> findBySolde(double solde);
	public List<Compte> findByDateCreation(LocalDateTime dateCreation);
	public List<Compte> findByCategorieOrStatut(String Categorie,String statut);
	
	public List<Compte> findByProprietaire(Client proprietaire);
	public List<Compte> findByListeDebits(List<Transaction> listeDebits);
	public List<Compte> findByListeCredits(List<Transaction> listeCredits);

}
