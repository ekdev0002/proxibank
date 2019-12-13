package sn.esmt.proxibank.domaine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class User implements Serializable  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	Long id;
	String nom;
	String prenom;
	String email;
	String telephone;
	String login;
	String password;

	String statut;	
	
	
	public User() {
		super();
	}

	public User(String nom, String prenom, String email, String telephone, String statut) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.statut = statut;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}
	
	

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isNew() {
		return this.id==null;
	}
	public void destroy() {
		 this.id=null;
		this.nom = null;
		this.prenom = null;
		this.email = null;
		this.telephone = null;
		this.statut = null;			
	}

	
	
}
