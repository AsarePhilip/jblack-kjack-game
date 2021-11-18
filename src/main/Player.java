import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<Card> cardsInHand;
    private  final String playerName;


    public Player(String playerName) {
        cardsInHand = new ArrayList<>();
        this.playerName = playerName;
    }

    public List<Card> getCardsInHand() {
        return cardsInHand;
    }

    public void addCard(Card card){
        cardsInHand.add(card);
    }

    public String getPlayerName() {
        return playerName;
    }

    public  void hit(){
        System.out.println("Hitting");
    }

    public  void stick(){
        System.out.println("Sticking");
    }

    public boolean isBusted(){
        return  false;
    }

    public boolean isWinner(){
        return  false;
    }

    public int getTotalValueOfCards() {
        return cardsInHand.stream().mapToInt(m -> m.getCardValue().getValue()).sum();
    }


}
