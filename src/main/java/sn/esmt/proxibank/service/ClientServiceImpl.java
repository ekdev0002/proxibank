package sn.esmt.proxibank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sn.esmt.proxibank.dao.IClientDao;
import sn.esmt.proxibank.domaine.Client;
import sn.esmt.proxibank.domaine.Compte;
import sn.esmt.proxibank.domaine.Piece;

@Component(value = "clientServiceImpl")
public class ClientServiceImpl implements IClientService {

	
	@Autowired
	private IClientDao iClientDao;
	
	
	
	public IClientDao getiClientDao() {
		return iClientDao;
	}

	public void setiClientDao(IClientDao iClientDao) {
		this.iClientDao = iClientDao;
	}

	@Override
	public List<Client> findByNomOrPrenom(String nom, String prenom) {
		// TODO Auto-generated method stub
		return iClientDao.findByNomOrPrenom(nom, prenom);
	}

	@Override
	public List<Client> findByEmailOrTelephone(String email, String telephone) {
		// TODO Auto-generated method stub
		return iClientDao.findByEmailOrTelephone(email, telephone);
	}


	@Override
	public List<Client> findByComptes(List<Compte> comptes) {
		// TODO Auto-generated method stub
		return iClientDao.findByComptes(comptes);
	}

	@Override
	public Client enregistrer(Client e) {
		// TODO Auto-generated method stub
		return iClientDao.save(e);
	}

	@Override
	public Client miseAJour(Client e) {
		// TODO Auto-generated method stub
		return iClientDao.saveAndFlush(e);
	}

	@Override
	public Client trouver(Long id) {
		// TODO Auto-generated method stub
		return iClientDao.findOne(id);
	}

	@Override
	public void suprimer(Long id) {
		// TODO Auto-generated method stub
		iClientDao.delete(id);
	}

	@Override
	public List<Client> lister() {
		// TODO Auto-generated method stub
		return iClientDao.findAll();
	}

	@Override
	public List<Client> findByPieces(List<Piece> pieces) {
		// TODO Auto-generated method stub
		return iClientDao.findByPieces(pieces);
	}
}