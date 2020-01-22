package dz.trash.DAO;

import dz.trash.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRep extends JpaRepository<Note,Integer> {
}
