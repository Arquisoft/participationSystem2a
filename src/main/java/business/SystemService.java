package business;

import java.util.List;

import model.Category;
import model.Sugerencia;
import model.exception.BusinessException;

public interface SystemService {

    public List<Category> findAllCategories() throws BusinessException;

    public List<Sugerencia> findAllSugerencias() throws BusinessException;

    public List<Sugerencia> findSugerenciasByCategory(Long idCategory) throws BusinessException;

}
