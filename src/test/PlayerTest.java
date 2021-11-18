import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class PlayerTest {
    private Card card1;
    private Card card2;
    private Player philip;

    @BeforeEach
    void setUp() {
        card1 = new Card(Suit.HEARTS, CardValues.TEN);
        card2 = new Card(Suit.DIAMONDS, CardValues.ACE);
        philip = new Player("Philip");
        philip.addCard(card1);
        philip.addCard(card2);
    }


    @Test
    void getCardsInHand() {
        assertEquals(2, philip.getCardsInHand().size());
    }
}