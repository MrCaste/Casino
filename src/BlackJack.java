import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BlackJack {

    private Deck deck = new Deck();
    Scanner console = new Scanner(System.in);

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
            phaseThree(crupier, player);
            phaseFour(crupier, player);
            if(player.handSum(player.getHand()) == 21 || player.handSum(player.getHand2()) == 21){
                if(player.handSum(player.getHand()) == 21 && player.isDivide()){
                    System.out.println("\nEl jugador tiene BlackJack en la Mano 1!!... Desea seguir jugando? s/n");
                    player.win1();
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
                else if(player.handSum(player.getHand2()) == 21 && player.isDivide()){
                    System.out.println("\nEl jugador tiene BlackJack en la Mano 2!!... Desea seguir jugando? s/n");
                    player.win1();
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
                else if(player.handSum(player.getHand()) == 21 && player.handSum(player.getHand2()) == 21 && player.isDivide()){
                    System.out.println("\nEl jugador tiene BlackJack en ambas Manos!!... Desea seguir jugando? s/n");
                    player.win1();
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
                else if(player.handSum(player.getHand()) == 21 && !player.isDivide()){
                    System.out.println("\nEl jugador tiene BlackJack!!... Desea seguir jugando? s/n");
                    player.win1();
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
            }
            if(crupier.handSum(crupier.getHand()) > 21 && player.handSum(player.getHand()) < 21 || crupier.handSum(crupier.getHand()) > 21 && player.handSum(player.getHand2()) < 21){
                if(crupier.handSum(crupier.getHand()) > 21 && player.handSum(player.getHand()) < 21 && player.isDivide()){
                    System.out.println("\nEl jugador gana en la Mano 1... Desea seguir jugando? s/n");
                    player.win1();
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
                else if(crupier.handSum(crupier.getHand()) > 21 && player.handSum(player.getHand2()) < 21 && player.isDivide()){
                    System.out.println("\nEl jugador gana en la Mano 2... Desea seguir jugando? s/n");
                    player.win2();
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
                else if(crupier.handSum(crupier.getHand()) > 21 && player.handSum(player.getHand()) < 21 && crupier.handSum(crupier.getHand()) > 21 && player.handSum(player.getHand2()) < 21 && player.isDivide()){
                    System.out.println("\nEl jugador gana en ambas Manos... Desea seguir jugando? s/n");
                    player.win2();
                    player.win1();
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
                else if(crupier.handSum(crupier.getHand()) > 21 && player.handSum(player.getHand()) < 21 && !player.isDivide()){
                    System.out.println("\nEl jugador gana... Desea seguir jugando? s/n");
                    player.win1();
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
            }
            if(player.handSum(player.getHand()) > crupier.handSum(crupier.getHand()) || player.handSum(player.getHand2()) > crupier.handSum(crupier.getHand())
            && player.handSum(player.getHand()) < 21 || player.handSum(player.getHand2()) < 21){
                if(crupier.handSum(crupier.getHand()) < player.handSum(player.getHand()) && player.handSum(player.getHand()) < 21 && player.isDivide()){
                    System.out.println("\nEl jugador gana en la Mano 1... Desea seguir jugando? s/n");
                    player.win1();
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
                else if(crupier.handSum(crupier.getHand()) < player.handSum(player.getHand2()) && player.handSum(player.getHand2()) < 21 && player.isDivide()){
                    System.out.println("\nEl jugador gana en la Mano 1... Desea seguir jugando? s/n");
                    player.win2();
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
                else if(crupier.handSum(crupier.getHand()) > player.handSum(player.getHand()) && player.handSum(player.getHand2()) < crupier.handSum(crupier.getHand()) 
                        && player.handSum(player.getHand2()) < 21 && player.handSum(player.getHand()) < 21 && player.isDivide()){
                    System.out.println("\nEl jugador gana en ambas Manos... Desea seguir jugando? s/n");
                    player.win1();
                    player.win2();
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
                else if(crupier.handSum(crupier.getHand()) < player.handSum(player.getHand()) && player.handSum(player.getHand()) < 21 && !player.isDivide()){
                    System.out.println("\nEl jugador gana... Desea seguir jugando? s/n");
                    player.win1();
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
            }
            if(crupier.handSum(crupier.getHand()) > player.handSum(player.getHand()) && crupier.handSum(crupier.getHand()) <= 21 || crupier.handSum(crupier.getHand()) > player.handSum(player.getHand2()) && crupier.handSum(crupier.getHand()) <= 21){
                if(crupier.handSum(crupier.getHand()) > player.handSum(player.getHand()) && crupier.handSum(crupier.getHand()) <= 21 && player.isDivide()){
                    System.out.println("\nEl jugador pierde en la Mano 1... Desea seguir jugando? s/n");
                    player.lose1();
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
                else if(crupier.handSum(crupier.getHand()) > player.handSum(player.getHand2()) && crupier.handSum(crupier.getHand()) <= 21 && player.isDivide()){
                    System.out.println("\nEl jugador pierde en la Mano 2... Desea seguir jugando? s/n");
                    player.lose2();
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
                else if(crupier.handSum(crupier.getHand()) > player.handSum(player.getHand2()) && crupier.handSum(crupier.getHand()) > player.handSum(player.getHand()) && crupier.handSum(crupier.getHand()) <= 21 && player.isDivide()){
                    System.out.println("\nEl jugador pierde en ambas Manos... Desea seguir jugando? s/n");
                    player.lose2();
                    player.lose1();
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
                else if(crupier.handSum(crupier.getHand()) > player.handSum(player.getHand()) && crupier.handSum(crupier.getHand()) <= 21 && !player.isDivide()){
                    System.out.println("\nEl jugador pierde... Desea seguir jugando? s/n");
                    player.lose1();
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
            }
            if(player.handSum(player.getHand()) > 21 || player.handSum(player.getHand2()) > 21){
                if(player.handSum(player.getHand()) > 21 && player.isDivide()){
                    System.out.println("\nEl jugador pierde en la Mano 1... Desea seguir jugando? s/n");
                    player.lose1();
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
                else if(player.handSum(player.getHand2()) > 21 && player.isDivide()){
                    System.out.println("\nEl jugador pierde en la Mano 2... Desea seguir jugando? s/n");
                    player.lose2();
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
                else if(player.handSum(player.getHand2()) > 21 && player.handSum(player.getHand()) > 21 && player.isDivide()){
                    System.out.println("\nEl jugador pierde en ambas Manos... Desea seguir jugando? s/n");
                    player.lose2();
                    player.lose1();
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
                else if(player.handSum(player.getHand()) > 21 && !player.isDivide()){
                    System.out.println("\nEl jugador pierde... Desea seguir jugando? s/n");
                    player.lose1();
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
            }
            if(player.handSum(player.getHand()) == crupier.handSum(crupier.getHand()) || player.handSum(player.getHand2()) == crupier.handSum(crupier.getHand())){
                if(player.handSum(player.getHand()) == crupier.handSum(crupier.getHand()) && player.isDivide()){
                    System.out.println("\nEmpate en la mano 1... Desea seguir jugando? s/n");
                    player.empate1();
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
                else if(player.handSum(player.getHand2()) == crupier.handSum(crupier.getHand()) && player.isDivide()){
                    System.out.println("\nEmpate en la mano 2... Desea seguir jugando? s/n");
                    player.empate2();
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
                else if(player.handSum(player.getHand()) == crupier.handSum(crupier.getHand()) && player.handSum(player.getHand2()) == crupier.handSum(crupier.getHand()) && player.isDivide()){
                    System.out.println("\nEmpate en ambas manos... Desea seguir jugando? s/n");
                    player.empate1();
                    player.empate2();
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
                else{
                    if(player.handSum(player.getHand()) == crupier.handSum(crupier.getHand()) && !player.isDivide()){
                        System.out.println("\nEmpate... Desea seguir jugando? s/n");
                        player.empate1();
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
                }
            }
            if(player.isDivide()){
                player.turnOffDivide();
                player.getHand().clear();
                player.getHand2().clear();
                crupier.getHand().clear();
            }
            else{
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
        boolean exit = false;
        while (!exit) {
            try {
                System.out.print("\nHaz la apuesta inicial: ");
                int bet = Integer.parseInt(console.nextLine());
                player.bet(bet);
                exit = true;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            } 
        }
    }

    public void phaseTwo(Player crupier, Player player){
        for (int i = 0; i < 2; i++) {
            crupier.addCardToHand(deck);
            player.addCardToHand(deck);
        }
    }

    public void phaseThree(Player crupier, Player player){
        boolean exit = false;
        boolean exitDivide = false;
        boolean divide = false;
        do {

            System.out.println("\nPrimera carta crupier: " + crupier.getHand().get(0) + " valor: " + crupier.getHand().get(0).getValor());
            if(player.isDivide()){
                System.out.println(player.toString() + " valor mano 1: " + player.handSum(player.getHand()) + " valor mano 2: " + player.handSum(player.getHand2()));
            }
            else{
                System.out.println(player.toString() + " valor mano: " + player.handSum(player.getHand()));
            }
            System.out.print("\n1. Pedir carta.  ");
            System.out.print("2. Plantarse.  ");
            System.out.print("3. Doblar apuesta.  ");
            System.out.print("4. Dividir.  : ");
            int opcion = Integer.parseInt(console.nextLine());
            switch (opcion) {
                case 1:
                    if(divide){
                            do {
                                System.out.println("\nMano?");
                                if(player.handSum(player.getHand()) > 21){
                                    System.out.print("2. Mano 2.  ");
                                    System.out.print("4. Volver.  : ");
                                }
                                else if(player.handSum(player.getHand2()) > 21){
                                    System.out.print("1. Mano 1.  ");
                                    System.out.print("4. Volver.  : ");
                                }
                                else {
                                    System.out.print("1. Mano 1.  ");
                                    System.out.print("2. Mano 2.  ");
                                    System.out.print("3. Ambas.  ");
                                    System.out.print("4. Volver.  : ");
                                }
                                int opcionDivide = Integer.parseInt(console.nextLine());
                                switch (opcionDivide) {
                                    case 1:
                                        player.addCardToHand(deck);
                                        exitDivide = true;
                                        break;
                                    case 2:
                                        player.addCardToHand2(deck);
                                        exitDivide = true;
                                        break;
                                    case 3:
                                        player.addCardToHand(deck);
                                        player.addCardToHand2(deck);
                                        exitDivide = true;
                                        break;
                                    case 4:
                                        exitDivide = true;
                                        break;
                                    default:
                                        System.err.println("\n\nOpcion no valida, por favor, seleccione una opcion correcta: ");
                                        break;
                                } 
                                if(player.handSum(player.getHand()) >= 21 && player.handSum(player.getHand2()) >= 21){
                                    exit = true;
                                }
                            } while (!exitDivide);
                    }
                    else{
                        player.addCardToHand(deck);
                        if(player.handSum(player.getHand()) >= 21){
                            exit = true;
                        }
                    }
                    break;
                case 2:
                    exit = true;
                    break;
                case 3:
                    player.doubleBet();
                    break;
                case 4:
                    if(player.getHand().get(0).getValor() == (player.getHand().get(1).getValor())){
                        System.out.println(player.divideHand(player.getHand()));
                        player.doubleBet();
                        player.addCardToHand(deck);
                        System.out.println(" Mano1 [" + player.getHand() + "]");
                    }
                    else {
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
        System.out.println("\n" + crupier.toStringCrupier() + " valor mano: " + crupier.handSum(crupier.getHand()));
        if(player.isDivide()){
            System.out.println(player.toString() + " valor mano 1: " + player.handSum(player.getHand()) + " valor mano 2: " + player.handSum(player.getHand2()));
        }
        else{
            System.out.println(player.toString() + " valor mano: " + player.handSum(player.getHand()));
        }
        if(player.isDivide()){
            if(player.handSum(player.getHand()) < 21 || player.handSum(player.getHand2()) < 21){
                while (crupier.handSum(crupier.getHand()) <= 16) {
                    System.out.println("\nEl crupier pide carta...\n");
                    crupier.addCardToHand(deck);
                    System.out.println(crupier.toString() + " valor mano: " + crupier.handSum(crupier.getHand()));
                    System.out.println(player.toString() + " valor mano: " + player.handSum(player.getHand()));
                }
                if(crupier.handSum(crupier.getHand()) > 21){
                    System.out.println("El crupier se pasa...");
                }
                else if(crupier.handSum(crupier.getHand()) < 21){
                    System.out.println("El crupier se planta...");
                }
                else if(crupier.handSum(crupier.getHand()) == player.handSum(player.getHand()) || crupier.handSum(crupier.getHand()) == player.handSum(player.getHand2())){
                }
                else{
                    System.out.println("BlackJack del crupier!!");
                }
            }
        }
        else{
            if(player.handSum(player.getHand()) < 21){
                while (crupier.handSum(crupier.getHand()) <= 16) {
                    System.out.println("\nEl crupier pide carta...\n");
                    crupier.addCardToHand(deck);
                    System.out.println(crupier.toString() + " valor mano: " + crupier.handSum(crupier.getHand()));
                    System.out.println(player.toString() + " valor mano: " + player.handSum(player.getHand()));
                }
                if(crupier.handSum(crupier.getHand()) > 21){
                    System.out.println("\nEl crupier se pasa...");
                }
                else if(crupier.handSum(crupier.getHand()) < 21){
                    System.out.println("\nEl crupier se planta...");
                }
                else if(crupier.handSum(crupier.getHand()) == player.handSum(player.getHand())){
                }
                else{
                    System.out.println("\nBlackJack del crupier!!");
                }
            }
        }
    }

    
}
