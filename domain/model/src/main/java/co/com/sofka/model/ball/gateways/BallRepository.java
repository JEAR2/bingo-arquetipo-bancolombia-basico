package co.com.sofka.model.ball.gateways;

import co.com.sofka.model.ball.Ball;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BallRepository {
    Mono<Ball> save(Ball ball);
    Flux<Ball> findAll();
    Mono<Ball> findById(String id);
    Mono<Void> deleteById(String id);
}
