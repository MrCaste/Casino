import java.util.ArrayList;
import java.util.List;

public class Player {

    private Deck deck;
    private String alias;
    private int chips;
    private int bet;
    private boolean Divide = false;
    private List<Deck.Card> hand = new ArrayList<>();
    private List<Deck.Card> hand2 = new ArrayList<>();
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
            this.bet = bet;
        }
        if(bet < MINIMUM_BET){
            throw new Exception("The minimum bet is: "+MINIMUM_BET);
        }
    }

    public List<Deck.Card> addCardToHand(Deck deck){
        hand.add(deck.stealCard());
        return hand;
    }

    @Override
    public String toString() {
        if(Divide){
            return alias + " Hand 1 [" + hand + "]" + " Hand 2 [" + hand2 + "]" + "chips: " + chips;
        }
        return alias + "[" + hand + "]" + "bet: " + bet;
    }

    public List<Deck.Card> getHand() {
        return hand;
    }

    public List<Deck.Card> getHand2() {
        return hand2;
    }

    public boolean isDivide(){
        if(Divide){
            return true;
        }else{
            return false;
        }
    }

    public void setHand(List<Deck.Card> hand) {
        this.hand = hand;
    }

    public void turnOffDivide() {
        this.Divide = false;
    }

    public void win(){
        this.chips += (this.bet * 2);
        this.bet = 0;
    }

    public void lose(){
        this.bet = 0;
    }

    public int handSum(List<Deck.Card> hand){
        int valor = 0;
        for (int i = 0; i < hand.size(); i++) {
            valor += hand.get(i).getValor();
        }
        return valor;
    }

    public void doubleBet(){
        try {
            bet(this.bet);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String divideHand(List<Deck.Card> hand){
        Divide = true;
        hand2.add(hand.remove(1));
        hand2.add(deck.stealCard());
        return alias + " Mano2 [" + hand2 + "]";
    }

}
