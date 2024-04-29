public class Mage extends Characters{
    public Mage(String name, int health, int attack, int defense, int specialAttack, int specialDefense){ // a super class, will be more of these in the future for other character classes.
        super(name, health, attack, defense, specialAttack, specialDefense);
    }
    public void warCry(){
        System.out.println("Through the arcane weave, I command the elements to dance to my will. Let the power of magic be my shield and my weapon in this battle!");
    }
}
