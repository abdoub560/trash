package dz.trash.DAO;

import dz.trash.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRep extends JpaRepository<Client,Integer> {
}
