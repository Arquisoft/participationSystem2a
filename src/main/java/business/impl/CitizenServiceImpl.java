package business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import business.CitizenService;
import model.Category;
import model.Citizen;
import model.Comment;
import model.Suggestion;
import model.exception.BusinessException;
import repository.CategoryRepository;
import repository.CitizenRepository;

public class CitizenServiceImpl implements CitizenService {

	@Autowired
	private CitizenRepository citizenRepository;
	private CategoryRepository categoryRepository;
	
	@Override
	public void createSugerencia(Citizen citizen, Category categoria, String titulo, String texto) {

		// Realizar comprobaciones previas

		boolean ComprobacionesPrevias = true;
		if (ComprobacionesPrevias) {
			Suggestion sugerencia1 = new Suggestion(citizen, categoria, titulo, texto);
		}
	}

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

	@Override
	public List<Category> getAllCategories() throws BusinessException {
		return categoryRepository.findAll();

	}



	@Override
	public void votarComentario() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public Citizen getCitizen(String dni) {
		Citizen c = this.citizenRepository.findByDni(dni);
		return c;
	}

}
