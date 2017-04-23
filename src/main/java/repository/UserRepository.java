package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	@Query("SELECT p FROM Participant p WHERE p.user = :user and p.password = :password")
	User findByUserAndPassword(@Param("user") String user, @Param("password") String password);

}
