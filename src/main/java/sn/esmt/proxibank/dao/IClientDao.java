package sn.esmt.proxibank.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.esmt.proxibank.domaine.Client;
import sn.esmt.proxibank.domaine.Compte;
import sn.esmt.proxibank.domaine.Piece;

/**
 * @author yabyoure
 *
 */
@Repository
public interface IClientDao extends JpaRepository<Client, Long> {
	
	public List <Client> findByNomOrPrenom(String nom,String prenom);
	public List <Client> findByEmailOrTelephone(String email,String telephone);
	
	
	public List <Client> findByPieces(List<Piece> pieces);	
	
	public List <Client> findByComptes(List<Compte> comptes);

}
