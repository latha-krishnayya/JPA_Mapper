package se.lexicon.sneha.jpa.data;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.sneha.jpa.model.Book;

import javax.persistence.EntityManager;
import java.util.Collection;
@Repository
public class bookDAOImpl implements bookDAO{

    public final EntityManager entityManager;

    public bookDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Book create(Book book) {
        entityManager.persist(book);
        return book;
    }

    @Override
    public Book findById(int id) {
        if(id <= 0) throw new IllegalArgumentException("Id wasn't proper");
        return entityManager.find(Book.class, id);
    }

    @Override
    public Collection<Book> findAll() {
        return entityManager.createQuery("SELECT b FROM Book b", Book.class).getResultList();
    }







    @Override
    public Book update(Book book) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
