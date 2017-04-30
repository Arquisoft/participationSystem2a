package business;

import java.util.List;

import model.Citizen;
import model.Comment;
import model.Suggestion;
import model.exception.BusinessException;

public interface CommentService {

    void createComment(Comment comment) throws BusinessException;

	List<Comment> findBySuggestionOrderByDescDate(Suggestion suggestion);

	List<Comment> findBySuggestionOrderByAscDate(Suggestion suggestion);

	Comment addComment(Comment comment);
	
	List<Comment> getCommentsByDate(Long id);
	
	List<Comment> getCommentsByPopularity(Long id); 
}
