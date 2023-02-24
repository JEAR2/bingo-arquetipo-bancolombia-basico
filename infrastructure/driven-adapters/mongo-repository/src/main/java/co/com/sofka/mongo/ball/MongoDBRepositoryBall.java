package co.com.sofka.mongo.ball;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface MongoDBRepositoryBall extends ReactiveMongoRepository<BallDocument, String>, ReactiveQueryByExampleExecutor<BallDocument> {
}
