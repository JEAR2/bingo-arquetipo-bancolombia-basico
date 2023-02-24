package co.com.sofka.api.game;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class RouterGameRest {
@Bean
public RouterFunction<ServerResponse> routerFunction(CreateGameHandler createGameHandler) {
    return route(POST("/api/game/create").and(contentType(MediaType.APPLICATION_JSON)), createGameHandler::CreateGame);
    }
}
