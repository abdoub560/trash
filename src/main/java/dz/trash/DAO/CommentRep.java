package dz.trash.DAO;

import dz.trash.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRep extends JpaRepository<Comment,Integer> {
}
