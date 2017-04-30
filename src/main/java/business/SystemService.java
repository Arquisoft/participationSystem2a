package business;

import java.util.List;

import model.Category;
import model.Suggestion;
import model.exception.BusinessException;

public interface SystemService {

    public List<Category> findAllCategories() throws BusinessException;

    public List<Suggestion> findAllSugerencias() throws BusinessException;

    public List<Suggestion> findSugerenciasByCategory(Long idCategory) throws BusinessException;

}
