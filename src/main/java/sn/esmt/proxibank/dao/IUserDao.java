package sn.esmt.proxibank.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.esmt.proxibank.domaine.User;

/**
 * @author yabyoure
 *
 */
@Repository
public interface IUserDao extends JpaRepository<User, Long> {
	
	public List <User> findByNomOrPrenom(String nom,String prenom);
	public List <User> findByEmailOrTelephone(String email,String telephone);
	public User findByLoginAndPassword(String login, String password);
	public List<User> findByEmailAndPassword(String email,String password);

	public List <User> findByStatut(String statut);


}
