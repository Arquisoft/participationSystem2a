package src.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.business.CommentService;
import src.model.Comment;
import src.model.Suggestion;
import src.model.exception.BusinessException;
import src.repository.CommentRepository;

@Service
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
	public Comment addComment(Comment comentario) {
		return commentRepository.save(comentario);
	}

	@Override
	public List<Comment> getCommentsByPopularity(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> findBySugerenciaOrderByFechaDesc(Suggestion sugerencia) {
		return commentRepository.findBySugerenciaOrderByFechaDesc(sugerencia);
	}

	@Override
	public List<Comment> findBySugerenciaOrderByFechaAsc(Suggestion sugerencia) {
		return commentRepository.findBySugerenciaOrderByFechaAsc(sugerencia);
	}

	@Override
	public List<Comment> getCommentsByDate(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}