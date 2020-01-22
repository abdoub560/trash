package dz.trash.DAO;

import dz.trash.model.Address;
import dz.trash.model.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface ChallengeRep extends JpaRepository<Challenge,Integer> {

}
