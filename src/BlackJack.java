import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

    public void gameSense(Player crupier, Player player){
        boolean endGame = false;
        System.out.println("Bienvenido, a continuacion se explicaran las reglas del juego.");
        System.out.println();
        rules();
        while (!endGame) {
            sortDeck();
            System.out.println("Mezclando...");
            shuffleDeck();
            phaseOne(player);
        }

    }

    public void rules(){
        try (FileReader rules = new FileReader("BlackJackRules.txt");
             BufferedReader bRules = new BufferedReader(rules)){

                String line;
                while ((line = bRules.readLine()) != null) {
                    System.out.println(line);
                }
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();
    }

    public void phaseOne(Player player){
        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.println("Haz la apuesta inicial: ");
        int bet = scan.nextInt();
        scan.close();
        try {
            player.bet(bet);
        } catch (Exception e) {
            System.err.println("Apuesta insuficiente: " + e.getMessage());
        }
    }

    public void phaseTwo(Player player, Player crupier){
        for (int i = 0; i < 2; i++) {
            crupier.addCardToHand();
            player.addCardToHand();
        }
        System.out.println("Primera carta crupier: " + crupier.getHand().get(0) + "valor: " + crupier.getHand().get(0).getValor());
        System.out.println(player.toString() + " valor mano: " + player.handSum(player.getHand()));

    }

    
}
