package src.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import src.model.Comment;
import src.model.Suggestion;;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{
	
	List<Comment> findBySugerenciaOrderByFechaDesc(Suggestion sugerencia);
	List<Comment> findBySugerenciaOrderByFechaAsc(Suggestion sugerencia);

}
