package just.little.test.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Table(name = "BOOK")
@JmixEntity
@Entity
public class Book {

    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @NotNull
    @InstanceName
    @Column(name = "TITLE")
    private String title;

    @NotNull
    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "avaliable")
    private Boolean avaliable;

    @Size(max = 17)
    @Column(name = "isbn", length = 17)
    private String isbn;

    @OneToMany(mappedBy = "user")
    private Set<UserBooks> userBooks = new LinkedHashSet<>();

    @Size(max = 15)
    @NotNull
    @Column(name = "genre", nullable = false, length = 15)
    private String genre;

    @NotNull
    @Column(name = "publication_date", nullable = false)
    private LocalDate publicationDate;

    @OneToMany(mappedBy = "book")
    private Set<BookHistory> bookHistories = new LinkedHashSet<>();

    public Set<BookHistory> getBookHistories() {
        return bookHistories;
    }

    public void setBookHistories(Set<BookHistory> bookHistories) {
        this.bookHistories = bookHistories;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Set<UserBooks> getUserBooks() {
        return userBooks;
    }

    public void setUserBooks(Set<UserBooks> userBooks) {
        this.userBooks = userBooks;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Boolean getAvaliable() {
        return avaliable;
    }

    public void setAvaliable(Boolean avaliable) {
        this.avaliable = avaliable;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}