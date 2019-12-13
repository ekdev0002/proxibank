package sn.esmt.proxibank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sn.esmt.proxibank.dao.IConseillerDao;
import sn.esmt.proxibank.dao.IRecuDao;
import sn.esmt.proxibank.domaine.Recu;
import sn.esmt.proxibank.domaine.Transaction;
@Component(value = "recuServiceImpl")
public class RecuServiceImpl implements IRecuService {

	
	@Autowired
	private IRecuDao iRecuDao;
	
	
	
	
	public IRecuDao getiRecuDao() {
		return iRecuDao;
	}

	public void setiRecuDao(IRecuDao iRecuDao) {
		this.iRecuDao = iRecuDao;
	}

	@Override
	public Recu findByTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		return iRecuDao.findByTransaction(transaction);
	}

	@Override
	public Recu enregistrer(Recu e) {
		// TODO Auto-generated method stub
		return iRecuDao.save(e);
	}

	@Override
	public Recu miseAJour(Recu e) {
		// TODO Auto-generated method stub
		return iRecuDao.saveAndFlush(e);
	}

	@Override
	public Recu trouver(Long id) {
		// TODO Auto-generated method stub
		return iRecuDao.findOne(id);
	}

	@Override
	public void suprimer(Long id) {
		// TODO Auto-generated method stub
		iRecuDao.delete(id);
	}

	@Override
	public List<Recu> lister() {
		// TODO Auto-generated method stub
		return iRecuDao.findAll();
	}
}
