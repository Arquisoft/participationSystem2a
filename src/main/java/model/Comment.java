package model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String comment;
    String texto;
    Citizen citizen;
    Suggestion suggestion;
	@ManyToOne
	private User user;
	@Temporal(TemporalType.DATE)
	private Date date;

    public Comment(String comment) {
	super();
	this.comment = comment;
    }

    public Comment(String texto, Suggestion suggestion, Citizen citizen) {
	this.texto = texto;
	this.suggestion = suggestion;
	this.citizen = citizen;
    }
    
    public Comment(String texto, Suggestion suggestion, User user) {
		super();
		this.texto = texto;
		this.suggestion = suggestion;
		this.user = user;
		this.date = new Date();
	}

    public String getComentario() {
	return comment;
    }

    void setComentario(String comment) {
	this.comment = comment;
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

    public Suggestion getSuggestion() {
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
	Comment other = (Comment) obj;
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
    
   
	
	protected void _setSuggestion(Suggestion suggestion){
		this.suggestion = suggestion;
	}
	
	public User getUsuario() {
		return user;
	}
	
	protected void _setUser(User user){
		this.user = user;
	}

}
