import java.util.ArrayList;
import java.util.List;

public class Player {

    private Deck deck;
    private String alias;
    private int chips;
    private int bet1;
    private int bet2;
    private boolean Divide = false;
    private List<Deck.Card> hand = new ArrayList<>();
    private List<Deck.Card> hand2 = new ArrayList<>();
    private final int MINIMUM_BET = 5;


    public Player(String alias, int chips) {
        this.alias = alias;
        this.chips = chips;
        this.bet1 = 0;
        this.bet2 = 0;
    }

    public Player(String alias) {
        this.alias = alias;
    }

    public void bet(int bet) throws Exception{
        if(this.chips < bet){
            throw new Exception("The bet exceeds your amount, try again");
        }
        if(this.chips > bet){
            this.chips -= bet;
            this.bet1 = bet;
        }
        if(bet < MINIMUM_BET){
            throw new Exception("The minimum bet is: "+MINIMUM_BET);
        }
    }

    public void bet2(int bet) throws Exception{
        if(this.chips < bet){
            throw new Exception("The bet exceeds your amount, try again");
        }
        if(this.chips > bet){
            this.chips -= bet;
            this.bet2 = bet;
        }
        if(bet < MINIMUM_BET){
            throw new Exception("The minimum bet is: "+MINIMUM_BET);
        }
    }

    public void addCardToHand(Deck deck){
        hand.add(deck.stealCard());
    }

    public void addCardToHand2(Deck deck){
        hand2.add(deck.stealCard());
    }
    

    @Override
    public String toString() {
        int totalbet = bet1 + bet2;
        if(Divide){
            return alias + " Hand 1 [" + hand + "]" + " Hand 2 [" + hand2 + "]" + "chips: " + chips;
        }
        return alias + " " + hand + " " + "bet: " + totalbet;
    }

    public String toStringCrupier() {
        return alias + " " + hand;
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

    public void win1(){
        this.chips += (this.bet1 * 2);
        this.bet1 = 0;
    }

    public void win2(){
        this.chips += (this.bet2 * 2);
        this.bet2 = 0;
    }

    public void lose1(){
        this.bet1 = 0;
    }

    public void lose2(){
        this.bet2 = 0;
    }

    public void empate1(){
        this.chips += this.bet1;
        this.bet1 = 0;
    }

    public void empate2(){
        this.chips += this.bet2;
        this.bet2 = 0;
    }

    public int handSum(List<Deck.Card> hand){
        int valor = 0;
        for (int i = 0; i < hand.size(); i++) {
            valor += hand.get(i).getValor();
        }
        return valor;
    }

    public void doubleBet(){
        if(isDivide()){
            try {
                bet2(this.bet1);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }else{
            try {
                bet(this.bet1);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String divideHand(List<Deck.Card> hand){
        Divide = true;
        hand2.add(hand.remove(1));
        hand2.add(deck.stealCard());
        return alias + " Mano2 [" + hand2 + "]";
    }
}
