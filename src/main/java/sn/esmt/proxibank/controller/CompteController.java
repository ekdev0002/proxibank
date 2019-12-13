package sn.esmt.proxibank.controller;

import java.time.LocalDateTime;
import java.util.List;

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

import sn.esmt.proxibank.domaine.Client;
import sn.esmt.proxibank.domaine.Compte;
import sn.esmt.proxibank.service.IClientService;
import sn.esmt.proxibank.service.ICompteService;
import sn.esmt.proxibank.utils.CompteFormValidator;

/**
 * @author yabyoure
 *
 */
@Controller
@SessionAttributes("user")
public class CompteController {

	
	
	private final Logger logger = LoggerFactory.getLogger(CompteController.class);
	
	public static final String listeCompte ="/comptes";
	public static final String addCompte ="/compte/add";
	public static final String updateCompte ="/comptes/{id}/update";
	public static final String deleteCompte ="/comptes/{id}/delete";
	
	public static final String listeComptesCourantUrl="/comptescourants";
	public static final String listeComptesEpargneUrl="/comptesepargnes";
	
	//
	public static final String compteForm ="comptes/compteform";
	public static final String listeCompteJSP="comptes/liste";
	public static final String listeCompteCategorieJSP="comptes/listecategorie";

	

	@Autowired
	private ICompteService iCompteService;

	@Autowired
	private IClientService iClientService;

	
	@Autowired
	CompteFormValidator compteFormValidator;
	
	//Définir le form validator
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
//		binder.setValidator(compteFormValidator);
	}
	
	
	@GetMapping(value = listeCompte)
	public String afficherTousLesComptes(Model model) {

		logger.debug("afficherTousLesComptes()");
		model.addAttribute("comptes", iCompteService.lister());
		return listeCompteJSP;
	}

	@GetMapping(value = listeComptesCourantUrl)
	public String afficherTousLesComptesCourant(Model model) {

		logger.debug("afficherTousLesComptes()");
		model.addAttribute("comptes", iCompteService.lister());
		model.addAttribute("categorie", "COURANT");
		return listeCompteCategorieJSP;
	}
	
	@GetMapping(value = listeComptesEpargneUrl)
	public String afficherTousLesComptesEpargne(Model model) {

		logger.debug("afficherTousLesComptes()");
		model.addAttribute("comptes", iCompteService.lister());
		model.addAttribute("categorie", "EPARGNE");
		return listeCompteCategorieJSP;
	}
	

	@PostMapping(value = listeCompte)
	public String enregistrerOuMettreAJourCompte(@ModelAttribute("compteForm") @Validated Compte e,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {

		logger.debug("enregistrerOuMettreAJourCompte() : {}", e);

		if (result.hasErrors()) {
			peuplerModelParDefaut(model);
			return compteForm;
		} else {

			// Ajouter des messages au flash scope
			redirectAttributes.addFlashAttribute("css", "success");
			if (e.isNew()) {
				
				e.setDateCreation(LocalDateTime.now());
				logger.debug("le proprietaire : {}", e.getProprietaire());				
				iCompteService.enregistrer(e);
				redirectAttributes.addFlashAttribute("msg", "Compte ajouté avec succès!");
			} else {
				iCompteService.miseAJour(e);
				redirectAttributes.addFlashAttribute("msg", "Compte mis à jour avec succès!");
			}

			return "redirect:"+listeCompte;

		}

	}

	// Affiche le formulaire d'ajout d'un client
	@GetMapping(value = addCompte)
	public String afficherFormAjoutCompte(Model model) {

		logger.debug("afficherFormAjoutCompte()");

		Compte e = new Compte();
		
		List <Client> clients= iClientService.lister(); 

		// Valeur par défaut
		
		model.addAttribute("compteForm", e);
		model.addAttribute("clientsForm", clients);
		peuplerModelParDefaut(model);

		return compteForm;
	}
	
	// Affiche le formulaire demise à jour
		@GetMapping(value = updateCompte)
		public String afficherFormMiseAJour(@PathVariable("id") Long id, Model model) {

			logger.debug("afficherFormMiseAJour() : {}", id);

			Compte e = iCompteService.trouver(id);
			model.addAttribute("compteForm", e);
			
			peuplerModelParDefaut(model);
			
			return compteForm;

		}
		// Supprimer un étudiant
		@GetMapping(value = deleteCompte)
		public String supprimerCompte(@PathVariable("id") Long id, 
			final RedirectAttributes redirectAttributes) {

			logger.debug("supprimerCompte() : {}", id);

			iCompteService.suprimer(id);
			
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Compte supprimé!");
			
			return "redirect:"+listeCompte;

		}
	private void peuplerModelParDefaut(Model model) {
		model.addAttribute("comptes", iCompteService.lister());

	}

}
