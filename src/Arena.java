import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Arena { // this class is for the game, where you can choose your class, your enemy, and the main fighting system is here as well-
    public Arena(HashMap<Integer, Characters> classes) {
        Random random = new Random();    // all the codes before the while loop is the 'main menu'/'lobby' of the game, will expand upon it further
        Scanner scan = new Scanner(System.in);
        Characters player = new Characters("Patrick", 100, 10, 10, 10, 10);
        System.out.println("Welcome to the Arena!\nPress enter to continue");
        scan.next();
        boolean fight = true;
        try {
            System.out.println("Choose your enemy! (Write 1, 2, 3, or 4 to choose.)");
            System.out.print("1. Karl the Knight\n2. Aaron the Archer\n3. Markus the Mage\n4. Robert the Rogue\nWrite here: ");
            int enemyChoice = scan.nextInt();
            while (fight) {            // this while loop contains the fighting part of the program.
                enemyChoice--;
                try {
                    while (player.getHealth() > 0 && classes.get(enemyChoice).getHealth() > 0) {
                        System.out.println("[" + player.getName() + " VS " + classes.get(enemyChoice).getName() + "]");
                        System.out.println("(Write 1 or 2 to choose your next action.)");
                        System.out.print("1. Normal Attack\n2. Special Attack\nWrite here: ");
                        int choice = scan.nextInt();
                        switch (choice) {          // uses an enhanced switch case to maneuver and do tasks around the program with inputs from Scanner.
                            case 1 -> {
                                classes.get(enemyChoice).fight(player.getAttack());
                            }
                            case 2 -> { // case for ending the fight, I will code further enabling you to return to the 'main menu' but for now this is all.
                                System.out.println("Goodbye!");
                                fight = false;
                            }
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Try again, choose one of the options listed above.");
                    fight = false;
                }
            }
        } catch (Exception e) {
            System.out.println("Try again, choose one of the options listed above.");
        }
    }
}
