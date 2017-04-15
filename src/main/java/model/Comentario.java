package model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Comentario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String comentario;
    String texto;
    Citizen citizen;
	Sugerencia suggestion;

    public Comentario(String comentario) {
	super();
	this.comentario = comentario;
    }

    public Comentario(String texto, Sugerencia suggestion, Citizen citizen) {
    	this.texto = texto;
		this.suggestion = suggestion;
		this.citizen = citizen;
	}

	public String getComentario() {
	return comentario;
    }

    void setComentario(String comentario) {
	this.comentario = comentario;
    }
    
    public Citizen getCitizen() {
		return citizen;
	}

	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}

	public Long getId() {
		return id;
	}

	public String getTexto() {
		return texto;
	}

	public Sugerencia getSuggestion() {
		return suggestion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Comentario other = (Comentario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comentario [texto=" + texto + ", citizen=" + citizen + ", suggestion=" + suggestion + "]";
	}
	
	
	
	
	
    

}
