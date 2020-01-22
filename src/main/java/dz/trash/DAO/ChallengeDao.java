package dz.trash.DAO;

import dz.trash.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ChallengeDao extends DAO<Challenge> {
    @Autowired
    ChallengeRep challengeRep;

    @Autowired
    ClientRep clientRep;


    @Override
    public int create(Challenge obj) {
        return 0;
    }

    @Override
    public boolean delete(Challenge obj) {
        return false;
    }

    @Override
    public boolean update(Challenge obj) {
        return false;
    }

    @Override
    public Challenge find(int id) {
        return null;
    }
    @Transactional(propagation= Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)

    @Override
    public List<Challenge> findAll() {
        List<Challenge>challenges=new ArrayList<>();
        List<Challenge>dupChallenges=new ArrayList<>();

        challenges=challengeRep.findAll();
        challenges.forEach(challenge -> {
            Challenge dupChallenge=new Challenge();
            dupChallenge.setOwner(challenge.getOwner());
            dupChallenge.setAddress(challenge.getAddress());
            dupChallenge.setPhotos(challenge.getPhotos());
            dupChallenge.setNotes(challenge.getNotes());

            Set<Note>notes=dupChallenge.getNotes();
        notes.forEach(note -> {
            note.setClient(null);

        });

            dupChallenge.getOwner().setOwnedChallenges(null);
            dupChallenge.getOwner().setPass(null);
            dupChallenge.getOwner().setNotes(null);
            dupChallenge.getOwner().setComments(null);
            dupChallenges.add(dupChallenge);
        });
        return dupChallenges;
    }
}
