package se.lexicon.sneha.jpa.data;

import se.lexicon.sneha.jpa.model.Book;

import java.util.Collection;

public interface bookDAO {
    Book create(Book book);
    Book findById(int id);
    Collection<Book> findAll();
    Book update(Book book);
    void delete(int id);
}
