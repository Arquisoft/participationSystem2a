package model;

import java.util.List;

public class Sugerencia {

	//Las sugerencias podrán ser votadas por otros usuarios, que podrán aumentar o
	//disminuir su popularidad. 
	
	
	int votos;
	//Quizas hay que hacerlo de otra forma en vez de String, categoria??
	List<String> comentarios;
	
	
	public Sugerencia() {
		
	}
	
	public int getVotos() {
		return votos;
	}

	public List<String> getComentarios() {
		return comentarios;
	}

	public void incrementarVotos() {
		this.votos++;
	}

	public void decrementarVotos() {
		this.votos--;
	}

	public void addComentario(String comentario) {
		this.comentarios.add(comentario);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comentarios == null) ? 0 : comentarios.hashCode());
		result = prime * result + votos;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sugerencia other = (Sugerencia) obj;
		if (comentarios == null) {
			if (other.comentarios != null)
				return false;
		} else if (!comentarios.equals(other.comentarios))
			return false;
		if (votos != other.votos)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sugerencia [votos=" + votos + ", comentarios=" + comentarios + "]";
	}

	
	
}
