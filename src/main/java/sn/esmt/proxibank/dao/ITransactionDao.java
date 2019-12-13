package sn.esmt.proxibank.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.esmt.proxibank.domaine.Client;
import sn.esmt.proxibank.domaine.Compte;
import sn.esmt.proxibank.domaine.Transaction;
import sn.esmt.proxibank.domaine.Conseiller;

/**
 * @author yabyoure
 *
 */
@Repository
public interface ITransactionDao extends JpaRepository<Transaction, Long> {
	public List<Transaction> findByMontant(double montant);
	public List<Transaction> findByDateRealisation(LocalDateTime dateRealisation);
	public List<Transaction> findByTypeOrStatut(String type,String statut);
	
	public List<Transaction> findByCompte(Compte compte);
	public List<Transaction> findByRealisateur(Conseiller realisateur);
}
