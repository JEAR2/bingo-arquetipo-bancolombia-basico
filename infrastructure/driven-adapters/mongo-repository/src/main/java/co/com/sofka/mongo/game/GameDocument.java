package co.com.sofka.mongo.game;

import co.com.sofka.model.ball.Ball;
import co.com.sofka.model.bingocard.BingoCard;
import co.com.sofka.model.user.User;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document(value = "game")
@Data
public class GameDocument {
    @Id
    private String id;
    private Integer round;
    private String idWinner;
    private Set<User> users;
    private Set<Ball> balls;
    private Set<BingoCard> bingoCards;
}
