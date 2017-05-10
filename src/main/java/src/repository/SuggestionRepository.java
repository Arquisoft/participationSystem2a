package src.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import src.model.*;

@Repository
public interface SuggestionRepository extends JpaRepository<Suggestion, Long>{	

}