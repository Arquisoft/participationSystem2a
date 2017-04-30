package business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import business.CategoryService;
import model.Category;
import model.exception.BusinessException;
import repository.CategoryRepository;

public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createCategory(Category categoria) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

}
