package sn.esmt.proxibank.domaine;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Compte implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String numero;
	private double solde;
	private LocalDateTime dateCreation;
	private String categorie;
	private String statut;
	
	@ManyToOne
	private Client proprietaire;
	
	@OneToMany
	private List<Transaction> listeDebits;
	
	@OneToMany
	private List<Transaction> listeCredits;

	public Compte() {
		super();
	}

	public Compte(String numero, String categorie, Client proprietaire) {
		super();
		this.numero = numero;
		this.categorie = categorie;
		this.proprietaire = proprietaire;
		this.dateCreation=LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public LocalDateTime getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Client getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Client proprietaire) {
		this.proprietaire = proprietaire;
	}

	public List<Transaction> getListeDebits() {
		return listeDebits;
	}

	public void setListeDebits(List<Transaction> listeDebits) {
		this.listeDebits = listeDebits;
	}
	
	public void addDebit(Transaction debit) {
		if(listeDebits!=null)
			this.listeDebits.add(debit);
		else
			{
			listeDebits = new ArrayList<Transaction>();
			listeDebits.add(debit);
			}
	}
	

	public List<Transaction> getListeCredits() {
		return listeCredits;
	}

	public void setListeCredits(List<Transaction> listeCredits) {
		this.listeCredits = listeCredits;
	}
	
	public void addCredit(Transaction credit) {
		if(listeCredits!=null)
			this.listeCredits.add(credit);
		else
			{
			listeCredits = new ArrayList<Transaction>();
			listeCredits.add(credit);
			}
	}
		
	
	public boolean isNew() {
		return this.id==null;
	}

	
	
}
