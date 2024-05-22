import java.util.HashMap;
import java.util.Scanner;

public class Arena {

    Characters player = new Characters(null, 100, 10, 10, 10, 10);
    static Classes classes = new Classes();

    public Arena() { // metoden där man kan välja sin klass.
        Scanner scan = new Scanner(System.in);
        try {
            playerChoice();
            boolean game = true; // använder variabeln game som en on/off knapp för spelet
            while (game) {
                game = enemyChoice(); // ropar en metod för att välja fienden.
            }
        } catch (Exception e) { // simpel catch meddelande
            System.out.println("Try again, choose one of the options listed above.");
            scan.nextLine();
        }
    }

    public void playerChoice() {
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        System.out.print("Choose your name: ");
        String name = scan.next();
        switch (choice) { // beroende vilken klass man väljer så får man olika attributes för player
            case 1 -> player.classChoice(name, 12, 15, 8, 5);
            case 2 -> player.classChoice(name, 15, 5, 12, 8);
            case 3 -> player.classChoice(name, 5, 4, 16, 15);
            case 4 -> player.classChoice(name, 15, 5, 15, 5);
        }
    }
    public boolean enemyChoice() { // Den här metoden låter dig välja din fiende. Om man väljer N så stoppas spelet och skickar tillbaka false till game.
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Start? (Y/N)");
            String chai = scan.nextLine();
            switch (chai) {
                case "Y" -> {
                    System.out.print("""
                            Choose your enemy! (Write 1 - 4 to choose.)
                            1. Karl the Knight
                            2. Aaron the Archer
                            3. Markus the Mage
                            4. Robert the Rogue
                            Write here:""");
                    int enemyChoice = scan.nextInt();
                    boolean fight = true; // använder fight för att styra slagsmålet, ifall man ville ge upp halvvägs alltså.
                    while (fight) {
                        enemyChoice--;
                        fight = fightMenu(classes.enemies, enemyChoice); // ifall man ger upp så skickas false till fight och man får välja sin fiende igen.
                    }
                }
                case "N" -> {
                    return false;
                }
            }
        }catch(Exception e){ // simpel catch meddelande
            System.out.println("Try again, choose one of the options listed above.");
        }
        return true;
    }

    public boolean fightMenu(HashMap<Integer, Characters> classes, int enemyChoice) { // Den här metoden har switch case för att styra slagsmålet. Välj mellan 4 val för att styra.
        Scanner scan = new Scanner(System.in);
        try {
            while (player.getHealth() > 0 && classes.get(enemyChoice).getHealth() > 0) {
                System.out.println("\n[" + player.getName() + " VS " + classes.get(enemyChoice).getName() + "]");
                System.out.print(""" 
                        Write 1, 2, 3 or 4 to choose your next action.
                        1. Normal Attack
                        2. Special Attack
                        3. Show info
                        4. Surrender
                        Write here:""");
                int choice = scan.nextInt();
                switch (choice) {
                    case 1 -> normalAttack(classes, enemyChoice); // case för att köra normalAttack
                    case 2 -> specialAttack(classes, enemyChoice); // case för att köra special attack
                    case 3 -> showStats(classes, enemyChoice); // visa information för spelaren och fienden.
                    case 4 -> {
                        giveUp(classes, enemyChoice);
                        return false; // ge upp och skicka false till variabeln fight
                    }
                }
            }
            winCondition(classes, enemyChoice);
        }catch (Exception e){
            System.out.println("Try again, choose one of the options listed above.");
        }
        return false;
    }

    public void showStats(HashMap<Integer, Characters> classes, int enemyChoice) { // metod för att visa stats för spelare och fiende
        player.showStats();
        classes.get(enemyChoice).showStats();
    }

    public void giveUp(HashMap<Integer, Characters> classes, int enemyChoice) { // Metoden för att ge spelare och fiende 100 och gå tillbaka till fiende menyn.
        System.out.println("Goodbye!");
        player.reset(); // använder this.health för att ge spelare och fiende 100 hälsa igen.
        classes.get(enemyChoice).reset();
    }

    public void winCondition(HashMap<Integer, Characters> classes, int enemyChoice) { // kollar hälsan av båda för att se om någon vann.
        if (player.getHealth() <= 0) { // om spelaren hälsa är noll eller mindre, då du förlorat
            System.out.println("You lost.");
        }
        if (classes.get(enemyChoice).getHealth() <= 0) { // om fiendens hälsa är noll eller mindre, då du vann :)
            System.out.println("You won!");
        }
    }

    public void normalAttack(HashMap<Integer, Characters> classes, int enemyChoice){ // den här metoden hanterar normala attacker av båda
        player.warCry(); // utrop av spelaren
        classes.get(enemyChoice).fight(player.getAttack(), player.getDefense(), player.getName()); // Skickar spelaren attack, defense och namn till fight metoden i Characters för att skada fienden. Vi får fiendens hälsa för att metoden ropas med classes.get(enemyChoice)
        System.out.println("\n(" + player.getName() + ": " + player.getHealth() + ")\n(" + classes.get(enemyChoice).getName() + ": " + classes.get(enemyChoice).getHealth() + ")");
        classes.get(enemyChoice).warCry(); // utrop av fienden
        player.fight(classes.get(enemyChoice).getAttack(), classes.get(enemyChoice).getDefense(), classes.get(enemyChoice).getName()); // samma fight metod som tidigare fast nu vi skadar spelaren och tar fiendens attributes.
    }

    public void specialAttack(HashMap<Integer, Characters> classes, int enemyChoice) { // Den här metoden hanterar special attack metoderna. Den är exakt likadan som normalAttack, enda skillnad är att det är med special attributes.
        player.warCry();
        classes.get(enemyChoice).fight(player.getSpecialAttack(), player.getSpecialDefense(), player.getName());
        System.out.println("(" + player.getName() + ": " + player.getHealth() + ")\n(" + classes.get(enemyChoice).getName() + ": " + classes.get(enemyChoice).getHealth() + ")");
        classes.get(enemyChoice).warCry();
        player.fight(classes.get(enemyChoice).getSpecialAttack(), classes.get(enemyChoice).getSpecialDefense(), classes.get(enemyChoice).getName());
    }
}

