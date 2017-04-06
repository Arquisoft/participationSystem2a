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

import business.Services;
import hello.producers.KafkaProducer;
import model.Categoria;
import model.User;
import model.exception.BusinessException;

@Controller
public class MainController {

    @Autowired
    private KafkaProducer kafkaProducer;

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
    
    @RequestMapping(value = "/crearSugerencia", method = RequestMethod.POST)
    public String CrearSolicitud(HttpSession session,Model model) throws BusinessException {
    	
    		List<Categoria> categorias = Services.getSystemServices().findAllCategories();
    		model.addAttribute("categorias", categorias);
    		return "crearSugerencia";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpSession session,Model model,@RequestParam String username, @RequestParam String password) {
    	
    	//Mirar como hacer el login para usuario y admin
    	boolean validar = true;
    	boolean admin = false;
    	
    	if(validar){
    		session.setAttribute("user", new User(username,password));
    		return "user";
    	}
    	
    	else if(admin){
    		session.setAttribute("user", new User(username,password));
    		return "admin";
    	}

    		return "login";	
    }

}