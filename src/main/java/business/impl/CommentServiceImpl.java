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
	
	private CommentRepository commentRepository;

	@Autowired
	public void setCommentRepository(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}

	@Override
	public void createComentario(Comment comment) throws BusinessException {
		try {
			this.commentRepository.save(comment);
		/* LOG
			LOG.send(Topics.COMMENT_SUGGESTION,
					comment.getSugerencia().getId() + comment.getTexto());
					*/
		} catch (Exception e) {
			throw new BusinessException("Error al crear un comentario.");
		}

	}
	
	@Override
	public void createComentario(String texto, Suggestion suggestion, Citizen citizen) {
		
		Comment c = new Comment(texto,suggestion,citizen);
		suggestion.addComentario(c);
		commentRepository.save(c);
	}

}
