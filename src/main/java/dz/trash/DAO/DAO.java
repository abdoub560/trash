package dz.trash.DAO;


import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public abstract class DAO<T> {
    @PersistenceContext


        public abstract int create(T obj);
        public abstract boolean delete(T obj);
        public abstract boolean update(T obj);
        public abstract T find(int id);
        public abstract List<T> findAll();
    }

