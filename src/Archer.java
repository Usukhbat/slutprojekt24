public class Archer extends Characters{
    public Archer(String name, int health, int attack, int defense, int specialAttack, int specialDefense){ // a super class, will be more of these in the future for other character classes.
        super(name, health, attack, defense, specialAttack, specialDefense);
    }
    public void warCry(){
        System.out.println("May my aim be true and my arrows swift, striking fear into the hearts of my foes from afar!");
    }
}
