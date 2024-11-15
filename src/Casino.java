import java.util.InputMismatchException;
import java.util.Scanner;

public class Casino {
    public static void main(String[] args) throws Exception {
        Casino casino = new Casino();
        casino.blackJack();
    }

    public void blackJack(){
        Scanner console = new Scanner(System.in);
        BlackJack blackJ = new BlackJack();
        String alias = null;
        int chips = 0;
        boolean correct = false;
        do {
            try {
                System.out.print("Insert your nick name: ");
                alias = console.nextLine();
                System.out.print("Insert your amount of chips: ");
                chips = Integer.parseInt(console.nextLine());
                correct = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: nick name or chips are incorrect");
            }
        } while (!correct);
        Player player = new Player(alias, chips);
        Player crupier = new Player("Crupier");
        blackJ.gameSense(crupier, player);
        console.close();
    }
}
