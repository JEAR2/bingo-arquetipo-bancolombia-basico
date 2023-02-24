package co.com.sofka.api.game;

import co.com.sofka.model.game.Game;
import co.com.sofka.usecase.creategame.CreateGameUseCase;
import co.com.sofka.usecase.generateballs.GenerateBallsUseCase;
import co.com.sofka.usecase.generatebingocards.GenerateBingoCardsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CreateGameHandler {
private  final CreateGameUseCase createGameUseCase;
private final GenerateBallsUseCase generateBallsUseCase;

private final GenerateBingoCardsUseCase generateBingoCardsUseCase;

    public Mono<ServerResponse> CreateGame(ServerRequest serverRequest) {
        return serverRequest
                .bodyToMono(Game.class)
                .flatMap(createGameUseCase::apply)
                .flatMap(generateBallsUseCase::apply)
                .flatMap(generateBingoCardsUseCase::apply)
                .flatMap(game -> ServerResponse.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).bodyValue(game));
    }

}
