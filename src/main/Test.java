public class Test  {

    public static void main(String[] args) {
        Card c = new Card(Suit.DIAMONDS, CardValues.TEN);
        System.out.println(c.getCardValue().toString());

    }

}
