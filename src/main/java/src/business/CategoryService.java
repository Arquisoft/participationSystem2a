package src.business;

import java.util.List;

import src.model.Category;
import src.model.exception.BusinessException;

public interface CategoryService {

	
List<Category> findAll();
    
    Category findByName(String name);
    
    Category findById(Long id);

    public void createCategory(Category categoria) throws BusinessException;
}
