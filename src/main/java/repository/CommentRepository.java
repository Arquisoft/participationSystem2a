package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Comentario;

@Repository
public interface CommentRepository extends JpaRepository<Comentario, Long> {

}
