package se.lexicon.sneha.jpa.data;

import se.lexicon.sneha.jpa.model.BookLoan;

import java.util.Collection;

public interface bookLoanDAO {
    BookLoan create(BookLoan bookLoan);
    BookLoan findById(int id);
    Collection<BookLoan> findAll();
    BookLoan update(BookLoan bookLoan);
    void  delete(int id);
}
