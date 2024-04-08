import java.util.Random;
import java.util.Scanner;

public class Arena {

    public Arena(){
        Scanner scan = new Scanner(System.in);
        Characters player = new Characters("Ben",100,10,10,10,10,10);
        Characters enemy = new Characters("Dan",100,10,10,10,10,10);
        System.out.println("Welcome to the Arena!");
        boolean game = true;
        while (game){
            System.out.println("Type 1-2 to choose your next action.");
            System.out.print("1. Fight\n2. Exit\nType here: ");
            int choice = scan.nextInt();
            switch (choice){
                case 1 -> {
                    while(player.getHealth()>0 && enemy.getHealth()>0) {
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
                }
                case 2 -> {
                    System.out.println("Bye!");
                    game = false;
                }
            }
        }
    }
}
