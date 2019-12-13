package sn.esmt.proxibank.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sn.esmt.proxibank.dao.IPieceDao;
import sn.esmt.proxibank.domaine.Client;
import sn.esmt.proxibank.domaine.Piece;

@Component(value = "pieceServiceImpl")
public class PieceServiceImpl implements IPieceService {
	
	@Autowired
	private IPieceDao iPieceDao;

	
	
	
	
	public IPieceDao getiPieceDao() {
		return iPieceDao;
	}

	public void setiPieceDao(IPieceDao iPieceDao) {
		this.iPieceDao = iPieceDao;
	}

	@Override
	public List<Piece> findByNumeroPieceIdentite(String numeroPieceIdentite) {
		// TODO Auto-generated method stub
		return iPieceDao.findByNumeroPieceIdentite(numeroPieceIdentite);
	}

	@Override
	public List<Piece> findByTypePiece(String typePiece) {
		// TODO Auto-generated method stub
		return iPieceDao.findByTypePiece(typePiece);
	}

	@Override
	public List<Piece> findByDateEtablissement(LocalDate dateEtablissement) {
		// TODO Auto-generated method stub
		return iPieceDao.findByDateEtablissement(dateEtablissement);
	}

	@Override
	public List<Piece> findByDateExpiration(LocalDate dateExpiration) {
		// TODO Auto-generated method stub
		return iPieceDao.findByDateExpiration(dateExpiration);
	}

	@Override
	public List<Piece> findByClient(Client client) {
		// TODO Auto-generated method stub
		return iPieceDao.findByClient(client);
	}

	@Override
	public Piece enregistrer(Piece e) {
		// TODO Auto-generated method stub
		return iPieceDao.save(e);
	}

	@Override
	public Piece miseAJour(Piece e) {
		// TODO Auto-generated method stub
		return iPieceDao.saveAndFlush(e);
	}

	@Override
	public Piece trouver(Long id) {
		// TODO Auto-generated method stub
		return iPieceDao.findOne(id);
	}

	@Override
	public void suprimer(Long id) {
		// TODO Auto-generated method stub
		iPieceDao.delete(id);
	}

	@Override
	public List<Piece> lister() {
		// TODO Auto-generated method stub
		return iPieceDao.findAll();
	}

}
