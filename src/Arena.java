import java.util.HashMap;
import java.util.Scanner;

public class Arena {
    Characters player = new Characters(null, 100, 10, 10, 10, 10);
    static Classes classes = new Classes();
    public Arena() {
        Scanner scan = new Scanner(System.in);
        try {
            int choice = scan.nextInt();
            System.out.print("Your name: ");
            String name = scan.next();
            switch (choice) {
                case 1 -> player.classChoice(name, 12, 15, 8, 5);
                case 2 -> player.classChoice(name, 15, 5, 12, 8);
                case 3 -> player.classChoice(name, 5, 4, 16, 15);
                case 4 -> player.classChoice(name, 15, 5, 15, 5);
            }
            boolean game = true;
            while (game) {
                System.out.println("Start? (Y/N)");
                String choice = scan.nextLine();
                switch (choice) {
                    case "Y" -> {
                        System.out.print("""
                        Choose your enemy! (Write 1 - 4 to choose.)
                        1. Karl the Knight
                        2. Aaron the Archer
                        3. Markus the Mage
                        4. Robert the Rogue
                        Write here:""");
                        int enemyChoice = scan.nextInt();
                        boolean fight = true; // Använder boolean värde för att styra koden. Starta det eller sluta det.
                        while (fight) {      // Den här while loopen håller spelet.
                            enemyChoice--;  // minus 1 för att välja från indexen, det börjar på 0 ju.
                            fight = fightMenu(classes.enemies, enemyChoice);
                        }
                    }
                    case "N" -> {
                        game = false;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Try again, choose one of the options listed above.");
            scan.nextLine();
        }
    }

    public boolean fightMenu(HashMap<Integer, Characters> classes, int enemyChoice) {
        Scanner scan = new Scanner(System.in);
        while (player.getHealth() > 0 && classes.get(enemyChoice).getHealth() > 0) { // all the codes before the while loop is the 'main menu'/'lobby' of the game, will expand upon it further
            System.out.println("[" + player.getName() + " VS " + classes.get(enemyChoice).getName() + "]");
            // Använder speciell text kod för att skriva text.
            System.out.print(""" 
                                Write 1, 2, 3 or 4 to choose your next action.
                                1. Normal Attack
                                2. Special Attack
                                3. Show info
                                4. Surrender
                                Write here:""");
            int choice = scan.nextInt();
            switch (choice) {          // uses an enhanced switch case to maneuver and do tasks around the program with inputs from Scanner.
                case 1 -> normalAttack(classes, enemyChoice); // case för att köra normalAttack
                case 2 -> specialAttack(classes, enemyChoice);
                case 3 -> { // visa information för spelaren och fienden.
                    player.showStats();
                    classes.get(enemyChoice).showStats();
                }
                case 4 -> { // Case för att ge upp. Det gör också så att liv för båda blir 100 igen.
                    System.out.println("Goodbye!");
                    player.reset();
                    classes.get(enemyChoice).reset();
                    return false;
                }
            }
        }
        if (player.getHealth() <= 0) {
            System.out.println("You lost.");
        }
        if (classes.get(enemyChoice).getHealth() <= 0) {
            System.out.println("You won!");
        }
        return false;
    }

    public void normalAttack(HashMap<Integer, Characters> classes, int enemyChoice){
        player.warCry();
        classes.get(enemyChoice).fight(player.getAttack(), player.getDefense(), player.getName());
        System.out.println("(" + player.getName() + ": " + player.getHealth() + ")\n(" + classes.get(enemyChoice).getName() + ": " + classes.get(enemyChoice).getHealth() + ")");
        classes.get(enemyChoice).warCry();
        player.fight(classes.get(enemyChoice).getAttack(), classes.get(enemyChoice).getDefense(), classes.get(enemyChoice).getName());
    }

    public void specialAttack(HashMap<Integer, Characters> classes, int enemyChoice) {  // case för att köra specialAttack.
        player.warCry();
        classes.get(enemyChoice).fight(player.getSpecialAttack(), player.getSpecialDefense(), player.getName());
        System.out.println("(" + player.getName() + ": " + player.getHealth() + ")\n(" + classes.get(enemyChoice).getName() + ": " + classes.get(enemyChoice).getHealth() + ")");
        classes.get(enemyChoice).warCry();
        player.fight(classes.get(enemyChoice).getSpecialAttack(), classes.get(enemyChoice).getSpecialDefense(), classes.get(enemyChoice).getName());
    }
}

