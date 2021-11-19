package model;

import enums.CardValues;
import enums.PlayerStatus;
import enums.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private final List<Card> deckOfCards;
    private final List<Player> players;
    private final int initNumOfCards = 2;
//    private final int targetScore = 17;

    public Game(List<Player> players) {
        deckOfCards = new ArrayList<>();
        this.players = players;
        arrangeCards();
    }


    public List<Player> getPlayers() {
        return players;
    }
    public List<Card> getDeckOfCards(){
        return  deckOfCards;
    }

    public void start() {
        // handing two cards to each player
        System.out.println("Starting game");

        for (var player : players) {
            player.setPlayerStatus(PlayerStatus.HIT);

            for (int i = 0; i < initNumOfCards; i++) {
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
        if (player.canDeal()) {
            var currentCard = deckOfCards.get(deckOfCards.size() - 1);
            player.addCard(currentCard);
            deckOfCards.remove(currentCard);
        }
    }

    public void printCards() {
        System.out.println(deckOfCards.size());
        for (var card : deckOfCards) {
            System.out.println(card);
        }
    }


    public boolean gameStatus(){
        if( players.stream().allMatch( p -> p.getPlayerStatus().equals(PlayerStatus.STICK)) ){
            return true;
        }else if(players.stream().anyMatch(p -> p.getPlayerStatus().equals(PlayerStatus.WIN))){
            return false;
        }else if ( players.stream().filter( p -> p.getPlayerStatus().equals(PlayerStatus.GO_BUST))  ){
            
        }
    }

}
