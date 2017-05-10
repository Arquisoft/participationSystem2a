package src.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import src.model.Citizen;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long> {

}
