package business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import business.SuggestionService;
import model.Category;
import model.Citizen;
import model.Sugerencia;
import model.exception.BusinessException;
import repository.SuggestionRepository;


public class SuggestionServiceImpl implements SuggestionService {

    @Autowired
    private SuggestionRepository suggestionRepository;

    @Autowired
    public void setSuggestionRepository(SuggestionRepository sRep) {
        this.suggestionRepository = sRep;
    }
       
//    @Autowired
//    public void setConfigurationRepository(ConfigurationRepository configurationRepository) {
//		this.configurationRepository = configurationRepository;
//	}
    
    @Override
    public List<Sugerencia> findAll() {
	return this.suggestionRepository.findAll();

    }

    // BORRAR MAS ADELANTE
    @Override
    public Sugerencia findById(Long id) {
	return this.suggestionRepository.findOne(id);

    }

    @Override
    public Sugerencia getSuggestion(Long id) {
	return suggestionRepository.findOne(id);
    }

    @Override
    public List<Sugerencia> findByCat(Category cat) {
	return this.suggestionRepository.findByCategoria(cat);

    }

    @Override
    public void votePositiveSugerencia(Sugerencia sug, Citizen ciudadano) throws BusinessException {
	// TODO Auto-generated method stub

    }

    @Override
    public void voteNegativeSugerencia(Sugerencia sug, Citizen ciudadano) throws BusinessException {
	// TODO Auto-generated method stub

    }

    @Override
    public void createSugerencia(Citizen citizen, Category categoria, String titulo, String texto)
	    throws BusinessException {
	try {
	    Sugerencia sugerencia = new Sugerencia(citizen, categoria, titulo, texto);
	    suggestionRepository.save(sugerencia);
	    /*
	     * Tenemos que crear un log
	     * LOG.send(Topics.CREATE_sugerenciaGESTION, sugerencia.getTitulo()
	     * + sugerencia.getTexto() + separator + sugerencia.getCategoria());
	     */
	} catch (Exception e) {
	    throw new BusinessException("No se ha podido crear la sugerencia.");
	}

    }

    @Override
    public void deleteSuggestion(Long id) {
	suggestionRepository.delete(id);
    }

}
