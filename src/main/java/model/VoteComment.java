package model;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class VoteComment implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	private Comment comment;
	
	@Id
	@ManyToOne
	private User user;
	
	private boolean votePlus;
	
	VoteComment() {}

	public VoteComment(Comment comment, User user, boolean votePlus) {		
		this.comment = comment;
		this.user = user;
		this.votePlus = votePlus;
	}

	public Comment getComment() {
		return comment;
	}

	protected void _setComment(Comment comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	protected void _setUser(User user) {
		this.user = user;
	}

	public boolean isvotePlus() {
		return votePlus;
	}

	public void setvotePlus(boolean voto) {
		this.votePlus = voto;
	}

}
