package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Categoria;
import model.Sugerencia;


@Repository
public interface SuggestionRepository extends JpaRepository<Sugerencia, Long>{

	    List<Sugerencia> findByCategoria(Categoria categoria);


	}
