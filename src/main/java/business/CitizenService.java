package business;

import model.Comentario;
import model.Sugerencia;

public interface CitizenService {
	
	public void addSugerencia(Sugerencia sugerencia);
	
	public void addComentario(Comentario comentario);
	
	public void updateSugerencia(Sugerencia sugerencia);
	
	public void deleteSugerencia(Long id);
	
	public void deleteComentario(Long id);
	

}
