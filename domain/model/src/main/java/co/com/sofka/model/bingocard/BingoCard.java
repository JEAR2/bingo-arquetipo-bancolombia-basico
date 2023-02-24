package co.com.sofka.model.bingocard;
import co.com.sofka.model.ball.Ball;
import co.com.sofka.model.ball.BallCard;
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
public class BingoCard {
    private String id;
    private List<BallCard> list;

}
