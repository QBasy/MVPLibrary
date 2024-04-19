package just.little.test.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.UUID;

@JmixEntity
@Table(name = "BOOK_HISTORY")
@Entity
public class BookHistory {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @NotNull
    @Column(name = "book_id", nullable = false)
    private UUID bookID;

    @NotNull
    @Column(name = "USERS", nullable = false)
    private String users;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Size(max = 15)
    @NotNull
    @Column(name = "action", nullable = false, length = 15)
    private String action;

    @NotNull
    @Column(name = "date", nullable = false)
    private LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsers() {
        return users;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getBookID() {
        return bookID;
    }

    public void setBookID(UUID bookID) {
        this.bookID = bookID;
    }
}