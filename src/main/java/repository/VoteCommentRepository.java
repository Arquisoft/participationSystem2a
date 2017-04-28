package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.VoteComment;
import model.VoteCommentKey;

public interface VoteCommentRepository extends JpaRepository<VoteComment, VoteCommentKey> {

}
