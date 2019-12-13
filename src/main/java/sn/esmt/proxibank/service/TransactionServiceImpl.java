package sn.esmt.proxibank.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sn.esmt.proxibank.dao.IConseillerDao;
import sn.esmt.proxibank.dao.ITransactionDao;
import sn.esmt.proxibank.domaine.Client;
import sn.esmt.proxibank.domaine.Compte;
import sn.esmt.proxibank.domaine.Conseiller;
import sn.esmt.proxibank.domaine.Transaction;
@Component(value = "transactionServiceImpl")
public class TransactionServiceImpl implements ITransactionService {

	@Autowired
	private ITransactionDao iTransactionDao;

	
	
	
	public ITransactionDao getiTransactionDao() {
		return iTransactionDao;
	}

	public void setiTransactionDao(ITransactionDao iTransactionDao) {
		this.iTransactionDao = iTransactionDao;
	}

	@Override
	public List<Transaction> findByMontant(double montant) {
		// TODO Auto-generated method stub
		return iTransactionDao.findByMontant(montant);
	}

	@Override
	public List<Transaction> findByDateRealisation(LocalDateTime dateRealisation) {
		// TODO Auto-generated method stub
		return iTransactionDao.findByDateRealisation(dateRealisation);
	}

	@Override
	public List<Transaction> findByTypeOrStatut(String type, String statut) {
		// TODO Auto-generated method stub
		return iTransactionDao.findByTypeOrStatut(type, statut);
	}

	@Override
	public List<Transaction> findByCompte(Compte compte) {
		// TODO Auto-generated method stub
		return iTransactionDao.findByCompte(compte);
	}

	@Override
	public List<Transaction> findByRealisateur(Conseiller realisateur) {
		// TODO Auto-generated method stub
		return iTransactionDao.findByRealisateur(realisateur);
	}

	@Override
	public Transaction enregistrer(Transaction e) {
		// TODO Auto-generated method stub
		return iTransactionDao.save(e);
	}

	@Override
	public Transaction miseAJour(Transaction e) {
		// TODO Auto-generated method stub
		return iTransactionDao.saveAndFlush(e);
	}

	@Override
	public Transaction trouver(Long id) {
		// TODO Auto-generated method stub
		return iTransactionDao.findOne(id);
	}

	@Override
	public void suprimer(Long id) {
		// TODO Auto-generated method stub
		iTransactionDao.delete(id);
	}

	@Override
	public List<Transaction> lister() {
		// TODO Auto-generated method stub
		return iTransactionDao.findAll();
	}
}
