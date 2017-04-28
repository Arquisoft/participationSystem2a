package business.impl;

import java.util.List;

import business.SystemService;
import model.Category;
import model.Suggestion;
import model.exception.BusinessException;
import repository.CategoryRepository;
import repository.SuggestionRepository;

public class SystemServiceImpl implements SystemService {

    private CommandExecutor cmd = new CommandExecutor();
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
	// TODO Auto-generated method stub
	return null;
    }

}
