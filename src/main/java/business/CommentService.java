package business;

import model.Citizen;
import model.Comentario;
import model.Sugerencia;
import model.exception.BusinessException;

public interface CommentService {

    void createComentario(Comentario comment) throws BusinessException;

    void createComentario(String comment, Sugerencia suggestion, Citizen citizen);
}
