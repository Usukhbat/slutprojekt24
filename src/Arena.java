import java.util.Random;
import java.util.Scanner;

public class Arena {

    public Arena(){
        Scanner scan = new Scanner(System.in);
        Knight player = new Knight("Ben",100,10,10,10,10,10);
        Characters enemy = new Characters("Dan",100,10,10,10,10,10);
        System.out.println("Welcome to the Arena!");
        boolean game = true;
        while (game){
            System.out.println("Type 1-2 to choose your next action.");
            System.out.print("1. Fight\n2. Surrender\nType here: ");
            int choice = scan.nextInt();
            switch (choice){
                case 1 -> {
                    System.out.println("[Fight]\n1. Normal Attack\n2. Special Attack\n3. Go back");
                    choice = scan.nextInt();
                    switch (choice){
                        case 1 -> {
                            Random random = new Random();
                            int value = random.nextInt(1, 6);
                            player.dealDamage(enemy.getAttack(), value);
                            enemy.dealDamage(player.getAttack(), value);
                            player.currentMatch();
                            enemy.currentMatch();
                            if (player.getHealth() < enemy.getHealth()) {
                                enemy.matchSummary();
                            }
                            if (enemy.getHealth() < player.getHealth()) {
                                player.matchSummary();
                            }
                        }
                        case 2 ->{
                            Random random = new Random();
                            int value = random.nextInt(1, 6);
                            player.dealDamage(enemy.getSpecialAttack(), value);
                            enemy.dealDamage(player.getSpecialAttack(), value);
                            player.currentMatch();
                            enemy.currentMatch();
                            if (player.getHealth() < enemy.getHealth()) {
                                enemy.matchSummary();
                            }
                            if (enemy.getHealth() < player.getHealth()) {
                                player.matchSummary();
                            }
                        }
                    }
                }
                case 2 -> {
                    System.out.println("Bye!");
                    game = false;
                }
            }
        }
    }
}
