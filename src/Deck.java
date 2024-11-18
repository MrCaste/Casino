import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Deck {

    private List<Card> deck = new LinkedList<>();

    class Card{
        final Number NUMBER;
        final Stick STICK;

        public Card(Number NUMBER, Stick STICK) {
            this.NUMBER = NUMBER;
            this.STICK = STICK;
        }

        @Override
        public String toString() {
            return "" + NUMBER.index + STICK.index;
        }

        public int getValor(){
            switch(NUMBER.index){
                case "A":
                    return 11;
                case "J","Q","K":
                    return 10;
                default:
                    return Integer.parseInt(NUMBER.index);
            }
        }
    }

    public void createDeck(){
        deck.clear();
        for (Stick stick : Stick.values()) {
            for (Number number : Number.values()) {
                deck.add(new Card(number, stick));
            }
        }
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
