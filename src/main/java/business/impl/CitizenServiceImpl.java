package business.impl;

import business.CitizenService;
import model.Categoria;
import model.Citizen;
import model.Comentario;
import model.Sugerencia;

public class CitizenServiceImpl implements CitizenService {



	@Override
	public void createSugerencia(Citizen citizen, Categoria categoria, String titulo, String texto) {

		//Realizar comprobaciones previas

		boolean ComprobacionesPrevias = true;
		if(ComprobacionesPrevias){
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
	public void votarComentario() {
		// TODO Auto-generated method stub

	}



}
