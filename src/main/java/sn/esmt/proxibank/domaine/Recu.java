package sn.esmt.proxibank.domaine;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Recu implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long id;

	@OneToOne
	private Transaction transaction;

	public Recu() {
		super();
	}

	public Recu(Transaction transaction) {
		super();
		this.transaction = transaction;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public boolean isNew() {
		return this.id==null;
	}

	
	
}
