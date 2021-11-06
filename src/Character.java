import java.util.List;
import java.util.Random;

/**
 * Character class
 * Generic RPG Character
 */
public class Character {
    private String name;
    private int hitPoints;
    private int strength;
    private boolean alive;
    private Weapon weapon;
    private List<Ability> abilities;  //A character can have more than one ability
    public static int numChars = 0;

    /**
     * Construct a character object
     * Initializing all variables other than alive, Weapon
     * Set alive to be true
     * @param name - characters name
     * @param hitPoints - initial set of hitPoints for our character
     * @param strength - initial strength of our character.
     */
    public Character(String name, int hitPoints, int strength) {
        numChars++;
        alive = true;
        this.name=name;
        this.hitPoints=hitPoints;
        this.strength=strength;
    }

    /**
     * Construct a character object
     * Initializing all variables other than alive and set alive to be true
     * @param name - characters name
     * @param hitPoints - initial set of hitPoints for our character
     * @param strength - initial strength of our character.
     */
    public Character(String name, int hitPoints, int strength, Weapon weapon) {
        numChars++;
        alive = true;
        this.name=name;
        this.hitPoints=hitPoints;
        this.strength=strength;
        this.weapon = weapon;
    }

    public int attack() {
        Random random = new Random();
        return random.nextInt(strength);
    }

    public int attackWithWeapon() {
        Random random = new Random();
        return random.nextInt(strength) + weapon.normalAttack();
    }

    public int specAttackWithWeapon(){
        Random random = new Random();
        return random.nextInt(strength) + weapon.specialAttack();
    }

    public int AttackWithAbility(){
        Random random = new Random();
        //TODO attack with ability
        return random.nextInt(strength);
    }

    public void speakRandomPhrases(){
        System.out.println("You are a bad guy!");
    }

    public void takeDamage(int damage) {
        setHitPoints(hitPoints - damage);
    }

    /**
     * Return the value of the alive status variable
     * Allows outside objects to determine if current character is alive
     * @return value of alive status variable
     */
    public boolean isAlive(){
        return alive;
    }

    @Override
    public String toString() {
        return "name : " + name + "\nHit Points : " +  hitPoints + "\nStrength : " + strength
                + "\nis alive : " + alive + "\nWeapon : " + weapon;
    }

    //getters and setters
    public String getName(){return name;}
    public int getHitPoints(){return hitPoints;}
    public int getStrength(){return strength;}
    public Weapon getWeapon(){return weapon;}
    public void setWeapon(Weapon weapon) {this.weapon = weapon;}
    public void setAlive(boolean alive) {this.alive = alive;}

    /**
     * Basic setter for hitPoints
     * Assigns new value to character hitPoints
     * @param hitPoints - hit points of the character
     */
    public void setHitPoints(int hitPoints) {
        if (hitPoints <=0) {
            this.hitPoints = 0;
            alive = false;
        } else {
            this.hitPoints=hitPoints;
        }
    }
}
