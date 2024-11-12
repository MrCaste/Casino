import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Deck {

    private List<Card> deck;

    class Card{
        final Number NUMBER;
        final Stick STICK;

        public Card(Number NUMBER, Stick STICK) {
            this.NUMBER = NUMBER;
            this.STICK = STICK;
        }

        @Override
        public String toString() {
            return NUMBER.index+STICK.index;
        }

        public int getValor(String valor){
            switch(valor){
                case "A":
                    return 11;
                case "J","Q","K":
                    return 10;
                default:
                    return Integer.parseInt(valor);
            }
        }
    }

    public Deck(Card carta) {
        deck = new LinkedList<>();
    }

    public List<Card> createDeck(){
        for (Stick STICK : Stick.values()) {
            for (Number NUMBER : Number.values()) {
                deck.add(new Card(NUMBER, STICK));
            }
        }
        return deck;
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }

    public Card stealCard(){
        return deck.remove(0);
    }

    @Override
    public String toString() {
        return "Deck [" + deck + "]";
    }
}
