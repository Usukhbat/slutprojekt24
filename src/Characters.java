public class Characters {
    private final String name;
    private int health;
    private int attack;
    private int defense;
    private int specialAttack;
    private int specialDefense;
    private int speed;
    public Characters(String name, int health, int attack, int defense, int specialAttack, int specialDefense, int speed){
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
    }
    public String getName(){
        return name;
    }
    public int getHealth(){
        return health;
    }
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
    public int getSpeed(){
        return speed;
    }
    public void makeNoise(){
        System.out.println("Hello!");
    }
    public void showStats(){
        System.out.println("["+this.name+"]");
        System.out.println("Health: "+this.health);
        System.out.println("Attack: "+this.attack);
        System.out.println("Special Attack: "+this.specialAttack);
        System.out.println("Special Defense: "+this.specialDefense);
        System.out.println("Speed: "+this.speed);
    }
}
