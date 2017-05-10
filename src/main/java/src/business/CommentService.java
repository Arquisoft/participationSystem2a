package src.business;

import java.util.List;

import src.model.Comment;
import src.model.Suggestion;
import src.model.exception.BusinessException;

public interface CommentService {
	
	List<Comment> findBySugerenciaOrderByFechaDesc(Suggestion sugerencia);
	List<Comment> findBySugerenciaOrderByFechaAsc(Suggestion sugerencia);
	
	   void createComment(Comment comment) throws BusinessException;

		Comment addComment(Comment comment);
		
		List<Comment> getCommentsByDate(Long id);
		
		List<Comment> getCommentsByPopularity(Long id); 
}
