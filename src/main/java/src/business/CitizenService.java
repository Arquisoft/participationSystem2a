package src.business;

import java.util.List;

import src.model.Category;
import src.model.Citizen;
import src.model.Comment;
import src.model.Suggestion;
import src.model.exception.BusinessException;


public interface CitizenService {
	
	   public void createSugerencia(Citizen citizen, Category categoria, String titulo, String texto);

	    public void createComentario(Comment comentario);

	    public void updateSugerencia(Suggestion sugerencia);

	    public void deleteSugerencia(Long id);

	    public void deleteComentario(Long id);

	    public void votarSugerencia();

	    public void votarComentario();

		public List<Category> getAllCategories() throws BusinessException;

		Citizen getCitizen(String dni);

}
