package sn.esmt.proxibank.domaine;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Transaction implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private double montant;
	private LocalDateTime dateRealisation;
	private String type;
	private String statut;
	
	@ManyToOne
	private Compte compte;

	
	@ManyToOne
	private Conseiller realisateur;

	public Transaction() {
		super();
	}

	public Transaction(double montant, String type, Compte compte, Conseiller realisateur) {
		super();
		this.montant = montant;
		this.type = type;
		this.compte = compte;
		this.realisateur = realisateur;
		this.dateRealisation = LocalDateTime.now();
		this.statut=StatutTransaction.ENCLENCHEE.toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public LocalDateTime getDateRealisation() {
		return dateRealisation;
	}

	public void setDateRealisation(LocalDateTime dateRealisation) {
		this.dateRealisation = dateRealisation;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public Conseiller getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(Conseiller realisateur) {
		this.realisateur = realisateur;
	}

	
	public boolean isNew() {
		return this.id==null;
	}

	
}
