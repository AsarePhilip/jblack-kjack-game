package model;

import enums.CardValues;
import enums.Suit;

public class Card {
    private Suit suit;
    private CardValues cardValue;

    public Card(Suit suit, CardValues cardValue) {
        this.suit = suit;
        this.cardValue = cardValue;
    }

    public Suit getSuit() {
        return suit;
    }

    public CardValues getCardValue() {
        return cardValue;
    }

    @Override
    public String toString() {
        return "model.Card{" +
                "suit=" + suit +
                ", cardValue=" + cardValue +
                '}';
    }
}
