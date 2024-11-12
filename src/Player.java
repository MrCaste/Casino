import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

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

    public Player createPlayer(){
        Scanner scanAlias = new Scanner(System.in);
        boolean correct = false;
        do {
            try (scanAlias){
                insertAlias();
                insertChips();
                Player player = new Player(alias, chips);
                correct = true;
                return player;
            } catch (InputMismatchException e) {
                System.out.println("Error: nick name or chips are incorrect");
            }
        } while (!correct);
        throw new InputMismatchException();
    }

    public Player createCrupier(){
        Player crupier = new Player("Crupier");
        return crupier;
    }

    public String insertAlias(){
        try (Scanner scanAlias = new Scanner(System.in)) {
            System.out.print("Insert your nick name: ");
            String alias = scanAlias.nextLine();
            return alias;
        }
    }

    public int insertChips(){
        try (Scanner scanAlias = new Scanner(System.in)) {
            System.out.print("Insert your amount of chips: ");
            int chips = scanAlias.nextInt();
            return chips;
        }
    }

    public List<Deck.Card> getHand() {
        return hand;
    }

    public void setHand(List<Deck.Card> hand) {
        this.hand = hand;
    }

    public int handSum(List<Deck.Card> hand){
        int valor = 0;
        for (int i = 0; i < hand.size(); i++) {
            valor =+ hand.get(i).getValor();
        }
        return valor;
    }

    

}
