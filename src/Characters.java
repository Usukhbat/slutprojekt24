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
    public void dealDamage(String name, int damage, int value){ // the method used to calculate the amount of damage dealt, will be more complicated in the future.
        int totalDamage = damage+value;
        this.health = this.health-totalDamage;
        System.out.println(name+" dealt -"+totalDamage);
    }
    public void currentMatch(String playerName, int playerHealth, String enemyName, int enemyHealth){ // method to show current health of both fighters.
        System.out.println(playerName+": "+playerHealth);
        System.out.println(enemyName+": "+enemyHealth);
    }
    public void matchEnd(int report){  // method sends a message in case someone's health reaches zero.
        if (report == 1 || report == 2) {
            System.out.println(this.name + " won!");
        }
    }
    public int winCondition(int playerHealth, int enemyHealth) { // checks if somebody's health has reached zero or not
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