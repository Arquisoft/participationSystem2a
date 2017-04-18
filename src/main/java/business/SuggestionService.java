package business;

import java.util.List;

import model.Categoria;
import model.Citizen;
import model.Sugerencia;
import model.exception.BusinessException;

public interface SuggestionService {
	
	List<Sugerencia>findAll();
    public Sugerencia findById(Long id);
    List<Sugerencia>findByCat(Categoria cat);
    void votePositiveSugerencia(Sugerencia sug, Citizen ciudadano) throws BusinessException;
    void voteNegativeSugerencia(Sugerencia sug, Citizen ciudadano) throws BusinessException;
    void createSugerencia(Citizen citizen, Categoria categoria, String titulo, String contenido) throws BusinessException;
	public Sugerencia getSuggestion(Long id);
	public void deleteSuggestion(Long id);


}
