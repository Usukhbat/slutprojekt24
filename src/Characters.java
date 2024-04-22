import java.util.Random;

public class Characters {
    private final String name;
    private int health;
    private final int attack;
    private final int defense;
    private final int specialAttack;
    private final int specialDefense;
    private final int speed;
    public Characters(String name, int health, int attack, int defense, int specialAttack, int specialDefense, int speed){
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
    }
    public String getName(){ return name; }
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
        System.out.println("Defense: "+this.defense);
        System.out.println("Special Attack: "+this.specialAttack);
        System.out.println("Special Defense: "+this.specialDefense);
        System.out.println("Speed: "+this.speed);
    }
    public void dealDamage(String name, int damage, int value){
        int totalDamage = damage+value;
        this.health = this.health-totalDamage;
        System.out.println(name+" dealt -"+totalDamage);
    }
    public void currentMatch(String playerName, int playerHealth, String enemyName, int enemyHealth){
        System.out.println(playerName+": "+playerHealth);
        System.out.println(enemyName+": "+enemyHealth);
    }
    public void matchEnd(int report){
        if (report == 1 || report == 2) {
            System.out.println(this.name + " won!");
        }
    }
    public int winCondition(int playerHealth, int enemyHealth) {
        int message = 0;
        if (playerHealth <= 0 && enemyHealth >= 0) {
            message = 1;
        }
        if (playerHealth >= 0 && enemyHealth <= 0){
            message = 2;
        }
        return message;
    }
}