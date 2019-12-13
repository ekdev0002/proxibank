package sn.esmt.proxibank.domaine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client implements Serializable  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long id;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	
	@OneToMany
	private List<Compte> comptes;

	
	@OneToMany
	private List<Piece> pieces;
	
	public Client() {
		super();
	}	
	
	public Client(String nom, String prenom, String telephone,String statut, List<Piece> pieces) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.pieces = pieces;
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

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	public List<Piece> getPieces() {
		return pieces;
	}

	public void setPieces(List<Piece> pieces) {
		this.pieces = pieces;
	}

	public void addCompte(Compte compte) {
		if(comptes!=null)
			this.comptes.add(compte);
		else
			{
				comptes = new ArrayList<Compte>();
				comptes.add(compte);
			}
	}
	
	public void removeCompte(Compte compte) {
		this.comptes.remove(compte);
	}

	public void removeCompte(Long id) {
		this.comptes.remove(id);
	}	
	
	public void addPiece(Piece piece) {

			this.pieces.add(piece);
	}
	
	public void removePiece(Piece piece) {
		this.pieces.remove(piece);
	}

	public void removePiece(Long id) {
		this.pieces.remove(id);
	}	
	
	public boolean isNew() {
		return this.id==null;
	}

	
	
}
