package sn.esmt.proxibank.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.esmt.proxibank.domaine.Client;
import sn.esmt.proxibank.domaine.Piece;
import sn.esmt.proxibank.domaine.Piece;

/**
 * @author yabyoure
 *
 */

public interface IPieceService {
	public List<Piece> findByNumeroPieceIdentite(String numeroPieceIdentite);
	public List<Piece> findByTypePiece(String typePiece);
	public List<Piece> findByDateEtablissement(LocalDate dateEtablissement);
	public List<Piece> findByDateExpiration(LocalDate dateExpiration);
	
	public List<Piece> findByClient(Client client);
	
	//CRUD
	public Piece enregistrer(Piece e);
	public Piece miseAJour(Piece e);
	public Piece trouver(Long id);
	public void suprimer(Long id);
	public List<Piece> lister();
	
}
