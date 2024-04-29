public class Knight extends Characters{
    public Knight(String name, int health, int attack, int defense, int specialAttack, int specialDefense){ // a super class, will be more of these in the future for other character classes.
        super(name, health, attack, defense, specialAttack, specialDefense);
    }
    public void warCry(){
        System.out.println("By the honor of my blade and the courage of my heart, I shall vanquish all who dare stand against the light!");
    }
}
