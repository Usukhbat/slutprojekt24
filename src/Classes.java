import java.util.HashMap;
import java.util.List;

public class Classes {
    List<Characters> classes = List.of(
            new Knight("Karl",100,12,15,8,5),
            new Archer("Aaron",100,15,5,12,8),
            new Mage("Markus",100,5,4,16,15),
            new Rogue("Robert",100,15,5,15,5));
    HashMap<Integer, Characters> enemies = new HashMap<>();
    public Classes(){
        int index = 0;
        for(Characters c : classes){
            enemies.put(index, c);
            index++;
        }
    }
}
