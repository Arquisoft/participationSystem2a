package business;

import model.Citizen;
import model.Comment;
import model.Suggestion;
import model.exception.BusinessException;

public interface CommentService {

    void createComentario(Comment comment) throws BusinessException;

    void createComentario(String comment, Suggestion suggestion, Citizen citizen);
}
