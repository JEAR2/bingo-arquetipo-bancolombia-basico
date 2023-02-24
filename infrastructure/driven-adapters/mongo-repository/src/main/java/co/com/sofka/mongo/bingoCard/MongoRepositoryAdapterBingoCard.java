package co.com.sofka.mongo.bingoCard;

import co.com.sofka.model.ball.Ball;
import co.com.sofka.model.ball.gateways.BallRepository;
import co.com.sofka.model.bingocard.BingoCard;
import co.com.sofka.model.bingocard.gateways.BingoCardRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MongoRepositoryAdapterBingoCard extends AdapterOperations<BingoCard, BingoCardDocument, String, MongoDBRepositoryBingoCard>
 implements BingoCardRepository
{

    public MongoRepositoryAdapterBingoCard(MongoDBRepositoryBingoCard repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, BingoCard.class));
    }
}
