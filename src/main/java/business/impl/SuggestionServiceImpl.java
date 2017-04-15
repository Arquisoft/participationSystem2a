package business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import business.SuggestionService;
import model.Categoria;
import model.Citizen;
import model.Sugerencia;
import model.exception.BusinessException;
import repository.SuggestionRepository;

public class SuggestionServiceImpl implements SuggestionService {

	@Autowired
	private SuggestionRepository suggestionRepository;
	
	@Override
	public List<Sugerencia> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sugerencia findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sugerencia> findByCat(Categoria cat) {
		// TODO Auto-generated method stub
		return null;
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
	public void createSugerencia(Citizen citizen, Categoria categoria, String titulo, String contenido)
			throws BusinessException {
		// TODO Auto-generated method stub
		
	}

}
