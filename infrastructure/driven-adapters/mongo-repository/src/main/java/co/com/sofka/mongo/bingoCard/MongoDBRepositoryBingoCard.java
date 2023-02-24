package co.com.sofka.mongo.bingoCard;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface MongoDBRepositoryBingoCard extends ReactiveMongoRepository<BingoCardDocument, String>, ReactiveQueryByExampleExecutor<BingoCardDocument> {
}
