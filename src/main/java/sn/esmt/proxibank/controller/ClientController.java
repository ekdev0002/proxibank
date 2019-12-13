package sn.esmt.proxibank.controller;

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

import sn.esmt.proxibank.domaine.Client;
import sn.esmt.proxibank.domaine.User;
import sn.esmt.proxibank.service.IClientService;
import sn.esmt.proxibank.service.ICompteService;
import sn.esmt.proxibank.service.IPieceService;
import sn.esmt.proxibank.utils.ClientFormValidator;

/**
 * @author yabyoure
 *
 */
@Controller
@SessionAttributes("user")
public class ClientController {

	
	
	private final Logger logger = LoggerFactory.getLogger(ClientController.class);
	
	public static final String listeClient ="/clients";
	public static final String addClient ="/client/add";
	public static final String updateClient ="/clients/{id}/update";
	public static final String deleteClient ="/clients/{id}/delete";
	
	
	//
	public static final String clientForm ="clients/clientform";
	public static final String listeClientJSP="clients/liste";

	@Autowired
	private IClientService iClientService;	
	
	@Autowired
	ClientFormValidator clientFormValidator;
	
	//Définir le form validator
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	//	binder.setValidator(clientFormValidator);
	}
	
	
	@GetMapping(value = listeClient)
	public String afficherTousLesClients(Model model, HttpSession session) {

		logger.debug("afficherTousLesClients()");
		model.addAttribute("clients", iClientService.lister());

		return listeClientJSP;
	}
	
	

	@PostMapping(value = listeClient)
	public String enregistrerOuMettreAJourClient(@ModelAttribute("clientForm") @Validated Client e,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {

		logger.debug("enregistrerOuMettreAJourClient() : {}", e);

		if (result.hasErrors()) {
			peuplerModelParDefaut(model);
			return clientForm;
		} else {

			// Ajouter des messages au flash scope
			redirectAttributes.addFlashAttribute("css", "success");
			if (e.isNew()) {
				iClientService.enregistrer(e);
				redirectAttributes.addFlashAttribute("msg", "Client ajouté avec succès!");
			} else {
				iClientService.miseAJour(e);
				redirectAttributes.addFlashAttribute("msg", "Client mis à jour avec succès!");
			}

			return "redirect:"+listeClient;

		}

	}

	// Affiche le formulaire d'ajout d'un client
	@GetMapping(value = addClient)
	public String afficherFormAjoutClient(Model model) {

		logger.debug("afficherFormAjoutClient()");

		Client e = new Client();

		// Valeur par défaut
		e.setNom("KABORE");
		e.setPrenom("Eric");
		
		model.addAttribute("clientForm", e);

		peuplerModelParDefaut(model);

		return clientForm;
	}
	
	// Affiche le formulaire demise à jour
		@GetMapping(value = updateClient)
		public String afficherFormMiseAJour(@PathVariable("id") Long id, Model model) {

			logger.debug("afficherFormMiseAJour() : {}", id);

			Client e = iClientService.trouver(id);
			model.addAttribute("clientForm", e);
			
			peuplerModelParDefaut(model);
			
			return clientForm;

		}
		// Supprimer un étudiant
		@GetMapping(value = deleteClient)
		public String supprimerClient(@PathVariable("id") Long id, 
			final RedirectAttributes redirectAttributes) {

			logger.debug("supprimerClient() : {}", id);

			iClientService.suprimer(id);
			
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Client supprimé!");
			
			return "redirect:"+listeClient;

		}
	private void peuplerModelParDefaut(Model model) {
		model.addAttribute("clients", iClientService.lister());

	}

}
