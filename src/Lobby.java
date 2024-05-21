import java.util.Scanner;

public class Lobby {

    public Lobby() {
    Scanner scan = new Scanner(System.in);
        System.out.print("Welcome to the Arena!\nPress enter to start");
        scan.nextLine();
        System.out.println("""
                [Lobby]
                
                You can choose between four classes to play as.
                A knight, an archer, a mage, or a rogue.
                Each class has their advantages and disadvantages.
                Choose one to your liking.
                
                After you've chosen a class, you will be met with 4 brave opponents.
                Karl the Knight, Aaron the Archer, Markus the Mage, and Robert the Rogue.
                You will fight one of them to the death in an honorable duel.
                Win the fight, and you win your freedom.
                Good luck!
                
                [Classes]
                
                [Knight]
                Attack: 12
                Defense: 15
                Special Attack: 8
                Special Defense: 5
                
                [Archer]
                Attack: 15
                Defense: 5
                Special Attack: 12
                Special Defense: 8
                
                [Mage]
                Attack: 5
                Defense: 4
                Special Attack: 16
                Special Defense: 15
                
                [Rogue]
                Attack: 15
                Defense: 5
                Special Attack: 15
                Special Defense: 5
                
                Write 1 to 4 to choose your class:
                """);
        new Arena();
    }
}
