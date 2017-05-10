package src.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import src.model.VoteComment;
import src.model.VoteCommentKey;

@Repository
public interface VoteCommentRepository extends JpaRepository<VoteComment, VoteCommentKey> {

}
