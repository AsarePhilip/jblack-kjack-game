package model;

import enums.PlayerStatus;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Player {
    // Fields
    private final List<Card> cardsInHand;
    private  final String playerName;
    private PlayerStatus playerStatus;
    private final int gameScore;

    // Constructors
    public Player(String playerName) {
        cardsInHand = new ArrayList<>();
        this.playerName = playerName;
        gameScore = 21;
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


    public  void setPlayerStatus(PlayerStatus status){
        this.playerStatus = status;
    }

    // Methods
    public void addCard(Card card){
        cardsInHand.add(card);
    }

//    public  void hit(){
//        System.out.println("Hitting");
//    }
//
//    public  void stick(){
//        System.out.println("Sticking");
//    }
//
//    public boolean isBusted(){
//        return  false;
//    }
//
//    public boolean isWinner(){
//        return  false;
//    }

    public boolean canDeal() {
        return  playerStatus == PlayerStatus.HIT;
    }

    public void changePlayerStatus() {
        if(getPlayerScore() < 17){
            this.playerStatus = PlayerStatus.HIT;
        }else if( getPlayerScore() >= 17 && getPlayerScore() <= 20){
            this.playerStatus = PlayerStatus.STICK;
        }else if( getPlayerScore() == 21 ){
            this.playerStatus = PlayerStatus.WIN;
        }else{
            this.playerStatus = PlayerStatus.GO_BUST;
        }
    }

    public int getPlayerScore() {
        return cardsInHand.stream().mapToInt(m -> m.getCardValue().getValue()).sum();
    }
}
