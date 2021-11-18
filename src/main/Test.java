import java.util.List;

public class Test  {

    public static void main(String[] args) {
        Card c = new Card(Suit.DIAMONDS, CardValues.TEN);
        System.out.println();

        var game = new Game(List.of(new Player("Philip")));
        game.printCards();
    }

}
