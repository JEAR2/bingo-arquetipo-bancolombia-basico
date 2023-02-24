package co.com.sofka.model.game;
import co.com.sofka.model.ball.Ball;
import co.com.sofka.model.bingocard.BingoCard;
import co.com.sofka.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Game {
    private String id;
    private Integer round;
    private String idWinner;
    private Set<User> users;
    private Set<Ball> balls;
    private List<BingoCard> bingoCards;
}
