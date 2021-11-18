import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Test {

    public static void main(String[] args) {
        var game =
                new Game(List.of(new Player("Prince"),
                        new Player("Priscilla"),
                        new Player("Philip"),
                        new Player("Richard"),
                        new Player("Seth")
                ));

//        System.out.println("Before Shuffling");
//        game.printCards();

//        System.out.println("\nAfter Shuffling");
        game.shuffleCards();
        game.printCards();

        game.start();
        game.printCards();

        System.out.println(game.getPlayers().get(0).getTotalValueOfCards());
        System.out.println(game.getPlayers().get(1).getTotalValueOfCards());
        System.out.println(game.getPlayers().get(2).getTotalValueOfCards());

    }

}
