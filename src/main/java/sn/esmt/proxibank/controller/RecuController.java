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

import sn.esmt.proxibank.domaine.Recu;
import sn.esmt.proxibank.domaine.User;
import sn.esmt.proxibank.service.IRecuService;
import sn.esmt.proxibank.service.ICompteService;
import sn.esmt.proxibank.service.IPieceService;
import sn.esmt.proxibank.utils.RecuFormValidator;

/**
 * @author yabyoure
 *
 */
@Controller
@SessionAttributes("user")
public class RecuController {
	
	

	private final Logger logger = LoggerFactory.getLogger(RecuController.class);

	public static final String listeRecu ="/recus";
	public static final String addRecu ="/recu/add";
	public static final String updateRecu ="/recus/{id}/update";
	public static final String deleteRecu ="/recus/{id}/delete";
	
	
	//
	public static final String recuForm ="recus/recuform";
	public static final String listeRecuJSP="recus/liste";
	
	
	@Autowired
	private IRecuService iRecuService;
	
	@Autowired
	private ICompteService iCompteService;


	@Autowired
	private IPieceService iPieceService;
	
	
	@Autowired
	RecuFormValidator recuFormValidator;
	
	//Définir le form validator
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
//		binder.setValidator(recuFormValidator);
	}
	
	
	@GetMapping(value = listeRecu)
	public String afficherTousLesRecus(Model model) {

		logger.debug("afficherTousLesRecus()");
		model.addAttribute("recus", iRecuService.lister());
		return listeRecuJSP;
	}
	
	

	@PostMapping(value = listeRecu)
	public String enregistrerOuMettreAJourRecu(@ModelAttribute("recuForm") @Validated Recu e,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {

		logger.debug("enregistrerOuMettreAJourRecu() : {}", e);

		if (result.hasErrors()) {
			peuplerModelParDefaut(model);
			return recuForm;
		} else {

			// Ajouter des messages au flash scope
			redirectAttributes.addFlashAttribute("css", "success");
			if (e.isNew()) {
				iRecuService.enregistrer(e);
				redirectAttributes.addFlashAttribute("msg", "Étudiant ajouté avec succès!");
			} else {
				iRecuService.miseAJour(e);
				redirectAttributes.addFlashAttribute("msg", "Recu mis à jour avec succès!");
			}

			return "redirect:"+listeRecu;

		}

	}

	// Affiche le formulaire d'ajout d'un étudiant
	@GetMapping(value = addRecu)
	public String afficherFormAjoutRecu(Model model) {

		logger.debug("afficherFormAjoutRecu()");

		Recu e = new Recu();

		// Valeur par défaut
		
		model.addAttribute("recuForm", e);

		peuplerModelParDefaut(model);

		return recuForm;
	}
	
	// Affiche le formulaire demise à jour
		@GetMapping(value = updateRecu)
		public String afficherFormMiseAJour(@PathVariable("id") Long id, Model model) {

			logger.debug("afficherFormMiseAJour() : {}", id);

			Recu e = iRecuService.trouver(id);
			model.addAttribute("recuForm", e);
			
			peuplerModelParDefaut(model);
			
			return recuForm;

		}
		// Supprimer un étudiant
		@GetMapping(value = deleteRecu)
		public String supprimerRecu(@PathVariable("id") Long id, 
			final RedirectAttributes redirectAttributes) {

			logger.debug("supprimerRecu() : {}", id);

			iRecuService.suprimer(id);
			
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Recu supprimé!");
			
			return "redirect:"+listeRecu;

		}
	private void peuplerModelParDefaut(Model model) {
		model.addAttribute("recus", iRecuService.lister());

	}

}
