package sn.esmt.proxibank.domaine;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Piece implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String numeroPieceIdentite;
	private String typePiece;
	private LocalDate dateEtablissement;
	private LocalDate dateExpiration;
	
	@ManyToOne
	private Client client;
	
	

	public Piece() {
		super();
	}

	public Piece(String numeroPieceIdentite, String typePiece, LocalDate dateEtablissement, LocalDate dateExpiration,
			Client client) {
		super();
		this.numeroPieceIdentite = numeroPieceIdentite;
		this.typePiece = typePiece;
		this.dateEtablissement = dateEtablissement;
		this.dateExpiration = dateExpiration;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroPieceIdentite() {
		return numeroPieceIdentite;
	}

	public void setNumeroPieceIdentite(String numeroPieceIdentite) {
		this.numeroPieceIdentite = numeroPieceIdentite;
	}

	public String getTypePiece() {
		return typePiece;
	}

	public void setTypePiece(String typePiece) {
		this.typePiece = typePiece;
	}

	public LocalDate getDateEtablissement() {
		return dateEtablissement;
	}

	public void setDateEtablissement(LocalDate dateEtablissement) {
		this.dateEtablissement = dateEtablissement;
	}

	public LocalDate getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(LocalDate dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public boolean isNew() {
		return this.id==null;
	}

	
	
}
