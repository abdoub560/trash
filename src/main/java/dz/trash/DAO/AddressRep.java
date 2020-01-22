package dz.trash.DAO;

import dz.trash.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRep extends JpaRepository<Address, Integer> {
}
