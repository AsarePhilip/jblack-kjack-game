public enum Suit {
    HEARTS(0), DIAMONDS(1), CLUBS(2), SPADES(3);

    private int suitValue;

    private Suit(int suitValue) {
        this.suitValue = suitValue;
    }

    public int getSuitValue() {
        return this.suitValue;
    }
}
