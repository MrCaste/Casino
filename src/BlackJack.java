import java.util.InputMismatchException;
import java.util.Scanner;

public class BlackJack {

    private Deck deck;

    public void sortDeck(){
        deck.createDeck();
        deck.toString();
    }

    public void shuffleDeck(){
        deck.shuffle();
    }

    public Player createCrupier(){
        Player crupier = new Player("Crupier");
        return crupier;
    }

    public Player createPlayer(){
        Scanner scanAlias = new Scanner(System.in);
        boolean correct = false;
        do {
            try (scanAlias){
                System.out.print("Insert your nick name: ");
                String alias = scanAlias.nextLine();
                System.out.print("Insert your amount of chips: ");
                int chips = scanAlias.nextInt();
                Player player = new Player(alias, chips);
                correct = true;
                return player;
            } catch (InputMismatchException e) {
                System.out.println("Error: nick name or chips are incorrect");
            }
        } while (!correct);
        throw new InputMismatchException();
    }

    public void gameSense(Player crupier, Player player){

    }

    
}
