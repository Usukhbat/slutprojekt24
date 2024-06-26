import java.util.Random;

public class Characters {        // this is the class where I have most of the important methods connected to the objects in Arena.java.
    private  String name;
    private int health, attack, defense, specialAttack, specialDefense; // alla attribute av en objekt
    public Characters(String name, int health, int attack, int defense, int specialAttack, int specialDefense){
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
    }
    public String getName(){ return name; } // the typical getter methods are used here.
    public int getHealth(){ return health; }
    public int getAttack(){
        return attack;
    }
    public int getDefense(){
        return defense;
    }
    public int getSpecialAttack(){
        return specialAttack;
    }
    public int getSpecialDefense(){
        return specialDefense;
    }
    public void warCry(){
        System.out.println("\nI shall not falter!");
    } // Voice line for player before attack.
    public void classChoice(String name, int attack, int defense, int specialAttack, int specialDefense){ // method for helping the player choose a class
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
    }
    public void showStats(){  // a simple method using abusing "this" to show the stats (attributes) of an object.
        System.out.println("\n["+this.name+"]");
        System.out.println("Health: "+this.health);
        System.out.println("Attack: "+this.attack);
        System.out.println("Defense: "+this.defense);
        System.out.println("Special Attack: "+this.specialAttack);
        System.out.println("Special Defense: "+this.specialDefense);
    }
    public void fight(int damage, int defense, String name){ // the main damage system
        Random rand = new Random();
        int random = rand.nextInt(1,6);
        damage = (damage+defense+random)/2;
        System.out.println(name +" dealt "+damage+"Hp!");
        this.health -= damage;
    }
    public void reset(){ // resets the health of the caller to 100.
        this.health = 100;
    }
}