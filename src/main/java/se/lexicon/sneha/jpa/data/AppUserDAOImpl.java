package se.lexicon.sneha.jpa.data;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.sneha.jpa.model.AppUser;

import javax.persistence.EntityManager;
import java.util.Collection;

@Repository()
public class AppUserDAOImpl implements AppUserDAO{

    public final EntityManager entityManager;

    public AppUserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public AppUser create(AppUser appUser) {
        entityManager.persist(appUser);
        return appUser;
    }

    @Override
    public AppUser findByID(int id) {
        if (id <= 0) throw new IllegalArgumentException(" invalid Id");
        return entityManager.find(AppUser.class,id);

    }

    @Override
    public Collection<AppUser> findAll() {
        return entityManager
                .createQuery("SELECT au FROM AppUser au", AppUser.class)
                .getResultList();
    }

    @Override
    public AppUser update(AppUser appUser) {
        if (appUser == null) throw new IllegalArgumentException("No details found");
        entityManager.merge(appUser);
        return appUser;
    }

    @Override
    public void delete(int id) {
        entityManager.remove(findByID(id));
    }
}
