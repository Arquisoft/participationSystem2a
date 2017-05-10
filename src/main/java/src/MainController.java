package src;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import src.business.SuggestionService;
import src.business.UserService;
import src.model.Association;
import src.model.Category;
import src.model.Comment;
import src.model.Suggestion;
import src.model.User;
import src.producers.KafkaProducer;
import src.repository.CategoryRepository;
import src.repository.CommentRepository;

@Controller
public class MainController {

	@Autowired
	private UserService userService;

	@Autowired
	private SuggestionService suggestionService;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CommentRepository CommentRepository;

	@Autowired
	private KafkaProducer kafkaProducer;

	private Suggestion seleccionada;

	@RequestMapping("/")
	public String landing(Model model) {
		model.addAttribute("message", new Message());
		return "login";
	}

	@RequestMapping("/send")
	public String send(Model model, @ModelAttribute Message message) {
		kafkaProducer.send("exampleTopic", message.getMessage());        
		return "redirect:/";
	}

	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(HttpSession session, Model model, @RequestParam String nombre, @RequestParam String password){

		User userLogin = userService.findByUserAndPassword(nombre, password);

		if(userLogin!=null){
			
			//Ponemos al usuario en sesion 
			session.setAttribute("user", userLogin);
			//Y cargamos el modelo
			loadSuggestions(model);

			if(userLogin.isAdmin()){
				return "listSuggestionsAdmin";
			}
			else{
				return "listSuggestions";
			}
		}
		else{
			return "login";
		}
	}

	@RequestMapping(value="/logout", method = RequestMethod.POST)
	public String cerrarSesion(HttpSession session){
		//Ponemos el userLogin en sesion a null
		session.setAttribute("user", null);
		return "login";
	}

	@RequestMapping(value="/listSuggestions", method = RequestMethod.POST)
	public String irALista(Model model){
		loadSuggestions(model);
		return "listSuggestions";
	}
	
	@RequestMapping(value="/listSuggestionsAdmin", method = RequestMethod.POST)
	public String irAListaAdmin(Model model){
		loadSuggestions(model);
		return "listSuggestionsAdmin";
	}

	private void loadSuggestions(Model model){
		List<Suggestion> sugerencias = suggestionService.getSuggestions();
		model.addAttribute("sugerencias", sugerencias);
	}

	@RequestMapping("/newSuggestion")
	public String nuevaSugerencia(){
		return "addSuggestion";
	}

	@RequestMapping(value="/addSuggestion", method = RequestMethod.POST)
	public String addSuggestion(HttpSession session, Model model, @RequestParam String contenido){
		List<Category> categorias = categoryRepository.findAll();    	
		Suggestion suggestion = new Suggestion(contenido, categorias.get(0), (User)session.getAttribute("user"));
		suggestionService.addSuggestion(suggestion);
		loadSuggestions(model);
		return "listSuggestions";
	}

	@RequestMapping(value="/mostrar", method = RequestMethod.POST)
	public String showSuggestion(HttpSession session, Model model, @RequestParam("sugerencia") Long id){
		Suggestion sugerencia = suggestionService.getSuggestion(id);
		this.seleccionada=sugerencia;
		if(sugerencia!=null){
			model.addAttribute("seleccionada", sugerencia);
			User user = (User)session.getAttribute("user");
			if(user.isAdmin()){
				return "showSuggestionAdmin";
			}
			return "showSuggestion";
		}
		return "listSuggestions";
	}

	@RequestMapping("/nuevoComentario")
	public String nuevoComentario(@RequestParam("sugerencia") Suggestion sugerencia){
		this.seleccionada=sugerencia;
		return "addComment";
	}

	@RequestMapping(value="/addComment", method = RequestMethod.POST)
	public String addComment(HttpSession session, Model model, @RequestParam String contenido){
		Comment comentario = new Comment(contenido, seleccionada, (User)session.getAttribute("user"));
		CommentRepository.save(comentario);
		model.addAttribute("seleccionada", suggestionService.getSuggestion(seleccionada.getId()));
		return "showSuggestion";
	}

	@RequestMapping(value="/deleteComment", method = RequestMethod.POST)
	public String deleteComment(HttpSession session, Model model, @RequestParam("comentario") Long id){
		CommentRepository.delete(id);
		model.addAttribute("seleccionada", suggestionService.getSuggestion(seleccionada.getId()));
		return "showSuggestionAdmin";
	}

	@RequestMapping(value="/deleteSuggestion", method = RequestMethod.POST)
	public String deleteSuggestion(Model model, @RequestParam("sugerencia") Long id){
		Suggestion s = suggestionService.getSuggestion(id);
		Association.AsignarSugerencia.unlink(s.getUsuario(), s);
		for(Comment c: s.getComentarios()){
			CommentRepository.delete(c);
		}
		suggestionService.deleteSuggestion(id);
		loadSuggestions(model);
		return "listSuggestionsAdmin";
	}
}