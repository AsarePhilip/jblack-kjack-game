package model;

import enums.PlayerStatus;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Player {
    // Fields
    private final List<Card> cardsInHand;
    private final String playerName;
    private PlayerStatus playerStatus;
    private final int hitScore;
    private final int winnerScore;

    // Constructors
    public Player(String playerName) {
        cardsInHand = new ArrayList<>();
        this.playerName = playerName;
        hitScore =  17;
        winnerScore = 21;
    }

    // Getters
    public List<Card> getCardsInHand() {
        return cardsInHand;
    }

    public PlayerStatus getPlayerStatus() {
        return playerStatus;
    }

    public String getPlayerName() {
        return playerName;
    }

    // Setters
    public void setPlayerStatus(PlayerStatus status) {
        this.playerStatus = status;
    }

    // Methods
    public void addCard(Card card) {
        cardsInHand.add(card);
    }

    public boolean canDeal() {
        changePlayerStatus();
        return playerStatus == PlayerStatus.HIT;
    }

   public void changePlayerStatus() {
        if (getPlayerScore() < hitScore) {
            this.playerStatus = PlayerStatus.HIT;
        } else if (getPlayerScore() >= hitScore && getPlayerScore() < winnerScore) {
            this.playerStatus = PlayerStatus.STICK;
        } else if (getPlayerScore() == winnerScore) {
            this.playerStatus = PlayerStatus.WIN;
        } else {
            this.playerStatus = PlayerStatus.GO_BUST;
        }
    }

    public int getPlayerScore() {
        return cardsInHand.stream().mapToInt(m -> m.getCardValue().getValue()).sum();
    }

    @Override
    public String toString() {

        return "Player{" +
                "cardsInHand=" + cardsInHand +
                ", playerName='" + playerName + '\'' +
                ", playerStatus=" + playerStatus +
                ", hitScore=" + hitScore +
                ", winnerScore=" + winnerScore +
                ", playerScore=" + getPlayerScore() +
                '}';
    }
}
