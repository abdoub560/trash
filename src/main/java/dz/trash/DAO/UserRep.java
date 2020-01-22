package dz.trash.DAO;

import dz.trash.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRep extends JpaRepository<User,Integer> {
}
