import java.util.HashMap;
import java.util.List;

public class Classes {
    List<Characters> classes = List.of(new Knight("Karl",100,10,10,10,10), new Archer("Aaron",100,10,10,10,10), new Mage("Markus",100,10,10,10,10), new Rogue("Robert",100,10,10,10,10));
    HashMap<Integer, Characters> enemies = new HashMap<>();
    public Classes(){
        int index = 0;
        for(Characters c : classes){
            enemies.put(index, c);
            index++;
        }
    }
}
