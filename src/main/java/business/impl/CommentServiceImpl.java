package business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import business.CommentService;
import model.Categoria;
import model.Citizen;
import model.Comentario;
import model.Sugerencia;
import model.exception.BusinessException;
import repository.CitizenRepository;
import repository.CommentRepository;

public class CommentServiceImpl implements CommentService {
	
	private CommentRepository commentRepository;

	@Autowired
	public void setCommentRepository(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}

	@Override
	public void createComentario(Comentario comment) throws BusinessException {
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
	public void createComentario(String texto, Sugerencia suggestion, Citizen citizen) {
		
		Comentario c = new Comentario(texto,suggestion,citizen);
		suggestion.addComentario(c);
		commentRepository.save(c);
	}

}
