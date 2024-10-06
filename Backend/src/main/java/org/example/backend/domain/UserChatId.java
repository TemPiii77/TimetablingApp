package org.example.backend.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class UserChatId implements Serializable {
    private static final long serialVersionUID = 6036829328017811532L;
    @Column(name = "user_id", nullable = false, length = 6)
    private String userId;

    @ColumnDefault("nextval('user_chat_chat_id_seq')")
    @Column(name = "chat_id", nullable = false)
    private Integer chatId;

    public UserChatId() {
    }

    public UserChatId(String userId, Integer chatId) {
        this.userId = userId;
        this.chatId = chatId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserChatId entity = (UserChatId) o;
        return Objects.equals(this.chatId, entity.chatId) &&
                Objects.equals(this.userId, entity.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chatId, userId);
    }

}