package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import business.CommentService;
import business.SuggestionService;
import business.UserService;
import model.Category;
import model.Comment;
import model.Suggestion;
import model.User;
import repository.CategoryRepository;
import repository.SuggestionRepository;



@SpringBootApplication
public class Application {

	private UserService userService;
	
	
	private CommentService commentService;
	
	private SuggestionService suggestionService;
	
	private CategoryRepository categoryRepository;
	
    public static void main(String[] args) {
    	SpringApplication.run(Application.class, args);
    }
    
    public CommandLineRunner iniciarBD(SuggestionRepository sR){
    	return (args) -> {
    		User user1 = new User("user1");
    		user1.setPassword("user1");
    		
    		userService.addUser(user1);
    		
    		User user2 = new User("user2");
    		user2.setPassword("user2");
    		
    		userService.addUser(user2);
    		
    		User admin = new User("admin");
    		admin.setPassword("admin");
    		admin.setAdmin(true);

    		userService.addUser(admin);
    		
    		Category categoria1 = new Category("Categoria1");
    		Category categoria2 = new Category("Categoria2");
    		
    		categoryRepository.save(categoria1);
    		categoryRepository.save(categoria2);
    		
    		Suggestion sugerencia1 = new Suggestion("Sugerencia1 de prueba", categoria1, user1);
    		suggestionService.addSuggestion(sugerencia1);
    		Suggestion sugerencia2 = new Suggestion("Sugerencia2 de prueba", categoria1, user1);
    		suggestionService.addSuggestion(sugerencia2);
    		Suggestion sugerencia3 = new Suggestion("Sugerencia3 de prueba", categoria2, user1);
    		suggestionService.addSuggestion(sugerencia3);
    		
    		Comment comentario1 = new Comment("Comentario1 de prueba", sugerencia1, user2);
    		commentService.createComment(comentario1);
    		Comment comentario2 = new Comment("Comentario2 de prueba", sugerencia1, user2);
    		commentService.createComment(comentario2);
    		Comment comentario3 = new Comment("Comentario3 de prueba", sugerencia1, user2);
    		commentService.createComment(comentario3);
    	};
    }
}