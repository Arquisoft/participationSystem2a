package business;

import java.util.List;

import model.Categoria;
import model.exception.BusinessException;

public interface CategoryService {
	

    List<Categoria> findAll();
    
    Categoria findByName(String name);
    
    Categoria findById(Long id);

    public void createCategory(Categoria categoria) throws BusinessException;

}
