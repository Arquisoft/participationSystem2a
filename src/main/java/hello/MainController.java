package hello;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import business.CitizenService;
import business.CommentService;
import business.Services;
import business.SuggestionService;
import business.UserService;
import hello.producers.KafkaProducer;
import model.Category;
import model.Citizen;
import model.Comment;
import model.Suggestion;
import model.User;
import model.exception.BusinessException;
import repository.CategoryRepository;
import repository.CommentRepository;
import model.Association;

@Controller
public class MainController {

	@Autowired
	private KafkaProducer kafkaProducer;
	private Suggestion nuevaSugerencia;
	private CommentService commentService;
	private CitizenService citizenService;
	private UserService UserService;
	private Auxiliar aux = new Auxiliar();


	private CommentRepository CommentRepository;
	private SuggestionService suggestionService;
	private CategoryRepository CategoryRepository;


	public void setSuggestionService(SuggestionService suggestionService) {
		this.suggestionService = suggestionService;
	}

	@RequestMapping("/")
	public String landing(Model model) {
		model.addAttribute("message", new Message());
		return "login";
	}

	// @RequestMapping("/login")
	// public String userMenu(Model model) {
	// model.addAttribute("message", new Message());
	// return "/user/index";
	// }

	@RequestMapping("/send")
	public String send(Model model, @ModelAttribute Message message) {
		kafkaProducer.send("exampleTopic", message.getMessage());
		return "redirect:/";
	}

	@RequestMapping("/newSuggestion")
	public String nuevaSugerencia() {
		return "addSuggestion";
	}

	/*
	@RequestMapping(value = "/createSuggestion", method = RequestMethod.POST)
	public String CrearSolicitud(HttpSession session, Model model) throws BusinessException {

		List<Category> categorias = Services.getSystemServices().findAllCategories();
		model.addAttribute("categorias", categorias);
		return "createSuggestion";
	}
	*/

	@RequestMapping("/newComment")
	public String newComment(@RequestParam("suggestion") Suggestion suggestion) {
		aux.setSelected(suggestion);
		return "addComment";
	}

	@RequestMapping(value = "/addComment", method = RequestMethod.POST)
	public String addComment(HttpSession session, Model model, @RequestParam String texto)
			throws BusinessException {
		Comment comment = new Comment(texto, aux.getSelected(), (User) session.getAttribute("user"));
		CommentRepository.save(comment);
		model.addAttribute("selected", suggestionService.getSuggestion(aux.getSelected().getId()));
		return "showSuggestion";
	}


	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(HttpSession session, Model model, @RequestParam String user, @RequestParam String password){
		
		User userLogin = UserService.findByUserAndPassword(user, password);
		
		if (userLogin != null) {
			session.setAttribute("user", userLogin);
			List<Suggestion> suggestions  = suggestionService.getSuggestions();
			model.addAttribute("suggestions ", suggestions );
			
			if (userLogin.isAdmin()) {
				return "listSuggestionsAdmin";
			} else {
				return "listSuggestions";
			}
		} else {
			return "login";
		}

	}

	@RequestMapping(value = "/logOut")
	public String logOut(HttpSession session) {

		session.setAttribute("citizen", null);
		return "login";

	}

	@RequestMapping(value = "/show", method = RequestMethod.POST)
	public String mostrarSugerencia(HttpSession session, Model model, @RequestParam("suggestion") Long id) {
		User user = (User) session.getAttribute("user");
		Suggestion suggestion = suggestionService.getSuggestion(id);
		aux.setSelected(suggestion);
		if (suggestion != null) {
			model.addAttribute("nuevaSugerencia", suggestion);


			if (user.isAdmin()) {
				return "showSuggestionAdmin";
			}
			return "showSuggestion";
		}
		if (user.isAdmin()) {
			return "listSuggestionsAdmin";
		}
		return "listSuggestions";
	}


	@RequestMapping(value = "/addSuggestion", method = RequestMethod.POST)
	public String addSuggestion(HttpSession session, Model model, @RequestParam String texto) {

		List<Category> categorias = CategoryRepository.findAll();

		Suggestion suggestion = new Suggestion(texto, categorias.get(0), (User) session.getAttribute("user"));
		suggestionService.addSuggestion(suggestion);
		List<Suggestion> suggestions  = suggestionService.getSuggestions();
		model.addAttribute("suggestions ", suggestions );
		return "listSuggestions";
	}

	@RequestMapping(value = "/listSuggestions", method = RequestMethod.POST)
	public String showList(Model model) {
		List<Suggestion> sugerencias = suggestionService.findAll();
		model.addAttribute("sugerencias", sugerencias);
		return "listaSugerencias";
	}
	
	@RequestMapping(value = "/listSuggestionsAdmin", method = RequestMethod.POST)
	public String showListAdmin(Model model) {
		List<Suggestion> sugerencias = suggestionService.findAll();
		model.addAttribute("sugerencias", sugerencias);
		return "listaSugerencias";
	}

	@RequestMapping(value = "/deleteComment", method = RequestMethod.POST)
	public String eliminarComentario(HttpSession session, Model model, @RequestParam("comentario") Long id) {

		CommentRepository.delete(id);
		model.addAttribute("selected", suggestionService.getSuggestion(aux.getSelected().getId()));
		return "showSuggestionAdmin";
	}

	@RequestMapping(value = "/deleteSuggestion", method = RequestMethod.POST)
	public String deleteSuggestion(Model model, @RequestParam("suggestion") Long id) {
		Suggestion sug = suggestionService.getSuggestion(id);
		Association.AsignSuggestion.unlink(sug.getUser(), sug);
		for(Comment c: sug.getComments()){
			CommentRepository.delete(c);
		}
		suggestionService.deleteSuggestion(id);
		List<Suggestion> suggestions = suggestionService.getSuggestions();
		model.addAttribute("sugerencias", suggestions);
		return "listaSugerenciasAdmin";
	}


}