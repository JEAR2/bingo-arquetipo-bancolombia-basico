package co.com.sofka.usecase.generatebingocards;

import co.com.sofka.model.ball.Ball;
import co.com.sofka.model.ball.BallCard;
import co.com.sofka.model.bingocard.BingoCard;
import co.com.sofka.model.game.Game;
import co.com.sofka.model.game.gateways.GameRepository;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Subscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class GenerateBingoCardsUseCase implements Function<Game, Mono<Game>> {
    private final GameRepository gameRepository;
    @Override
    public Mono<Game> apply(Game game) {

//        create(null,1,5);
        System.out.println("dasdasdasdsadsadasdsad");
//        Flux.range(1,5).publishOn(Schedulers.boundedElastic()).map(index->{
//            BingoCard bingoCard = new BingoCard();
//            bingoCard.setId(""+index);
            AtomicInteger cont = new AtomicInteger(1);
//            if(index.equals(1)){
//                Flux.range(1,5).map(i->{
//                    BingoCard bingoCard1 = new BingoCard(""+i,new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
//                    var x = Objects.requireNonNull(generateValues(i + (cont.get() - i), 15));
//                    cont.set(cont.get()+15);
//                    return game;
//                }).subscribe();
//            }

               // BingoCard bingoCard1 = new BingoCard("",new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
//                return Flux.range(1,5)
//                        .flatMap(i->generateValues(i + (cont.get() - i), 15))
//                        .flatMap(c->Flux.fromIterable(c).map(x->{
//                            bingoCard1.getB().add(x);
//                            cont.set(cont.get()+15);
//                            return bingoCard1;
//                        })).collectList().flatMap(data->{
//                            game.getBingoCards().add(bingoCard1);
//                            System.out.println("dasdasdasd "+game.getBingoCards());
//                            return gameRepository.save(game);
//                        });
        generateValues(1,15).subscribe(System.out::println);
            return null;


    }

    private Flux<List<BallCard>> generateValues(int min,int max){

        System.out.println("----------------- "+min+" vvvv "+max);
        List<BallCard> ballCards = new ArrayList<>();
        List<BallCard> ballCards2 = new ArrayList<>();
        Random random = new Random();
      return  ballCardFlux(1,15).flatMap(ballCards1 -> Flux.range(1,5).map(index->{
          System.out.println("aaaaaaaaaaaaaaa "+ballCards1.size());
            int x = random.nextInt(1, ballCards1.size());
          System.out.println(x);
          //int x= (int) (Math.random()*max)+1+max*min;
            ballCards2.add(ballCards1.get(x));
             ballCards1.remove(ballCards1.get(x));
            return ballCards2;
        }));

//        var f= balls.collectList().map(ballCards1 -> {
//            ballCards.addAll(ballCards1);
//            return ballCards;
//        }).flatMap(ballCardsC -> {
//            Flux.range(1,5).map(index->{
//                int x = random.nextInt(1, ballCardsC.size());
//                    ballCards2.add(ballCardsC.get(x));
//                    ballCardsC.remove(ballCardsC.get(x));
//                    return ballCards2;
//            }).collectList();
//        });
//        Flux.range(1,5).flatMap(index->{
//            int x = random.nextInt(1, ballCards.size());
//            var s=f.map(ballCards1 -> {
//                ballCards2.add(ballCards1.get(x));
//                ballCards.remove(ballCards1.get(x));
//                return ballCards2;
//            });
//            return s;
//        });
//        return null;
//
//        Flux.range(min, max).map(index->{
//            System.out.println("index "+index);
//            ballCards.add(new BallCard(""+index,false));
//            return ballCards;
//        }).subscribe();
//        Flux.range(1,5).map(index->{
//            int x = random.nextInt(1, ballCards.size());
//            ballCards2.add(ballCards.get(x));
//            ballCards.remove(ballCards.get(x));
//            return ballCards2;
//        }).subscribe(System.out::println);
//        return null;

//
//        System.out.println("-----------------");
//        List<BallCard> ballCards = new ArrayList<>();
//        List<BallCard> ballCards2 = new ArrayList<>();
//        Random random = new Random();
//        var f= Flux.range(min, max).map(index->{
//            // System.out.println("index "+index);
//            //ballCards.add(new BallCard(""+index,false));
////            return ballCards;
//            return new BallCard(""+index,false);
//        });
//        ballCards = f.collectList().map(ballCards1 -> {
//            return ballCards1.;
//        });
//        Flux.range(1,5).map(index->{
//            int x = random.nextInt(1, ballCards.size());
//            ballCards2.add(ballCards.get(x));
//            ballCards.remove(ballCards.get(x));
//            return ballCards2;
//        }).subscribe(System.out::println);
//        return null;
    }

    private Flux<List<BallCard>> ballCardFlux(int min,int max){
        List<BallCard> ballCards = new ArrayList<>();
        return Flux.range(1, 12).map(index->{
           System.out.println("index "+index);
           ballCards.add(new BallCard(""+index,false));
            System.out.println("----------> "+ballCards.size());
           return ballCards;
       });
    }
}
