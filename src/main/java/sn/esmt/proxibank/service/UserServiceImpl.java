package sn.esmt.proxibank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sn.esmt.proxibank.dao.IUserDao;
import sn.esmt.proxibank.domaine.User;
import sn.esmt.proxibank.domaine.Compte;
import sn.esmt.proxibank.domaine.User;
import sn.esmt.proxibank.domaine.Piece;

@Component(value = "userServiceImpl")
public class UserServiceImpl implements IUserService {

	
	@Autowired
	private IUserDao iUserDao;
	
	
	
	public IUserDao getiUserDao() {
		return iUserDao;
	}

	public void setiUserDao(IUserDao iUserDao) {
		this.iUserDao = iUserDao;
	}

	@Override
	public List<User> findByNomOrPrenom(String nom, String prenom) {
		// TODO Auto-generated method stub
		return iUserDao.findByNomOrPrenom(nom, prenom);
	}

	@Override
	public List<User> findByEmailOrTelephone(String email, String telephone) {
		// TODO Auto-generated method stub
		return iUserDao.findByEmailOrTelephone(email, telephone);
	}


	@Override
	public User enregistrer(User e) {
		// TODO Auto-generated method stub
		return iUserDao.save(e);
	}

	@Override
	public User miseAJour(User e) {
		// TODO Auto-generated method stub
		return iUserDao.saveAndFlush(e);
	}

	@Override
	public User trouver(Long id) {
		// TODO Auto-generated method stub
		return iUserDao.findOne(id);
	}

	@Override
	public void suprimer(Long id) {
		// TODO Auto-generated method stub
		iUserDao.delete(id);
	}

	@Override
	public List<User> lister() {
		// TODO Auto-generated method stub
		return iUserDao.findAll();
	}
	
	@Override
	public User findByLoginAndPassword(String login, String password) {
		// TODO Auto-generated method stub
		return iUserDao.findByLoginAndPassword(login, password);
	}

	@Override
	public List<User> findByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return iUserDao.findByEmailAndPassword(email, password);
	}


	@Override
	public List<User> findByStatut(String statut) {
		// TODO Auto-generated method stub
		return iUserDao.findByStatut(statut);
	}


}