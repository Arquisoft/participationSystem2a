package src;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import src.business.CommentService;
import src.business.SuggestionService;
import src.business.UserService;
import src.model.*;
import src.repository.CategoryRepository;
import src.repository.SuggestionRepository;


@SpringBootApplication
public class Application {
	
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SuggestionService suggestionService;
	
    public static void main(String[] args) {
    	SpringApplication.run(Application.class, args);
    }
    
    
    @Bean
    public CommandLineRunner iniciarBD(SuggestionRepository sR){
    	return (args) -> {
    		
    		
    		User Joni = new User("Joni");
    		Joni.setContraseña("Joni");
    		userService.addUser(Joni);
    		
    		User user = new User("user");
    		user.setContraseña("user");
    		userService.addUser(user);
    		
    		User Pepe = new User("Pepe");
    		Pepe.setContraseña("Pepe");
    		userService.addUser(Pepe);

    		
    		User admin = new User("admin");
    		admin.setContraseña("admin");
    		admin.setAdmin(true);

    		userService.addUser(admin);
    		
    		
    		
    		Category categoria1 = new Category("Categoria1");
    		Category categoria2 = new Category("Categoria2");
    		
    		categoryRepository.save(categoria1);
    		categoryRepository.save(categoria2);
    		
    		
    		
    		Suggestion sugerencia1 = new Suggestion("Ampliar almacén", categoria1, Joni);
    		suggestionService.addSuggestion(sugerencia1);
    		Suggestion sugerencia2 = new Suggestion("Asfaltar plaza", categoria1, user);
    		suggestionService.addSuggestion(sugerencia2);
    		Suggestion sugerencia3 = new Suggestion("Cambiar alcantarilla", categoria2, Pepe);
    		suggestionService.addSuggestion(sugerencia3);
    		
    		
    		Comment comentario1 = new Comment("Me parece bien", sugerencia1, Joni);
    		commentService.addComment(comentario1);
    		Comment comentario2 = new Comment("NO QUIERO!!", sugerencia1, user);
    		commentService.addComment(comentario2);
    		Comment comentario3 = new Comment("+1 ", sugerencia1, Pepe);
    		commentService.addComment(comentario3);
    		Comment comentario4 = new Comment("Me parece bien", sugerencia2, Joni);
    		commentService.addComment(comentario4);
    		Comment comentario5 = new Comment("Buuuuu", sugerencia2, Pepe);
    		commentService.addComment(comentario5);
    	};
    }
}