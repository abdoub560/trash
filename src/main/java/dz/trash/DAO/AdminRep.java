package dz.trash.DAO;

import dz.trash.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRep extends JpaRepository<Admin,Integer> {
}
