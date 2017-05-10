package src.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.business.CitizenService;
import src.model.Category;
import src.model.Citizen;
import src.model.Comment;
import src.model.Suggestion;
import src.model.exception.BusinessException;
import src.repository.CategoryRepository;
import src.repository.CitizenRepository;

@Service
public class CitizenServiceImpl implements CitizenService{
	
	@Autowired
	private CitizenRepository citizenRepository;
	private CategoryRepository categoryRepository;
	

	@Override
	public void createComentario(Comment comentario) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateSugerencia(Suggestion sugerencia) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteSugerencia(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteComentario(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void votarSugerencia() {
		// TODO Auto-generated method stub

	}

	/*
	@Override
	public List<Category> getAllCategories() throws BusinessException {
		return categoryRepository.findAll();

	}
	*/



	@Override
	public void votarComentario() {
		// TODO Auto-generated method stub

	}
	
	/*
	@Override
	public Citizen getCitizen(String dni) {
		Citizen c = this.citizenRepository.findByDni(dni);
		return c;
	}
	*/

	@Override
	public void createSugerencia(Citizen citizen, Category categoria, String titulo, String texto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Category> getAllCategories() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Citizen getCitizen(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

}
