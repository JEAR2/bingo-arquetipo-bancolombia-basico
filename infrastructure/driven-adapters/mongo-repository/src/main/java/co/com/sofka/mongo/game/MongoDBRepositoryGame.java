package co.com.sofka.mongo.game;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface MongoDBRepositoryGame extends ReactiveMongoRepository<GameDocument, String>, ReactiveQueryByExampleExecutor<GameDocument> {
}
