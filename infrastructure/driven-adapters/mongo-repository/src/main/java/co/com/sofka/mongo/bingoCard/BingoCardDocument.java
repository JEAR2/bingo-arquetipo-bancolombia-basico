package co.com.sofka.mongo.bingoCard;

import co.com.sofka.model.ball.Ball;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document(value = "game")
@Data
public class BingoCardDocument {
    @Id
    private String id;
    private Set<Ball> B;
    private Set<Ball> I;
    private Set<Ball> N;
    private Set<Ball> G;
    private Set<Ball> O;
}
