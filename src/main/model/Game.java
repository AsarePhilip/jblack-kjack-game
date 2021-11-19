package model;

import enums.CardValues;
import enums.PlayerStatus;
import enums.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Game {
    private final List<Card> deckOfCards;
    private final List<Player> players;
    private boolean isGameOver = false;
//    private final int targetScore = 17;

    public Game(List<Player> players) {
        deckOfCards = new ArrayList<>();
        this.players = players;
        arrangeCards();
    }


    public List<Player> getPlayers() {
        return players;
    }

    public List<Card> getDeckOfCards() {
        return deckOfCards;
    }

    public void start() {
        // handing two cards to each player
        System.out.println("Starting game");
        shuffleCards();
        for (var player : players) {
            player.setPlayerStatus(PlayerStatus.HIT);

            final int initNumOfCards = 2;
            for (int i = 0; i < initNumOfCards; i++) {
                deal(player);
            }
        }//1st deal

        while (!isGameOver) {
            changeGameStatus();
            for (var player : players) {
                deal(player);
            }//1st deal


        }

        System.out.println("Cards left: " + deckOfCards.size());
        getAllCurrentPlayers(players);
    }

    private void arrangeCards() {
        for (int i = 0; i < Suit.values().length; i++) {
            for (int j = 0; j < CardValues.values().length; j++) {
                deckOfCards.add(new Card(Suit.values()[i], CardValues.values()[j]));
            }
        }
    }

    private void shuffleCards() {
        Collections.shuffle(deckOfCards);
    }

    public void deal(Player player) {
        if (player.canDeal() && !isGameOver) {
            var currentCard = deckOfCards.get(deckOfCards.size() - 1);
            player.addCard(currentCard);
            deckOfCards.remove(currentCard);
        }
        player.changePlayerStatus();
    }

    public void printCards() {
        System.out.println(deckOfCards.size());
        for (var card : deckOfCards) {
            System.out.println(card);
        }
    }

    public void getAllCurrentPlayers(List<Player> players) {
//        players.stream().filter(p -> p.)
        players.forEach(System.out::println);

    }

    public void changeGameStatus() {
        if (players.stream().allMatch(p -> p.getPlayerStatus().equals(PlayerStatus.STICK))) {
            System.out.println("Running 1");
            isGameOver = true;
        } else if (players.stream().anyMatch(p -> p.getPlayerStatus().equals(PlayerStatus.WIN))) {
            System.out.println("Running 2");
            isGameOver = true;
        } else if (players.stream().filter(p -> !(p.getPlayerStatus().equals(PlayerStatus.GO_BUST))).count() == 1) {
            System.out.println("running 3");
            isGameOver = true;
        } else {
            List<Player> clonedPlayers = new ArrayList<>(players);
            clonedPlayers = clonedPlayers.stream().filter(p -> !p.getPlayerStatus().equals(PlayerStatus.GO_BUST)).collect(Collectors.toList());

            isGameOver = true;
//        }

//        System.out.println(players.stream());
        }
    }

        public Optional<Player> getWinner () {
            if (isGameOver) {
                return players.stream().filter(p -> p.getPlayerStatus().equals(PlayerStatus.WIN)).findFirst();
            }
            return Optional.empty();
        }

//
//        final var playersWhoWonTheFirstRound = players.stream().filter(p -> p.getPlayerStatus().equals(PlayerStatus.WIN));
//
//        while (!isGameOver) {
//
//            if (playersWhoWonTheFirstRound.findAny().isPresent()) {
//                isGameOver = true;
//                return playersWhoWonTheFirstRound.findFirst().get();
//            }
//
//            var clonedPlayers = players;
//
//        }
//
//    }
//            return null;

}
