package todo.app.app.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="content")
public class Content extends BaseEntity{

    @Id
    private String id;
    private String nickname;
    private String content;
}
