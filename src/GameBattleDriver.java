/**
 * Battle Arena
 * Goals: Demonstrate how class can be within one file;
 * explore toString() overrides; show last ICE's solution;
 * further discuss the concept of objects
 * Demonstrate the TODO tag
 * To generate the to do list go to : Window -> Show View -> Tasks
 *
 * Author : Dr. G
 * Date : 5/13/21
 */




import java.util.Random;

//Game driver
//Notice it's the only class declared as public.
public class GameBattleDriver
{
    public static void main(String [] args)
    {

        Character hero = new Character("Sparhawk", 40, 10);
        //System.out.println(Character.numChars);

        Character badguy = new Character("Gwerg", 100, 3);
        //System.out.println(Character.numChars);

        Character hero2 = new Character("Sparhawk", 40, 10);
        //System.out.println(Character.numChars);

        //BattleArena b1 = new BattleArena(hero, badguy);
        //b1.fight();

        BattleArena.fight(hero, badguy);

        //System.out.println(hero.attack());
        //System.out.println(hero.attack(45));

        //System.out.println(hero);
        //System.out.println(hero.toString());

        /*TODO Create a weapon and "give it" to the hero to use*/
        /*TODO Add some print statements to print the weapon that was given to the hero*/

    }
}

/**
 * Character class
 * Generic RPG Character
 */
class Character
{
    private String name;
    private int hitPoints;
    private int strength;
    private boolean alive;
    private Weapon w1;

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

    /*TODO Add a toString overload for character and test*/
}

/**
 Battle Arena class object
 Facilitates an epic battle between two character class objects
 */
class BattleArena
{
    private Character c1;
    private Character c2;

    public BattleArena(Character c1, Character c2)
    {
        this.c1=c1;
        this.c2=c2;

        /*TODO Make the call to this manual instead of having it run by the constructor*/
        //fight();
    }

    /**
     * Epic battle between two characters
     * Method internal to class object
     */
    public static void fight(Character c1, Character c2)
    {
        int damage = 0;
        //Random r1 = new Random();

        //Main game loop
        while(c1.isAlive() && c2.isAlive())
        {

            //damage = r1.nextInt(c1.getStrength());

            damage = c1.attack();
            System.out.println(c1.getName() + " hits " + c2.getName() + " for " + damage);
            //c2.setHitPoints(c2.getHitPoints()-damage);
            c2.takeDamage(damage);

            //Pause for 2 seconds to add some suspense
            //This is an example of a checked exception. It won't work without it...
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //Don't do damage if 2nd combatant was killed
            if (c2.isAlive())
            {
                //damage = r1.nextInt(c2.getStrength());
                damage = c2.attack();
                System.out.println(c2.getName() + " hits " + c1.getName() + " for " + damage);
                //c1.setHitPoints(c1.getHitPoints() - damage);
                c1.takeDamage(damage);
            }
        }

        System.out.print("Our winner is : " );

        //Report the winner
        if (c1.isAlive())
            System.out.println(c1.getName());
        else
        if (c2.isAlive())
            System.out.println(c2.getName());
    }

}

class Weapon
{

    private String name;
    private int strength;
    private int durability;

    /*TODO add no argument constructor constructor*/
    /*TODO add three argument constructor*/
    /*TODO create an attack method that returns a random value from 1 to weapon's strength and deducts 1 from durability*/
    /*TODO in the attack method if durability is 0 return 0*/
    /*TODO create a toString override*/

}


/*TODO Add one creative element all your own*/