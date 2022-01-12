package ayrotek.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Document("Log")
public class Log {
    @Id
    private String id;
    private String log;
}
