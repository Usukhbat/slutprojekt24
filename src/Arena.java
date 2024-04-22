import java.util.Random;
import java.util.Scanner;

public class Arena {

    public Arena(){
        Random random = new Random();
        int value = random.nextInt(1, 6);
        Scanner scan = new Scanner(System.in);
        Knight player = new Knight("Ben",100,10,10,10,10,10);
        Characters enemy = new Characters("Dan",100,10,10,10,10,10);
        System.out.println("Welcome to the Arena!");
        boolean game = true;
        while (game){
            System.out.println("Write 1 or 2 to choose your next action.");
            System.out.print("1. Fight\n2. Surrender\nWrite here: ");
            int choice = scan.nextInt();
            switch (choice){
                case 1 -> {
                    while(player.getHealth() > 0 && enemy.getHealth() > 0) {
                        System.out.println("[" + player.getName() + " VS " + enemy.getName() + "]\n1. Normal Attack\n2. Special Attack\n3. Go back");
                        choice = scan.nextInt();
                        int report = 0;
                        switch (choice) {
                            case 1 -> {
                                enemy.dealDamage(player.getName(), player.getAttack(), value);
                                player.currentMatch(player.getName(), player.getHealth(), enemy.getName(), enemy.getHealth());
                                report = enemy.winCondition(player.getHealth(), enemy.getHealth());
                                enemy.matchEnd(report);
                            }
                            case 2 -> {
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
                case 2 -> {
                    System.out.println("Embarrassing!");
                    game = false;
                }
            }
        }
    }
}
