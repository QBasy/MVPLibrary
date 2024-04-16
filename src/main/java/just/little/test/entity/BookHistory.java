package just.little.test.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

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
    @Column(name = "BOOKID", nullable = false)
    private UUID bookID;

    @NotNull
    @Column(name = "USERS", nullable = false)
    private String users;

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