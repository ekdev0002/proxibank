package sn.esmt.proxibank.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.esmt.proxibank.domaine.Client;
import sn.esmt.proxibank.domaine.Piece;

/**
 * @author yabyoure
 *
 */
@Repository
public interface IPieceDao extends JpaRepository<Piece, Long> {
	public List<Piece> findByNumeroPieceIdentite(String numeroPieceIdentite);
	public List<Piece> findByTypePiece(String typePiece);
	public List<Piece> findByDateEtablissement(LocalDate dateEtablissement);
	public List<Piece> findByDateExpiration(LocalDate dateExpiration);
	
	public List<Piece> findByClient(Client client);
}
