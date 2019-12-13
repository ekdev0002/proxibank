package sn.esmt.proxibank.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sn.esmt.proxibank.domaine.CategorieCompte;
import sn.esmt.proxibank.domaine.Compte;
import sn.esmt.proxibank.domaine.Conseiller;
import sn.esmt.proxibank.domaine.Transaction;
import sn.esmt.proxibank.domaine.TypeTransaction;
import sn.esmt.proxibank.domaine.User;
import sn.esmt.proxibank.service.ITransactionService;
import sn.esmt.proxibank.service.ICompteService;
import sn.esmt.proxibank.service.IPieceService;
import sn.esmt.proxibank.utils.TransactionFormValidator;

/**
 * @author yabyoure
 *
 */
@Controller
@SessionAttributes("user")
public class TransactionController {
	
	

	private final Logger logger = LoggerFactory.getLogger(TransactionController.class);

	public static final String listeTransaction ="/transactions";
	public static final String addTransaction ="/transaction/add";
	public static final String updateTransaction ="/transactions/{id}/update";
	public static final String deleteTransaction ="/transactions/{id}/delete";
	
	
	public static final String listeTransactionDebitUrl="/transactionsdebits";
	public static final String listeTransactionCreditUrl="/transactionscredits";

	
	//
	public static final String transactionFrom ="transactions/transactionform";
	public static final String listeTransactionJSP="transactions/liste";

	public static final String listeTransactionTypeJSP="transactions/listetypetransaction";
	
	
	@Autowired
	private ITransactionService iTransactionService;
	
	@Autowired
	private ICompteService iCompteService;

	
	@Autowired
	TransactionFormValidator transactionFormValidator;
	
	//Définir le form validator
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
//		binder.setValidator(transactionFormValidator);
	}
	
	
	@GetMapping(value = listeTransaction)
	public String afficherTousLesTransactions(Model model) {

		logger.debug("afficherTousLesTransactions()");
		model.addAttribute("transactions", iTransactionService.lister());
		return listeTransactionJSP;
	}
	
	

	@PostMapping(value = listeTransaction)
	public String enregistrerOuMettreAJourTransaction(@ModelAttribute("transactionForm") @Validated Transaction e,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes,HttpSession session) {

		logger.debug("enregistrerOuMettreAJourTransaction() : {}", e);

		if (result.hasErrors()) {
			peuplerModelParDefaut(model);
			return transactionFrom;
		} else {

			// Ajouter des messages au flash scope
			redirectAttributes.addFlashAttribute("css", "success");
			if (e.isNew()) {
				e.setDateRealisation(LocalDateTime.now());
				Conseiller s =((Conseiller) HomeController.user);
				e.setRealisateur(((Conseiller) session.getAttribute("user")));
				
				
				
				//recuperation du compte avec son id contenu dans la transaction
				Compte c=iCompteService.trouver((e.getCompte()).getId());
				
				//test s'il s'agit d'une operation de credit
				if(e.getType().equals(TypeTransaction.CREDIT.toString()))
				{
					//augementation du solde du compte
					c.setSolde(c.getSolde()+e.getMontant());
				}
				else {
					//test pour savoir si c'est un compte epargne qui peut atteindre 55000f de decouvert
					if((c.getSolde() -e.getMontant() )<= -55000 && c.getCategorie().equals(CategorieCompte.EPARGNE.toString())) {
						redirectAttributes.addFlashAttribute("css", "danger");
						redirectAttributes.addFlashAttribute("msg", "Transaction impossible: Compte Epargne ne pas être à decouvert de 55000 FCFA");
						return "redirect:"+listeTransaction;
					}
					else
					{
						//dimunition du solde du compte
						c.setSolde(c.getSolde()-e.getMontant());
						}				
				}
				
				iCompteService.miseAJour(c);
				iTransactionService.enregistrer(e);
				redirectAttributes.addFlashAttribute("msg", "Transaction ajouté avec succès!");
			} else {
				iTransactionService.miseAJour(e);
				redirectAttributes.addFlashAttribute("msg", "Transaction mis à jour avec succès!");
			}

			return "redirect:"+listeTransaction;

		}

	}
	
	@GetMapping(value = listeTransactionDebitUrl)
	public String afficherToutesLesTransactionDebit(Model model) {
		model.addAttribute("listeTransactions", iTransactionService.lister());
		model.addAttribute("type", "DEBIT");
		return listeTransactionTypeJSP;
	}
	
	@GetMapping(value = listeTransactionCreditUrl)
	public String afficherToutesLesTransactionCredit(Model model) {
		model.addAttribute("listeTransactions", iTransactionService.lister());
		model.addAttribute("type", "CREDIT");
		return listeTransactionTypeJSP;
	}


	// Affiche le formulaire d'ajout d'un étudiant
	@GetMapping(value = addTransaction)
	public String afficherFormAjoutTransaction(Model model) {

		logger.debug("afficherFormAjoutTransaction()");

		Transaction e = new Transaction();

		// Valeur par défaut
		model.addAttribute("comptes", iCompteService.lister());		
		model.addAttribute("transactionForm", e);

		peuplerModelParDefaut(model);

		return transactionFrom;
	}
	
	// Affiche le formulaire demise à jour
		@GetMapping(value = updateTransaction)
		public String afficherFormMiseAJour(@PathVariable("id") Long id, Model model) {

			logger.debug("afficherFormMiseAJour() : {}", id);

			Transaction e = iTransactionService.trouver(id);
			model.addAttribute("transactionForm", e);
			model.addAttribute("comptes", iCompteService.lister());		
			model.addAttribute("transactionForm", e);
		
			peuplerModelParDefaut(model);
			
			return transactionFrom;

		}
		// Supprimer un étudiant
		@GetMapping(value = deleteTransaction)
		public String supprimerTransaction(@PathVariable("id") Long id, 
			final RedirectAttributes redirectAttributes) {

			logger.debug("supprimerTransaction() : {}", id);

			iTransactionService.suprimer(id);
			
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Transaction supprimé!");
			
			return "redirect:"+listeTransaction;

		}
	private void peuplerModelParDefaut(Model model) {
		model.addAttribute("transactions", iTransactionService.lister());

	}

}
