package just.little.test.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@JmixEntity
@Table(name = "user_book")
@Entity
public class UserBooks {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "USER_ID")
    private UUID userID;

    @NotNull
    @Column(name = "BOOK_ID")
    private UUID bookID;

    @NotNull
    @Column()

    public UUID getBookID() {
        return bookID;
    }

    public UUID getUserID() {
        return userID;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}