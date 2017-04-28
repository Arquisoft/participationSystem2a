package model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "TCATEGORIA")
public class Category {

    Long id;
    String nombre;

    @OneToMany(mappedBy="TCATEGORIA", cascade = CascadeType.ALL)
    private Set<Suggestion> sugerencias;

    public Category(String nombre) {
	super();
	this.nombre = nombre;
    }

    public String getNombre() {
	return nombre;
    }

    public Long getId() {
	return id;
    }

    public Set<Suggestion> getSugerencias() {
	return new HashSet<Suggestion>(sugerencias);
    }

    public void addSugerencia(Suggestion sugerencia) {
	this.sugerencias.add(sugerencia);
    }

    @Override
    public int hashCode() {
	return nombre.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Category other = (Category) obj;
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
	return "Categoria [id=" + id + ", nombre=" + nombre + ", sugerencias=" + sugerencias + "]";
    }

}
