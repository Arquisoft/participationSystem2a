package business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import business.CitizenService;
import model.Categoria;
import model.Citizen;
import model.Comentario;
import model.Sugerencia;
import model.exception.BusinessException;
import repository.CitizenRepository;

public class CitizenServiceImpl implements CitizenService {

	@Autowired
	private CitizenRepository citizenRepository;
	
	@Override
	public void createSugerencia(Citizen citizen, Categoria categoria, String titulo, String texto) {

		// Realizar comprobaciones previas

		boolean ComprobacionesPrevias = true;
		if (ComprobacionesPrevias) {
			Sugerencia sugerencia1 = new Sugerencia(citizen, categoria, titulo, texto);
		}
	}

	@Override
	public void createComentario(Comentario comentario) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateSugerencia(Sugerencia sugerencia) {
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
	public void getAllCategories() throws BusinessException {

	}



	@Override
	public void votarComentario() {
		// TODO Auto-generated method stub

	}

}
