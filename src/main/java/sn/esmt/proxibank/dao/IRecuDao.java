package sn.esmt.proxibank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.esmt.proxibank.domaine.Recu;
import sn.esmt.proxibank.domaine.Transaction;

/**
 * @author yabyoure
 *
 */
@Repository
public interface IRecuDao extends JpaRepository<Recu, Long> {
	public Recu findByTransaction(Transaction transaction);
}
