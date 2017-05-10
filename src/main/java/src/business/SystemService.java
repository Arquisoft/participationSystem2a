package src.business;

import java.util.List;

import src.model.Category;
import src.model.Suggestion;
import src.model.exception.BusinessException;



public interface SystemService {

    public List<Category> findAllCategories() throws BusinessException;

    public List<Suggestion> findAllSugerencias() throws BusinessException;

    public List<Suggestion> findSugerenciasByCategory(Long idCategory) throws BusinessException;

}
