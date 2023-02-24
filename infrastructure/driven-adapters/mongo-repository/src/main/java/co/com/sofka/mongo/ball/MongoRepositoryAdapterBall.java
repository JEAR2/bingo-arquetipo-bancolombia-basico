package co.com.sofka.mongo.ball;

import co.com.sofka.model.ball.Ball;
import co.com.sofka.model.ball.gateways.BallRepository;
import co.com.sofka.model.game.Game;
import co.com.sofka.model.game.gateways.GameRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MongoRepositoryAdapterBall extends AdapterOperations<Ball, BallDocument, String, MongoDBRepositoryBall>
 implements BallRepository
{

    public MongoRepositoryAdapterBall(MongoDBRepositoryBall repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Ball.class));
    }
}
