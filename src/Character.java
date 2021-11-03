import java.util.List;
import java.util.Random;

/**
 * Character class
 * Generic RPG Character
 */
public class Character
{
    private String name;
    private int hitPoints;
    private int strength;
    private boolean alive;
    private Weapon w1;
    /**
     * A character can have more than one abilities
     */
    private List<Ability> abilities;

    public static int numChars = 0;

    /**
     * Construct a character object initializing all variables other than alive and set alive to be true
     * @param name - characters name
     * @param hitPoints - initial set of hitPoints for our character
     * @param strength - initial strength of our character.
     */
    public Character(String name, int hitPoints, int strength)
    {
        numChars++;
        alive = true;
        this.name=name;
        this.hitPoints=hitPoints;
        this.strength=strength;

    }

    public void setWeapon(Weapon w1)
    {
        this.w1 = w1;
    }

    //Example of method override
    //Over riding the toString method in Object
    @Override
    public String toString()
    {
        return "name : " + name + "\nHit Poist : " +  hitPoints + "\nStrenght :" + strength;
    }

    //These two attack methods are an example of method overloading....
    public int attack()
    {
        Random r1 = new Random();

        /*TODO update this function to add the weapon attack*/
        /*TODO make sure weapon doesn't equal null before adding it*/
        return r1.nextInt(strength);
        //return r1.nextInt(strength) + w1.attack();
    }

    public int attack(int strength)
    {
        Random r1 = new Random();

        return r1.nextInt(strength);
    }

    public void takeDamage(int damage)
    {
        setHitPoints(hitPoints - damage);
    }

    /**
     * Basic setter for hitPoints
     * Assigns new value to character hitPoints
     * @param hitPoints
     */
    public void setHitPoints(int hitPoints)
    {
        if (hitPoints <=0)
        {
            this.hitPoints = 0;
            alive = false;
        }
        else
        {
            this.hitPoints=hitPoints;
        }
    }

    //The minimum getters needed for this to work skipping documentation for this.
    public String getName(){return name;}
    public int getHitPoints(){return hitPoints;}
    public int getStrength(){return strength;}

    /**
     * Return the value of the alive status variable
     * Allows outside objects to determine if current character is alive
     * @return value of alive status variable
     */
    public boolean isAlive(){return alive;}

    public void setAlive() {
        //TODO implement setAlive method

    }

    /*TODO Add a toString overload for character and test*/
}
