package sn.esmt.proxibank.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import sn.esmt.proxibank.domaine.Client;
import sn.esmt.proxibank.domaine.Compte;
import sn.esmt.proxibank.domaine.Piece;

/**
 * @author yabyoure
 *
 */

public interface IClientService{
	
	public List <Client> findByNomOrPrenom(String nom,String prenom);
	public List <Client> findByEmailOrTelephone(String email,String telephone);
	public List <Client> findByPieces(List<Piece> pieces);	
	
	public List <Client> findByComptes(List<Compte> comptes);
	
	//CRUD
	public Client enregistrer(Client e);
	public Client miseAJour(Client e);
	public Client trouver(Long id);
	public void suprimer(Long id);
	public List<Client> lister();


}
