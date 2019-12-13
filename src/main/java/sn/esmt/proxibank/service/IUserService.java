package sn.esmt.proxibank.service;

import java.util.List;

import sn.esmt.proxibank.domaine.User;
import sn.esmt.proxibank.domaine.User;
/**
 * @author yabyoure
 *
 */

public interface IUserService{
	
	public List <User> findByNomOrPrenom(String nom,String prenom);
	public List <User> findByEmailOrTelephone(String email,String telephone);
	public List <User> findByStatut(String statut);
	
	public User findByLoginAndPassword(String login, String password);
	public List<User> findByEmailAndPassword(String email,String password);

	
	//CRUD
	public User enregistrer(User e);
	public User miseAJour(User e);
	public User trouver(Long id);
	public void suprimer(Long id);
	public List<User> lister();


}
