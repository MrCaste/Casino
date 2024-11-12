import java.util.ArrayList;
import java.util.List;

public class Player {

    private Deck deck;
    private String alias;
    private int chips;
    private List<Deck.Card> hand = new ArrayList<>();
    private final int MINIMUM_BET = 5;


    public Player(String alias, int chips) {
        this.alias = alias;
        this.chips = chips;
    }

    public Player(String alias) {
        this.alias = alias;
    }

    public void bet(int bet) throws Exception{
        if(this.chips < bet){
            throw new Exception("The bet exceeds your amount");
        }
        if(this.chips > bet){
            this.chips -= bet;
        }
        if(bet < MINIMUM_BET){
            throw new Exception("The minimum bet is: "+MINIMUM_BET);
        }
    }

    public List<Deck.Card> addCardToHand(){
        hand.add(deck.stealCard());
        return hand;
    }

    @Override
    public String toString() {
        return alias + "[" + hand + "]" + chips +" chips";
    }

    

}
