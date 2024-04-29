public class Rogue extends Characters{
    public Rogue(String name, int health, int attack, int defense, int specialAttack, int specialDefense){ // a super class, will be more of these in the future for other character classes.
        super(name, health, attack, defense, specialAttack, specialDefense);
    }
    public void warCry(){
        System.out.println("From shadow to shadow, I weave my path. With dagger in hand and cunning in mind, I shall outmaneuver and outwit my foes, striking where they least expect!");
    }
}
