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

import sn.esmt.proxibank.domaine.Piece;
import sn.esmt.proxibank.domaine.User;
import sn.esmt.proxibank.service.IPieceService;
import sn.esmt.proxibank.service.ICompteService;
import sn.esmt.proxibank.service.IPieceService;
import sn.esmt.proxibank.utils.PieceFormValidator;

/**
 * @author yabyoure
 *
 */
@Controller
@SessionAttributes("user")
public class PieceController {
	
	

	private final Logger logger = LoggerFactory.getLogger(PieceController.class);

	public static final String listePiece ="/pieces";
	public static final String addPiece ="/piece/add";
	public static final String updatePiece ="/pieces/{id}/update";
	public static final String deletePiece ="/pieces/{id}/delete";
	
	
	//
	public static final String pieceForm ="pieces/pieceform";
	public static final String listePieceJSP="pieces/liste";

	
	@Autowired
	private IPieceService iPieceService;	
	
	@Autowired
	PieceFormValidator pieceFormValidator;
	
	//Définir le form validator
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
//		binder.setValidator(pieceFormValidator);
	}
	
	
	@GetMapping(value = listePiece)
	public String afficherTousLesPieces(Model model) {

		logger.debug("afficherTousLesPieces()");
		model.addAttribute("pieces", iPieceService.lister());
		return listePieceJSP;
	}
	
	

	@PostMapping(value = listePiece)
	public String enregistrerOuMettreAJourPiece(@ModelAttribute("pieceForm") @Validated Piece e,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {

		logger.debug("enregistrerOuMettreAJourPiece() : {}", e);

		if (result.hasErrors()) {
			peuplerModelParDefaut(model);
			return pieceForm;
		} else {

			// Ajouter des messages au flash scope
			redirectAttributes.addFlashAttribute("css", "success");
			if (e.isNew()) {
				iPieceService.enregistrer(e);
				redirectAttributes.addFlashAttribute("msg", "Étudiant ajouté avec succès!");
			} else {
				iPieceService.miseAJour(e);
				redirectAttributes.addFlashAttribute("msg", "Piece mis à jour avec succès!");
			}

			return "redirect:"+listePiece;

		}

	}

	// Affiche le formulaire d'ajout d'un étudiant
	@GetMapping(value = addPiece)
	public String afficherFormAjoutPiece(Model model) {

		logger.debug("afficherFormAjoutPiece()");

		Piece e = new Piece();

		// Valeur par défaut
		
		model.addAttribute("pieceForm", e);

		peuplerModelParDefaut(model);

		return pieceForm;
	}
	
	// Affiche le formulaire demise à jour
		@GetMapping(value = updatePiece)
		public String afficherFormMiseAJour(@PathVariable("id") Long id, Model model) {

			logger.debug("afficherFormMiseAJour() : {}", id);

			Piece e = iPieceService.trouver(id);
			model.addAttribute("pieceForm", e);
			
			peuplerModelParDefaut(model);
			
			return pieceForm;

		}
		// Supprimer un étudiant
		@GetMapping(value = deletePiece)
		public String supprimerPiece(@PathVariable("id") Long id, 
			final RedirectAttributes redirectAttributes) {

			logger.debug("supprimerPiece() : {}", id);

			iPieceService.suprimer(id);
			
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Piece supprimé!");
			
			return "redirect:"+listePiece;

		}
	private void peuplerModelParDefaut(Model model) {
		model.addAttribute("ecoles", iPieceService.lister());

	}

}
