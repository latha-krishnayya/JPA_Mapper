package se.lexicon.sneha.jpa.data;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.sneha.jpa.model.BookLoan;

import javax.persistence.EntityManager;
import java.util.Collection;

@Repository
public class bookLoanDAOImpl implements bookLoanDAO{

    public final EntityManager entityManager;

    public bookLoanDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public BookLoan create(BookLoan bookLoan) {
        entityManager.persist(bookLoan);
        return bookLoan;
    }

    @Override
    public BookLoan findById(int id) {
        return entityManager.find(BookLoan.class, id);
    }

    @Override
    public Collection<BookLoan> findAll() {
        return entityManager
                .createQuery("SELECT bl FROM BookLoan bl",BookLoan.class)
                .getResultList();
    }

    @Override
    public BookLoan update(BookLoan bookLoan) {
        return entityManager.merge(bookLoan);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(findById(id));

    }
}
