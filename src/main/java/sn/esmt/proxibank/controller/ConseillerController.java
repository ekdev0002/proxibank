package sn.esmt.proxibank.controller;

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

import sn.esmt.proxibank.domaine.Conseiller;
import sn.esmt.proxibank.domaine.StatutUser;
import sn.esmt.proxibank.service.IConseillerService;
import sn.esmt.proxibank.utils.ConseillerFormValidator;

/**
 * @author yabyoure
 *
 */
@Controller
@SessionAttributes("user")
public class ConseillerController {
	
	
	
	
private final Logger logger = LoggerFactory.getLogger(ConseillerController.class);
	

public static final String listeConseiller ="/conseillers";
public static final String addConseiller ="/conseillers/add";
public static final String updateConseiller ="/conseillers/{id}/update";
public static final String deleteConseiller ="/conseillers/{id}/delete";


//
public static final String conseilllerForm ="conseillers/conseillerform";
public static final String listeConseillerJSP="conseillers/liste";

	
	@Autowired
	private IConseillerService iConseillerService;
	
	@Autowired
	ConseillerFormValidator conseillerFormValidator;


	
	
	//Définir le form validator
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
//		binder.setValidator(conseillerFormValidator);
	}
	
	
	@GetMapping(value = listeConseiller)
	public String afficherTousLesConseillers(Model model) {

		logger.debug("afficherTousLesConseillers()");
		model.addAttribute("conseillers", iConseillerService.lister());
		return listeConseillerJSP;
	}
	

	@PostMapping(value = listeConseiller)
	public String enregistrerOuMettreAJourConseiller(@ModelAttribute("conseillerForm") @Validated Conseiller e,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {

		logger.debug("enregistrerOuMettreAJourConseiller() : {}", e);

		if (result.hasErrors()) {
			peuplerModelParDefaut(model);
			return conseilllerForm;
		} else {

			// Ajouter des messages au flash scope
			redirectAttributes.addFlashAttribute("css", "success");
			if (e.isNew()) {
				e.setStatut(StatutUser.CONSEILLER.toString());
				iConseillerService.enregistrer(e);
				redirectAttributes.addFlashAttribute("msg", "Conseiller ajouté avec succès!");
			} else {
				iConseillerService.miseAJour(e);
				redirectAttributes.addFlashAttribute("msg", "Conseiller mis à jour avec succès!");
			}

			return "redirect:"+listeConseiller;

		}

	}

	// Affiche le formulaire d'ajout d'une conseiller
	@GetMapping(value = addConseiller)
	public String afficherFormAjoutConseiller(Model model) {

		logger.debug("afficherFormAjoutConseiller()");

		Conseiller e = new Conseiller();

		// Valeur par défaut
		e.setNom("NDIAYE");
		e.setPrenom("Saliou");
		
		model.addAttribute("conseillerForm", e);

		peuplerModelParDefaut(model);

		return conseilllerForm;

	}
	// Affiche le formulaire demise à jour
		@GetMapping(value = updateConseiller)
		public String afficherFormMiseAJour(@PathVariable("id") Long id, Model model) {

			logger.debug("afficherFormMiseAJour() : {}", id);

			Conseiller e = iConseillerService.trouver(id);
			model.addAttribute("conseillerForm", e);
			
			peuplerModelParDefaut(model);
			
			return conseilllerForm;

		}
		// Supprimer un conseiller
		@GetMapping(value = deleteConseiller)
		public String supprimerConseiller(@PathVariable("id") Long id, 
			final RedirectAttributes redirectAttributes) {

			logger.debug("supprimerConseiller() : {}", id);

			iConseillerService.suprimer(id);
			
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Conseiller supprimé!");
			
			return "redirect:"+listeConseiller;

		}
	private void peuplerModelParDefaut(Model model) {
		model.addAttribute("conseillers", iConseillerService.lister());

	}
}
