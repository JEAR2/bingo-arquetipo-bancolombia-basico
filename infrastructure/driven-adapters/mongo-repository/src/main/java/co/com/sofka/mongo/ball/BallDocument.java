package co.com.sofka.mongo.ball;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "game")
@Data
public class BallDocument {
    @Id
    private String id;
    private String value;
    private Boolean status;
}
