package sn.esmt.proxibank.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sn.esmt.proxibank.domaine.StatutUser;
import sn.esmt.proxibank.domaine.User;
import sn.esmt.proxibank.service.IConseillerService;
import sn.esmt.proxibank.service.IUserService;

@Controller
@SessionAttributes("user")
public class HomeController {
	
	
    public static User user;

	
	public static final String login ="/test";
	public static final String deconnecte ="/deconnecte";
	
	@Autowired
	private IUserService iUserService;

	@Autowired
	private IConseillerService iConseillerService;

	
	/**
	 * 
	 * @param response
	 * @return "/login"
	 * point d'entrée principale de l'application. redirige vers la JSP login.jsp pour la connexion
	 * @throws IOException
	 */
	@RequestMapping(value="/")
	public String login(HttpServletResponse response) throws IOException{
		return "/login";
	}

	
	
	/**
	 * 
	 * @param login
	 * @param password
	 * @param redirectAttributes
	 * @param session
	 * @param model
	 * @return lien de page d'accueil
	 * methode qui s'excecute après la reception des données du formulaire de login pour vérification et acceptation ou refus
	 */
	@RequestMapping(value=login)
	public String test(@RequestParam("login") String login,@RequestParam("password") String password,final RedirectAttributes redirectAttributes, HttpSession session ,Model model)  {

		
		if(((User)session.getAttribute("user"))!=null )
		{
			System.out.print(((User)session.getAttribute("user")).getId());
			if(((User)session.getAttribute("user")).getStatut().equals(StatutUser.ADMIN.toString())){
				if(login.equals("admin") && password.equals("admin")) {
					return "redirect:"+ConseillerController.listeConseiller;
				}
				else 
				{
					redirectAttributes.addFlashAttribute("css", "danger");
					redirectAttributes.addFlashAttribute("msg", "Une session valide reside dans le navigateur! Veuillez vous y connectez ou fermez le navigateur");
					return "redirect:"+deconnecte;
				}
			}
			else {
				if(login.equals(((User)session.getAttribute("user")).getLogin()) && password.equals(((User)session.getAttribute("user")).getPassword())) {
					return "redirect:"+ClientController.listeClient;
				}
				else {
					redirectAttributes.addFlashAttribute("css", "danger");
					redirectAttributes.addFlashAttribute("msg", "Une session valide reside dans le navigateur! Veuillez vous y connectez ou fermez le navigateur");

					return "redirect:"+deconnecte;
				}
				
			}
		}
		else {
		
			if(login.equals("admin") && password.equals("admin"))
			{
				user = new User("admin","admin","admin@admin.com","4545454",StatutUser.ADMIN.toString());
				session.setAttribute("user", user);
				return "redirect:"+ConseillerController.listeConseiller;
			}
			else
			{
				user = iConseillerService.findByLoginAndPassword(login, password);
				if(user!=null) {
					session.setAttribute("user", user);
					return "redirect:"+ClientController.listeClient;
				}
			}
		}
		return "/login";
	}
	
	/**
	 * 
	 * @param session
	 * @return
	 * methode qui s'excecute après l'appui sur le bouton deconnexion 
	 */
	@RequestMapping(value=deconnecte)
	public String deconnecte(HttpSession session)
		{
		if (session != null && user!=null) {
			session.removeAttribute(null);
	        session.invalidate();
	    }			
		return "/login";
	}


}
