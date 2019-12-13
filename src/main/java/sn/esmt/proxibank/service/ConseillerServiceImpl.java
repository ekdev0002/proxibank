package sn.esmt.proxibank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sn.esmt.proxibank.dao.IConseillerDao;
import sn.esmt.proxibank.domaine.Conseiller;
import sn.esmt.proxibank.domaine.Transaction;
import sn.esmt.proxibank.domaine.User;
@Component(value = "conseillerServiceImpl")
public class ConseillerServiceImpl implements IConseillerService {

	@Autowired
	private IConseillerDao iConseillerDao;

	
	

	public IConseillerDao getiConseillerDao() {
		return iConseillerDao;
	}

	public void setiConseillerDao(IConseillerDao iConseillerDao) {
		this.iConseillerDao = iConseillerDao;
	}

	@Override
	public List<Conseiller> findByNomOrPrenom(String nom, String prenom) {
		// TODO Auto-generated method stub
		return iConseillerDao.findByNomOrPrenom(nom, prenom);
	}

	@Override
	public List<Conseiller> findByEmailOrTelephone(String email, String telephone) {
		// TODO Auto-generated method stub
		return iConseillerDao.findByEmailOrTelephone(email, telephone);
	}

	@Override
	public Conseiller findByLoginAndPassword(String login, String password) {
		// TODO Auto-generated method stub
		return iConseillerDao.findByLoginAndPassword(login, password);
	}

	@Override
	public List<Conseiller> findByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return iConseillerDao.findByEmailAndPassword(email, password);
	}

	@Override
	public List<Conseiller> findByListeTransactions(List<Transaction> listeTransactions) {
		// TODO Auto-generated method stub
		return iConseillerDao.findByListeTransactions(listeTransactions);
	}
	
	
	@Override
	public List<Conseiller> findByStatut(String statut) {
		// TODO Auto-generated method stub
		return iConseillerDao.findByStatut(statut);
	}


	@Override
	public Conseiller enregistrer(Conseiller e) {
		// TODO Auto-generated method stub
		return iConseillerDao.save(e);
	}

	@Override
	public Conseiller miseAJour(Conseiller e) {
		// TODO Auto-generated method stub
		return iConseillerDao.saveAndFlush(e);
	}

	@Override
	public Conseiller trouver(Long id) {
		// TODO Auto-generated method stub
		return iConseillerDao.findOne(id);
	}

	@Override
	public void suprimer(Long id) {
		// TODO Auto-generated method stub
		iConseillerDao.delete(id);
	}

	@Override
	public List<Conseiller> lister() {
		// TODO Auto-generated method stub
		return iConseillerDao.findAll();
	}

}
