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

import business.CommentService;
import business.Services;
import business.SuggestionService;
import hello.producers.KafkaProducer;
import model.Category;
import model.Citizen;
import model.Comentario;
import model.Sugerencia;
import model.User;
import model.exception.BusinessException;

@Controller
public class MainController {

    @Autowired
    private KafkaProducer kafkaProducer;
    private Sugerencia nuevaSugerencia;
//    @Autowired
//    private CommentRepository commentRepository;
    @Autowired
    private SuggestionService suggestionService;
    @Autowired
    private CommentService commentService;
    
    @Autowired
    public void setSuggestionService(SuggestionService suggestionService) {
        this.suggestionService = suggestionService;
    }

    @RequestMapping("/")
    public String landing(Model model) {
	model.addAttribute("message", new Message());
	return "index";
    }

    @RequestMapping("/send")
    public String send(Model model, @ModelAttribute Message message) {
	kafkaProducer.send("exampleTopic", message.getMessage());
	return "redirect:/";
    }

    @RequestMapping("/newSuggestion")
    public String nuevaSugerencia() {
	return "createSuggestion";
    }

    @RequestMapping(value = "/createSuggestion", method = RequestMethod.POST)
    public String CrearSolicitud(HttpSession session, Model model) throws BusinessException {

	List<Category> categorias = Services.getSystemServices().findAllCategories();
	model.addAttribute("categorias", categorias);
	return "crearSugerencia";
    }

    @RequestMapping("/newComment")
    public String newComment(@RequestParam("sugerencia") Sugerencia sugerencia) {
	this.nuevaSugerencia = sugerencia;
	return "añadirComentario";
    }

    @RequestMapping(value = "/createComment", method = RequestMethod.POST)
    public String añadirComentario(HttpSession session, Model model, @RequestParam String contenido) throws BusinessException {
	// OJO CON ESTA LINEA (user?citizen?)
	Comentario comentario = new Comentario(contenido, nuevaSugerencia, (Citizen) session.getAttribute("user"));

//	commentRepository.save(comentario);
	commentService.createComentario(comentario);
//	commentService.createComentario(contenido, nuevaSugerencia, (Citizen) session.getAttribute("user"));
	model.addAttribute("nuevaSugerencia", suggestionService.getSuggestion(nuevaSugerencia.getId()));
	return "mostrarSugerencia";
    }
    
    /*
     * @RequestMapping(value = "/comment")
	public String addComment(@RequestParam String idSug, String comentario, Model model, HttpSession session) {
		Long id = Long.parseLong(idSug);
		Sugerencia sugerencia = suggestionService.findById(id);
		Citizen citizen = (Citizen) session.getAttribute("citizen");
		commentService.createComentario(comentario, sugerencia, citizen);
		sugerencia = suggestionService.findById(id);
		model.addAttribute("sugerencia", sugerencia);
		return "/user/viewSuggestion";
	}
     * 
     */

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, Model model, @RequestParam String username,
	    @RequestParam String password) {

	// Mirar como hacer el login para usuario y admin
	boolean validar = true;
	boolean admin = false;

	if (validar) {
	    session.setAttribute("user", new User(username, password));
	    return "user";
	}

	else if (admin) {
	    session.setAttribute("user", new User(username, password));
	    return "admin";
	}

	return "login";
    }

    @RequestMapping(value = "/logOut")
    public String logOut(HttpSession session) {

	session.setAttribute("citizen", null);
	return "/index";

    }

    @RequestMapping(value = "/mostrarSugerencia", method = RequestMethod.POST)
    public String mostrarSugerencia(HttpSession session, Model model, @RequestParam("sugerencia") Long id) {

	Sugerencia sugerencia = suggestionService.getSuggestion(id);

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
	List<Sugerencia> sugerencias = suggestionService.findAll();
	model.addAttribute("sugerencias", sugerencias);
	return "listaSugerencias";
    }

//    @RequestMapping(value = "/deleteComentario", method = RequestMethod.POST)
//    public String eliminarComentario(HttpSession session, Model model, @RequestParam("comentario") Long id) {
//
////	commentRepository.delete(id);
//	model.addAttribute("seleccionada", suggestionService.getSuggestion(nuevaSugerencia.getId()));
//
//	return "mostrarSugerenciaAdmin";
//    }

//    @RequestMapping(value = "/eliminarSugerencia", method = RequestMethod.POST)
//    public String eliminarSugerencia(Model model, @RequestParam("sugerencia") Long id) {
//	Sugerencia sugerencia = suggestionService.getSuggestion(id);
//	// Borra los comentarios escritos en ella
//	for (Comentario c : sugerencia.getComentarios()) {
//	    commentRepository.delete(c);
//	}
//	suggestionService.deleteSuggestion(id);
//	// Las vuelve a cargar
//	List<Sugerencia> sugerencias = suggestionService.findAll();
//	model.addAttribute("sugerencias", sugerencias);
//	return "listaSugerenciasAdmin";
//    }

}