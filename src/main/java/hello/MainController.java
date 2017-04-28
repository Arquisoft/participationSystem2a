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
	
	@Autowired
	private CommentRepository CommentRepository;

	@Autowired
	private SuggestionService suggestionService;


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
		return "/user/createSuggestion";
	}

	@RequestMapping(value = "/createSuggestion", method = RequestMethod.POST)
	public String CrearSolicitud(HttpSession session, Model model) throws BusinessException {

		List<Category> categorias = Services.getSystemServices().findAllCategories();
		model.addAttribute("categorias", categorias);
		return "crearSugerencia";
	}

	@RequestMapping("/newComment")
	public String newComment(@RequestParam("sugerencia") Suggestion sugerencia) {
		this.nuevaSugerencia = sugerencia;
		return "/user/createComment";
	}

	@RequestMapping(value = "/createComment", method = RequestMethod.POST)
	public String añadirComentario(HttpSession session, Model model, @RequestParam String contenido)
			throws BusinessException {
		// OJO CON ESTA LINEA (user?citizen?)
		Comment comentario = new Comment(contenido, nuevaSugerencia, (Citizen) session.getAttribute("user"));

		// commentRepository.save(comentario);
		commentService.createComment(comentario);
		// commentService.createComentario(contenido, nuevaSugerencia, (Citizen)
		// session.getAttribute("user"));
		model.addAttribute("nuevaSugerencia", suggestionService.getSuggestion(nuevaSugerencia.getId()));
		return "mostrarSugerencia";
	}

	/*
	 * @RequestMapping(value = "/comment") public String
	 * addComment(@RequestParam String idSug, String comentario, Model model,
	 * HttpSession session) { Long id = Long.parseLong(idSug); Sugerencia
	 * sugerencia = suggestionService.findById(id); Citizen citizen = (Citizen)
	 * session.getAttribute("citizen");
	 * commentService.createComentario(comentario, sugerencia, citizen);
	 * sugerencia = suggestionService.findById(id);
	 * model.addAttribute("sugerencia", sugerencia); return
	 * "/user/viewSuggestion"; }
	 * 
	 */

	
	/*
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpSession session, Model model, @RequestParam String username,
			@RequestParam String password) {


		Citizen citizen = citizenService.getCitizen(username);

		if (citizen != null && password.equals(citizen.getPassword())) {
			session.setAttribute("user", new User(username, password));
			return "indexUsuario";
		}

		else if (citizen.isAdmin()) {
			session.setAttribute("user", new User(username, password));
			return "indexAdmin";
		}

		return "login";
	}
	*/
	
	
	
	 @RequestMapping(value="/login", method = RequestMethod.POST)
	    public String login(HttpSession session, Model model, @RequestParam String user, @RequestParam String password){
		 	
		 	//Da null, mirarlo
	    	User userLogin = UserService.findByUserAndPassword(user, password);
	    	
	    	if(userLogin!=null){
	    		session.setAttribute("user", userLogin);
	    		if(userLogin.isAdmin()){
	    			return "listaSugerenciasAdmin";
	    		}
	    		else{
	    			return "listaSugerencias";
	    		}
	    	}
	    	else{
	    		return "login";
	    	}
	    }

	@RequestMapping(value = "/logOut")
	public String logOut(HttpSession session) {

		session.setAttribute("citizen", null);
		return "/index";

	}

	@RequestMapping(value = "/mostrarSugerencia", method = RequestMethod.POST)
	public String mostrarSugerencia(HttpSession session, Model model, @RequestParam("sugerencia") Long id) {

		Suggestion sugerencia = suggestionService.getSuggestion(id);

		this.nuevaSugerencia = sugerencia;

		if (sugerencia != null) {
			model.addAttribute("nuevaSugerencia", sugerencia);
			User user = (User) session.getAttribute("user");

			if (user.isAdmin()) {
				return "mostrarSugerenciaAdmin";
			}
			return "mostrarSugerencia";
		}
		return "listaSugerencias";
	}

	@RequestMapping(value = "/listSuggestions", method = RequestMethod.POST)
	public String irALista(Model model) {
		List<Suggestion> sugerencias = suggestionService.findAll();
		model.addAttribute("sugerencias", sugerencias);
		return "listaSugerencias";
	}

	@RequestMapping(value = "/deleteComentario", method = RequestMethod.POST)
	public String eliminarComentario(HttpSession session, Model model, @RequestParam("comentario") Long id) {

		// commentRepository.delete(id);
		model.addAttribute("seleccionada", suggestionService.getSuggestion(nuevaSugerencia.getId()));

		return "mostrarSugerenciaAdmin";
	}

	@RequestMapping(value = "/eliminarSugerencia", method = RequestMethod.POST)
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