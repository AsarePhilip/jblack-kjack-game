import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    private List<Card> deckOfCards;
    private List<Player> players;

    public Game(List<Player> players) {
        deckOfCards = new ArrayList<>();
        this.players = players;
        arrangeCards();
    }



    private void arrangeCards() {
        for (int i = 0; i < Suit.values().length; i++) {
            for (int j = 0; j < CardValues.values().length; j++) {
                deckOfCards.add(new Card(Suit.values()[i], CardValues.values()[j]));
            }
        }
    }

    public void printCards() {
        for (var card : deckOfCards) {
            System.out.println(card);
        }
    }
}
