package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Categoria;


@Repository
public interface CategoryRepository extends JpaRepository<Categoria, Long> {

}
