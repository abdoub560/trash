package dz.trash.DAO;

import dz.trash.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRep extends JpaRepository<Photo,Integer> {
}
