package src.business.impl;

import java.util.List;

import src.business.SystemService;
import src.model.Category;
import src.model.Suggestion;
import src.model.exception.BusinessException;
import src.repository.CategoryRepository;
import src.repository.SuggestionRepository;



public class SystemServiceImpl implements SystemService {

	private CategoryRepository categoryRepository;
	private SuggestionRepository suggestionRepository;


    

    @Override
    public List<Category> findAllCategories() throws BusinessException {
    	List<Category> categories= this.categoryRepository.findAll();
		return categories;
    }

    @Override
    public List<Suggestion> findAllSugerencias() throws BusinessException {
    	List<Suggestion> suggestions= this.suggestionRepository.findAll();
		return suggestions;
    }

    @Override
    public List<Suggestion> findSugerenciasByCategory(Long idCategory) throws BusinessException {
	return null;
    }

}
