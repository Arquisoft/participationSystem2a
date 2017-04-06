package model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="TCATEGORIA")
public class Categoria {


	Long id;
	String nombre;

	protected Set<Sugerencia> sugerencias;

	public Categoria(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	public Long getId() {
		return id;
	}

	public Set<Sugerencia> getSugerencias() {
		return sugerencias;
	}

	public void addSugerencia(Sugerencia sugerencia) {
		this.sugerencias.add(sugerencia);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Categoria [nombre=" + nombre + ", sugerencias=" + sugerencias + "]";
	}






}
