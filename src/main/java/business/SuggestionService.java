package business;

import java.util.List;

import model.Category;
import model.Citizen;
import model.Suggestion;
import model.exception.BusinessException;

public interface SuggestionService {

    List<Suggestion> findAll();

    public Suggestion findById(Long id);

    List<Suggestion> findByCat(Category cat);

    void votePositiveSugerencia(Suggestion sug, Citizen ciudadano) throws BusinessException;

    void voteNegativeSugerencia(Suggestion sug, Citizen ciudadano) throws BusinessException;

    void createSugerencia(Citizen citizen, Category categoria, String titulo, String contenido)
	    throws BusinessException;

    public Suggestion getSuggestion(Long id);

    public void deleteSuggestion(Long id);

}
