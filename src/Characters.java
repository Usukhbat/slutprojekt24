public class Characters {        // this is the class where I have most of the important methods connected to the objects in Arena.java.
    private final String name;
    private int health;
    private final int attack;
    private final int defense;
    private final int specialAttack;
    private final int specialDefense;
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
        System.out.println("Hello!");
    }
    public void showStats(){                    // a simple method using abusing "this" to show the stats (attributes) of an object.
        System.out.println("["+this.name+"]");
        System.out.println("Health: "+this.health);
        System.out.println("Attack: "+this.attack);
        System.out.println("Defense: "+this.defense);
        System.out.println("Special Attack: "+this.specialAttack);
        System.out.println("Special Defense: "+this.specialDefense);
    }
    public void fight(int damage){
        damage = (damage+this.defense)/2;
        System.out.println("You dealt "+damage+"Hp!");
        this.health -= damage;
    }
}