package business;

import java.util.List;

import model.Category;
import model.Citizen;
import model.Comment;
import model.Suggestion;
import model.exception.BusinessException;

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
