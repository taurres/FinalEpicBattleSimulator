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
    private Ability ability;
    private int mana;
    public static int numChars = 0;

    /**
     * Construct a character object
     * Initializing all variables other than alive, Weapon, Ability
     * Set alive to be true
     * @param name - characters name
     * @param hitPoints - initial set of hitPoints for our character
     * @param strength - initial strength of our character.
     */
    public Character(String name, int hitPoints, int strength, int mana) {
        numChars++;
        alive = true;
        this.name=name;
        this.hitPoints=hitPoints;
        this.strength=strength;
        this.mana = mana;
    }

    /**
     * Construct a character object
     * Initializing all variables other than alive and set alive to be true
     * @param name - characters name
     * @param hitPoints - initial set of hitPoints for our character
     * @param strength - initial strength of our character.
     */
    public Character(String name, int hitPoints, int strength, int mana, Weapon weapon, Ability ability) {
        numChars++;
        alive = true;
        this.name=name;
        this.hitPoints=hitPoints;
        this.strength=strength;
        this.weapon = weapon;
        this.ability = ability;
        this.mana = mana;
    }

    public int attack() {
        Random random = new Random();
        return random.nextInt(strength);
    }

    public int attackWithWeapon() {
        Random random = new Random();
        return random.nextInt(strength) + this.weapon.normalAttack();
    }

    public int specAttackWithWeapon(){
        Random random = new Random();
        return random.nextInt(strength) + this.weapon.specialAttack();
    }

    public void AttackWithAbility(){
        this.ability.executeAbility();
    }

    public void speakRandomPhrases(){
        Random random = new Random();
        int index = random.nextInt(3)+1;
        switch(index){
            case 1: System.out.println("You are a bad guy");
            case 2: System.out.println("Oops!");
            case 3: System.out.println("I will kill you!");
        }
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
        return "name : " + name + "\nHit Points : " +  hitPoints + "\nMana : " + mana
                + "\nStrength : " + strength
                + "\nis alive : " + alive + "\nWeapon : " + weapon;
    }

    //getters and setters
    public String getName(){return name;}
    public int getHitPoints(){return hitPoints;}
    public int getStrength(){return strength;}
    public Weapon getWeapon(){return weapon;}
    public int getMana(){return mana;}

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
        if (weapon instanceof Magic) {
            ((Magic) weapon).connectWithOwner(this);
        }
    }

    public void setAlive(boolean alive) {this.alive = alive;}
    public void setAbility(Ability ability){this.ability = ability;}


    /**
     * Basic setter for hitPoints
     * Assigns new value to character hitPoints
     * @param hitPoints - the hit points of the character
     */
    public void setHitPoints(int hitPoints) {
        if (hitPoints <=0) {
            this.hitPoints = 0;
            alive = false;
        } else {
            this.hitPoints=hitPoints;
        }
    }

    /**
     * Basic setter for mana
     * Assigns new value to character mana
     * @param mana - the mana of the character
     */
    public void setMana(int mana) {
        if (mana <=0) {
            this.mana = 0;
        } else {
            this.mana = mana;
        }
    }
}
