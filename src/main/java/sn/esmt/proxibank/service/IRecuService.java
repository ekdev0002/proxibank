package sn.esmt.proxibank.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import sn.esmt.proxibank.domaine.Recu;
import sn.esmt.proxibank.domaine.Transaction;


/**
 * @author yabyoure
 *
 */
@Repository
public interface IRecuService {
	public Recu findByTransaction(Transaction transaction);

	//CRUD
	public Recu enregistrer(Recu e);
	public Recu miseAJour(Recu e);
	public Recu trouver(Long id);
	public void suprimer(Long id);
	public List<Recu> lister();

}
