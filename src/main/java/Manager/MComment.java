package Manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import business.CommentService;
import model.Comment;

public class MComment implements ManageComment {
	
	@Autowired
	private CommentService commentService;

	@Override
	public void addComment(Comment comentario) {
		commentService.addComment(comentario);
	}

	@Override
	public List<Comment> getCommentsByDate(Long id) {
		return commentService.getCommentsByDate(id);
	}

	@Override
	public List<Comment> getCommentsByPopularity(Long id) {
		return commentService.getCommentsByPopularity(id);
	}

}
