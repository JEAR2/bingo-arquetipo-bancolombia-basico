package co.com.sofka.usecase.createball;

import co.com.sofka.model.ball.Ball;
import co.com.sofka.model.ball.gateways.BallRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@RequiredArgsConstructor
public class CreateBallUseCase implements Function<Ball, Mono<Ball>> {

    private final BallRepository ballRepository;

    @Override
    public Mono<Ball> apply(Ball ball) {
        return ballRepository.save(ball);
    }
}
