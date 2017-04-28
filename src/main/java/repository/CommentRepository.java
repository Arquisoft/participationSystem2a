package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Comment;
import model.Suggestion;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

	List<Comment> findBySuggestionOrderByDescDate(Suggestion suggestion);

	List<Comment> findBySuggestionOrderByAscDate(Suggestion suggestion);

}
