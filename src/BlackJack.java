import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BlackJack {

    private Deck deck = new Deck();
    Scanner console = new Scanner(System.in);

    /*
    public static String getMessage() {
        Scanner console = new Scanner(System.in);
        String message = null;
        message = console.nextLine();
        return message;
    }
    */

    public void sortDeck(){
        deck.createDeck();
        System.out.println(deck.toString());
    }

    public void shuffleDeck(){
        deck.shuffle();
    }

    public void gameSense(Player crupier, Player player){
        boolean endGame = false;
        System.out.println("\nBienvenido, a continuacion se explicaran las reglas del juego.");
        System.out.println();
        rules();
        while (!endGame) {
            boolean exit = false;
            sortDeck();
            System.out.println("\nMezclando...");
            shuffleDeck();
            phaseOne(player);
            phaseTwo(crupier, player);
            phaseThree(player);
            phaseFour(crupier, player);
            if(crupier.handSum(crupier.getHand()) > 21){
                
                System.out.println("\nEl jugador gana... Desea seguir jugando? s/n");
                player.win();
                while (!exit) {
                    String opcion = console.nextLine();
                    switch (opcion) {
                        case "s":
                            exit = true;
                            break;
                        case "n":
                            exit = true;
                            endGame = true;
                            break;
                        default:
                            System.err.println("Error, opcion invalida, por favor selecione s o n");
                            break;
                    }
                }
            }
            if(crupier.handSum(crupier.getHand()) < player.handSum(player.getHand()) && player.handSum(player.getHand()) <= 21){
                System.out.println("\nEl jugador gana... Desea seguir jugando? s/n");
                player.win();
                while (!exit) {
                    String opcion = console.nextLine();
                    switch (opcion) {
                        case "s":
                            exit = true;
                            break;
                        case "n":
                            exit = true;
                            endGame = true;
                            break;
                        default:
                            System.err.println("Error, opcion invalida, por favor selecione s o n");
                            break;
                    }
                }
            }
            if(crupier.handSum(crupier.getHand()) > player.handSum(player.getHand()) && crupier.handSum(crupier.getHand()) <= 21){
                System.out.println("\nEl jugador pierde... Desea seguir jugando? s/n");
                player.lose();;
                while (!exit) {
                    String opcion = console.nextLine();
                    switch (opcion) {
                        case "s":
                            exit = true;
                            break;
                        case "n":
                            exit = true;
                            endGame = true;
                            break;
                        default:
                            System.err.println("Error, opcion invalida, por favor selecione s o n");
                            break;
                    }
                }
            }
            if(player.handSum(player.getHand()) > 21){
                System.out.println("\nEl jugador pierde... Desea seguir jugando? s/n");
                player.lose();;
                while (!exit) {
                    String opcion = console.nextLine();
                    switch (opcion) {
                        case "s":
                            exit = true;
                            break;
                        case "n":
                            exit = true;
                            endGame = true;
                            break;
                        default:
                            System.err.println("Error, opcion invalida, por favor selecione s o n");
                            break;
                    }
                }
            }
            if(player.isDivide()){
                player.turnOffDivide();
                player.getHand().clear();
                player.getHand2().clear();
                crupier.getHand().clear();
            }else{
                player.getHand().clear();
                crupier.getHand().clear();
            }
        }
        console.close();
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

        try {
            System.out.print("\nHaz la apuesta inicial: ");
            int bet = Integer.parseInt(console.nextLine());
            player.bet(bet);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void phaseTwo(Player crupier, Player player){
        for (int i = 0; i < 2; i++) {
            crupier.addCardToHand(deck);
            player.addCardToHand(deck);
        }
        System.out.println("\nPrimera carta crupier: " + crupier.getHand().get(0) + " valor: " + crupier.getHand().get(0).getValor());
        System.out.println(player.toString() + " valor mano: " + player.handSum(player.getHand()));
    }

    public void phaseThree(Player player){
        boolean exit = false;
        do {
            System.out.print("\n1. Pedir carta.  ");
            System.out.print("2. Plantarse.  ");
            System.out.print("3. Doblar apuesta.  ");
            System.out.print("4. Dividir.");
            int opcion = Integer.parseInt(console.nextLine());
            switch (opcion) {
                case 1:
                    player.addCardToHand(deck);
                    exit = true;
                    break;
                case 2:
                    exit = true;
                    break;
                case 3:
                    exit = true;
                    player.doubleBet();
                    break;
                case 4:
                    if(player.getHand().get(0).equals(player.getHand().get(1))){
                        player.divideHand(player.getHand());
                        player.doubleBet();
                        player.addCardToHand(deck);
                        System.out.println(" Mano1 [" + player.getHand() + "]");
                        exit = true;
                    }else {
                        System.err.println("No tienes 2 cartas iguales para dividir, elije otra opcion");
                    }
                    break;
                default:
                    System.err.println("Opcion no valida, por favor seleccione una opcion valida");
                    break;
            }
        } while (!exit);
    }

    public void phaseFour(Player crupier, Player player){
        System.out.println(crupier.toString() + " valor mano: " + crupier.handSum(crupier.getHand()));
        System.out.println(player.toString() + " valor mano: " + player.handSum(player.getHand()));
        if(crupier.handSum(crupier.getHand()) <= 16){
            System.out.println("\nEl crupier pide carta...\n");
            crupier.addCardToHand(deck);
            System.out.println(crupier.toString() + " valor mano: " + crupier.handSum(crupier.getHand()));
            System.out.println(player.toString() + " valor mano: " + player.handSum(player.getHand()));
        }
        if(crupier.handSum(crupier.getHand()) >= 17){
            System.out.println("\nEl crupier se planta...");
        }
    }

    
}
