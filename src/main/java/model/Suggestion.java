package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Suggestion {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String texto;

	@Enumerated(EnumType.STRING)
	private SuggestionStatus status;

	@Temporal(TemporalType.DATE)
	private Date date;

	@ManyToOne
	private User user;

	@ManyToOne
	private Category category;

	private int votesPlus;
	private int votesMinus;

	@OneToMany(mappedBy="sugerencia")
	private Set<Comment> comments = new HashSet<>();

	Suggestion(){}

	public Suggestion(String texto, Category category, User user) {
		super();
		this.texto = texto;
		this.date = new Date();
		this.user = user;
		this.category = category;
		this.votesPlus = 0;
		this.votesMinus = 0;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getDate() {
		return date;
	}

	public Long getId() {
		return id;
	}

	protected void _setUser(User user){
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public Category getCategory() {
		return category;
	}

	public int getVotesPlus() {
		return votesPlus;
	}

	public int getVotesMinus() {
		return votesMinus;
	}

	protected Set<Comment> _getComments() {
		return comments;
	}

	public Set<Comment> getComments() {
		return new HashSet<>(comments);
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public void addComment(Comment comment){
		comments.add(comment);
	}

	public void addVotePlus(){
		this.votesPlus++;
	}

	public void addVoteMinus() {
		this.votesMinus++;
	}

	public SuggestionStatus getStatus() {
		return status;
	}

	public void setStatus(SuggestionStatus status) {
		this.status = status;
	}


	
	
}
