import java.util.Random;
import java.util.Scanner;

public class Arena { // this class is for the game, where you can choose your class, your enemy, and the main fighting system is here as well-

    public Arena(){
        Random random = new Random();    // all the codes before the while loop is the 'main menu'/'lobby' of the game, will expand upon it further
        int value = random.nextInt(1, 6);
        Scanner scan = new Scanner(System.in);
        Knight player = new Knight("Ben",100,10,10,10,10,10);
        Characters enemy = new Characters("Dan",100,10,10,10,10,10);
        System.out.println("Welcome to the Arena!");
        boolean game = true;
        while (game){            // this while loop contains the fighting part of the program.
            System.out.println("Write 1 or 2 to choose your next action.");
            System.out.print("1. Fight\n2. Surrender\nWrite here: ");
            int choice = scan.nextInt();
            switch (choice){          // uses an enhanced switch case to maneuver and do tasks around the program with inputs from Scanner.
                case 1 -> {
                    while(player.getHealth() > 0 && enemy.getHealth() > 0) {
                        System.out.println("[" + player.getName() + " VS " + enemy.getName() + "]\n1. Normal Attack\n2. Special Attack\n3. Go back");
                        choice = scan.nextInt();
                        int report;
                        switch (choice) {  // this is another enhanced switch case for managing the attacks of each fighter, both the player and enemy.
                            case 1 -> { // the normal attacks of the player
                                enemy.dealDamage(player.getName(), player.getAttack(), value);
                                player.currentMatch(player.getName(), player.getHealth(), enemy.getName(), enemy.getHealth());
                                report = enemy.winCondition(player.getHealth(), enemy.getHealth());
                                enemy.matchEnd(report); //
                            }
                            case 2 -> { // the special attacks of the player
                                enemy.dealDamage(player.getName(), player.getSpecialAttack(), value);
                                player.currentMatch(player.getName(), player.getHealth(), enemy.getName(), enemy.getHealth());
                                report = enemy.winCondition(player.getHealth(), enemy.getHealth());
                                enemy.matchEnd(report);
                            }
                            default -> {
                                player.dealDamage(enemy.getName(), enemy.getSpecialAttack(), value);
                                player.currentMatch(player.getName(), player.getHealth(), enemy.getName(), enemy.getHealth());
                                report = player.winCondition(player.getHealth(), enemy.getHealth());
                                player.matchEnd(report);
                            }
                        }
                    }
                }
                case 2 -> { // case for ending the fight, I will code further enabling you to return to the 'main menu' but for now this is all.
                    System.out.println("Embarrassing!");
                    game = false;
                }
            }
        }
    }
}
