package se.lexicon.sneha.jpa.data;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.sneha.jpa.model.Details;

import javax.persistence.EntityManager;
import java.util.Collection;

@Repository
public class DetailsDAOImpl implements DetailsDAO {

    public final EntityManager entityManager;

    public DetailsDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Details create(Details details) {
        entityManager.persist(details);
        return details;
    }

    @Override
    public Details findById(int id) {
        if (id <= 0) throw new IllegalArgumentException(" Enter a valid ID");
        return entityManager.find(Details.class, id);
    }

    @Override
    public Collection<Details> findAll() {
        return entityManager
                .createQuery("SELECT users FROM Details users", Details.class)
                .getResultList();
    }

    @Override
    public Details update(Details details) {
        if (details == null) throw new IllegalArgumentException("No details found");
        entityManager.merge(details);
        return details;
    }

    @Override
    public void delete(int id) {
        entityManager.remove(findById(id));
    }

}
