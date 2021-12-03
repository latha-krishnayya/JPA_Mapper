package se.lexicon.sneha.jpa.model;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Book {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    private String isbn;
    private String title;
    private int maxLoanDays;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_authors_id")
    private Set<Author> authors;

    public Book() {
    }

    public Book(String isbn, String title, int maxLoanDays, Set<Author> authors) {
        this.isbn = isbn;
        this.title = title;
        this.maxLoanDays = maxLoanDays;
        this.authors = authors;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMaxLoanDays() {
        return maxLoanDays;
    }

    public void setMaxLoanDays(int maxLoanDays) {
        this.maxLoanDays = maxLoanDays;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookId == book.bookId && maxLoanDays == book.maxLoanDays && Objects.equals(isbn, book.isbn) && Objects.equals(title, book.title) && Objects.equals(authors, book.authors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, isbn, title, maxLoanDays, authors);
    }
}
