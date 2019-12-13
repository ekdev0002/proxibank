package sn.esmt.proxibank.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sn.esmt.proxibank.dao.IClientDao;
import sn.esmt.proxibank.dao.ICompteDao;
import sn.esmt.proxibank.domaine.Client;
import sn.esmt.proxibank.domaine.Compte;
import sn.esmt.proxibank.domaine.Transaction;
@Component(value = "compteServiceImpl")
public class CompteServiceImpl implements ICompteService {

	@Autowired
	private ICompteDao iCompteDao;
	
	
	
	public ICompteDao getiCompteDao() {
		return iCompteDao;
	}

	public void setiCompteDao(ICompteDao iCompteDao) {
		this.iCompteDao = iCompteDao;
	}

	@Override
	public List<Compte> findByNumero(String numero) {
		// TODO Auto-generated method stub
		return iCompteDao.findByNumero(numero);
	}

	@Override
	public List<Compte> findBySolde(double solde) {
		// TODO Auto-generated method stub
		return iCompteDao.findBySolde(solde);
	}

	@Override
	public List<Compte> findByDateCreation(LocalDateTime dateCreation) {
		// TODO Auto-generated method stub
		return iCompteDao.findByDateCreation(dateCreation);
	}

	@Override
	public List<Compte> findByCategorieOrStatut(String Categorie, String statut) {
		// TODO Auto-generated method stub
		return iCompteDao.findByCategorieOrStatut(Categorie, statut);
	}

	@Override
	public List<Compte> findByProprietaire(Client proprietaire) {
		// TODO Auto-generated method stub
		return iCompteDao.findByProprietaire(proprietaire);
	}

	@Override
	public List<Compte> findByListeDebits(List<Transaction> listeDebits) {
		// TODO Auto-generated method stub
		return iCompteDao.findByListeDebits(listeDebits);
	}

	@Override
	public List<Compte> findByListeCredits(List<Transaction> listeCredits) {
		// TODO Auto-generated method stub
		return iCompteDao.findByListeCredits(listeCredits);
	}

	@Override
	public Compte enregistrer(Compte e) {
		// TODO Auto-generated method stub
		return iCompteDao.save(e);
	}

	@Override
	public Compte miseAJour(Compte e) {
		// TODO Auto-generated method stub
		return iCompteDao.saveAndFlush(e);
	}

	@Override
	public Compte trouver(Long id) {
		// TODO Auto-generated method stub
		return iCompteDao.findOne(id);
	}

	@Override
	public void suprimer(Long id) {
		// TODO Auto-generated method stub
		iCompteDao.delete(id);
	}

	@Override
	public List<Compte> lister() {
		// TODO Auto-generated method stub
		return iCompteDao.findAll();
	}
}
