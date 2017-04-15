package model;

import java.util.Date;
import java.util.List;

public class Sugerencia {

    // Las sugerencias podrán ser votadas por otros usuarios, que podrán
    // aumentar o disminuir su popularidad.

    int votos;
    String texto;
    String titulo;
    Categoria categoria;
    private Date fechaCreacion;
    private Citizen citizen;
    // Quizas hay que hacerlo de otra forma en vez de String, categoria??
    List<Comentario> comentarios;

    public Sugerencia(Categoria categoria, String titulo, String texto) {
	super();
	this.categoria = categoria;
	this.titulo = titulo;
	this.texto = texto;
    }

    public Sugerencia(Citizen citizen, Categoria categoria, String titulo, String texto) {
	super();
	this.citizen = citizen;
	this.categoria = categoria;
	this.titulo = titulo;
	this.texto = texto;
    }

    public Sugerencia(Citizen citizen, Categoria categoria, String titulo, String texto, Date fechaCreacion) {
	super();
	this.citizen = citizen;
	this.categoria = categoria;
	this.titulo = titulo;
	this.texto = texto;
	this.fechaCreacion = fechaCreacion;
    }

    public int getVotos() {
	return votos;
    }

    public List<Comentario> getComentarios() {
	return comentarios;
    }

    public void incrementarVotos() {
	this.votos++;
    }

    public void decrementarVotos() {
	this.votos--;
    }

    public void addComentario(Comentario comentario) {
	this.comentarios.add(comentario);
    }

    public String getTexto() {
	return texto;
    }

    public void setTexto(String texto) {
	this.texto = texto;
    }

    public String getTitulo() {
	return titulo;
    }

    public void setTitulo(String titulo) {
	this.titulo = titulo;
    }

    public Categoria getCategoria() {
	return categoria;
    }

    public void setCategoria(Categoria categoria) {
	this.categoria = categoria;
    }

    public void setComentarios(List<Comentario> comentarios) {
	this.comentarios = comentarios;
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
