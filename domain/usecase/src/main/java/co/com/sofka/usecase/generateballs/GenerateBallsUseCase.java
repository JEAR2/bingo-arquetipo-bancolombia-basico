package co.com.sofka.usecase.generateballs;

import co.com.sofka.model.ball.Ball;
import co.com.sofka.model.game.Game;
import co.com.sofka.model.game.gateways.GameRepository;
import co.com.sofka.usecase.createball.CreateBallUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

@RequiredArgsConstructor
public class GenerateBallsUseCase implements Function<Game, Mono<Game>> {
    private final CreateBallUseCase createBallUseCase;
    private final GameRepository gameRepository;

    @Override
    public Mono<Game> apply(Game game) {
        var f = creteBalls();
        Set<Ball> ballSet = new HashSet<>();
        return  f.collectList().flatMap(balls -> {
            ballSet.addAll(balls);
            game.setBalls(ballSet);
            return gameRepository.save(game);
        });

    }

    private Flux<Ball> creteBalls(){
        return Flux.range(1,5)
                .map(index->new Ball(""+index,""+index,false));
    }
}
