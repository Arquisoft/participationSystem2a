package business;

import java.util.List;

import model.Category;
import model.exception.BusinessException;

public interface CategoryService {
	

    List<Category> findAll();
    
    Category findByName(String name);
    
    Category findById(Long id);

    public void createCategory(Category categoria) throws BusinessException;

}
