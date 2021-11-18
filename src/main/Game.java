import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
    private final List<Card> deckOfCards;

    public List<Player> getPlayers() {
        return players;
    }

    private final List<Player> players;
    private final int cardsCount;

    public Game(List<Player> players) {
        deckOfCards = new ArrayList<>();
        this.players = players;
        cardsCount = 2;
        arrangeCards();
    }


    public List<Card> getDeckOfCards(){
        return  deckOfCards;
    }

    public void start() {
        // handing two cards to each player
        System.out.println("Starting game");

        for (var player : players) {
            for (int i = 0; i < cardsCount; i++) {
               deal(player);
            }
        }
    }

    private void arrangeCards() {
        for (int i = 0; i < Suit.values().length; i++) {
            for (int j = 0; j < CardValues.values().length; j++) {
                deckOfCards.add(new Card(Suit.values()[i], CardValues.values()[j]));
            }
        }
    }

    public void shuffleCards() {
        Collections.shuffle(deckOfCards);
    }

    public void deal(Player player) {
        var currentCard = deckOfCards.get(deckOfCards.size() - 1);
        player.addCard(currentCard);
        deckOfCards.remove(currentCard);
    }

    public void printCards() {
        System.out.println(deckOfCards.size());
        for (var card : deckOfCards) {
            System.out.println(card);
        }
    }


}
