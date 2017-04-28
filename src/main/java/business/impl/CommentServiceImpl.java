package business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import business.CommentService;
import model.Citizen;
import model.Comment;
import model.Suggestion;
import model.exception.BusinessException;
import repository.CommentRepository;

public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	public void setCommentRepository(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}

	@Override
	public void createComment(Comment comment) throws BusinessException {
		try {
			this.commentRepository.save(comment);
		/* LOG
			LOG.send(Topics.COMMENT_SUGGESTION,
					comment.getsuggestion().getId() + comment.getTexto());
					*/
		} catch (Exception e) {
			throw new BusinessException("Error al crear un comentario.");
		}

	}
	

	@Override
	public List<Comment> findBySuggestionOrderByDescDate(Suggestion suggestion) {
		return commentRepository.findBySuggestionOrderByDescDate(suggestion);
	}

	@Override
	public List<Comment> findBySuggestionOrderByAscDate(Suggestion suggestion) {
		return commentRepository.findBySuggestionOrderByAscDate(suggestion);
	}

	

}
