package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	String user;
	String password;
	private boolean isAdmin;
	private Citizen citizen;

	@OneToMany(mappedBy="usuario")
	private Set<Suggestion> suggestions = new HashSet<>();
	@OneToMany(mappedBy="usuario")
	private Set<Comment> comments = new HashSet<>();



	public User(String user, String password) {
		this.user = user;
		this.password = password;
	}

	public User(String user) {
		this.user = user;
	}

	public User(String user, String password, Citizen citizen) {
		this(user);
		this.password = password;
		this.citizen = citizen;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public Citizen getCitizen() {
		return citizen;
	}

	@Override
	public String toString() {
		return "User [user=" + user + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		User other = (User) obj;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}





	protected void _setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}

	public Set<Suggestion> getSuggestions() {
		return new HashSet<>(suggestions);
	}

	protected Set<Suggestion> _getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(Set<Suggestion> suggestions) {
		this.suggestions = suggestions;
	}

	public Set<Comment> getcomments() {
		return new HashSet<>(comments);
	}

	protected Set<Comment> _getcomments(){
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	protected void _addSuggestion(Suggestion suggestion){
		suggestions.add(suggestion);
	}

	protected void _deleteSuggestion(Suggestion suggestion){
		suggestions.remove(suggestion);
	}

	protected void _addComment(Comment comment) {
		comments.add(comment);
	}

	protected void _deleteComment(Comment comment) {
		comments.remove(comment);
	}



}