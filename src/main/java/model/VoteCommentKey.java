package model;

import java.io.Serializable;

public class VoteCommentKey implements Serializable  {

	private static final long serialVersionUID = 1L;


	Long user;
	Long comment;

	public VoteCommentKey() {}

	public VoteCommentKey(Long user, Long comment) {
		this.user = user;
		this.comment = comment;
	}

}
