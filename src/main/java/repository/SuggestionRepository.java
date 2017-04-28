package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Category;
import model.Suggestion;


@Repository
public interface SuggestionRepository extends JpaRepository<Suggestion, Long>{

	    List<Suggestion> findByCategoria(Category categoria);


	}

