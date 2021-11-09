/**
 Battle Arena class object
 Facilitates an epic battle between two character class objects
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BattleArena
{  
    private Character theHero;
	private Character theBadGuy;

	public BattleArena(Character theHero, Character theBadGuy)
    {
        this.theHero=theHero;
        this.theBadGuy=theBadGuy;
    }

    /**
     * Epic battle between two characters
     * Method internal to class object
     */
    public static void fight(Character theHero, Character theBadGuy)
    {
        System.out.println("Welcome to the Arena!");
        System.out.println("Today " + theHero.getName() + " will battle against " + theBadGuy.getName() + "!\n");
        System.out.println("The hero " + theHero.toString() + ".\n");
        System.out.println("The bad guy " + theBadGuy.toString() + ".\n");
        System.out.println("Let the battle begin...");
 
        int damage = 0;
        //Redesign the weapons later.
        Melee knuckles = new Melee("diamond knuckles",10,5);
        Ranged bow = new Ranged("clockwork bow",4,8);
        Magic fireBall = new Magic("fireball",6,99);
        
        Scanner sc = new Scanner(System.in); 
        System.out.println("Choose a weapon for your hero: " + "\n" 
        +"A.Melee:knuckles"+ "\n"+"B.Ranged:clockwork bow"+ "\n"+"C.Magic:fireball"+"\n");
        String selectedWeapon = sc.nextLine(); 
        if(selectedWeapon.equals("A")) {
        	//TODO How to set Weapon?
        	theHero.setWeapon(knuckles);
        }
        else if(selectedWeapon.equals("B")) {
        	theHero.setWeapon(bow);
        }
        else if(selectedWeapon.equals("C")) {
        	theHero.setWeapon(fireBall);
        }
        
        //Main game loop
        while(theHero.isAlive() && theBadGuy.isAlive())
        {
        	Scanner sc1 = new Scanner(System.in); 
            System.out.println("It's your turn!"+ "\n"+"Select: A.attack B.attack with equipped weapon C.special attack with weapon D.ability");
            String selectedAttack = sc1.nextLine(); 

            if(selectedAttack.equals("A")) {
            	//TODO create weapon examples in driver(?)
                damage = theHero.attack();
            }
            else if(selectedAttack.equals("B")){
            	damage = theHero.attackWithWeapon();
            }
            else if(selectedAttack.equals("C")) {
            	damage = theHero.specAttackWithWeapon();
            }
            else if(selectedAttack.equals("D")) {
            	theHero.AttackWithAbility();
            }
            
            System.out.println(theHero.getName() + " hits " + theBadGuy.getName() + " for " + damage);
            theBadGuy.takeDamage(damage);

            //Pause for 2 seconds to add some suspense
            //This is an example of a checked exception. It won't work without it...
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //Don't do damage if 2nd combatant was killed
            if (theBadGuy.isAlive())
            {
            	//TODO Need to revise the random phrases method.
            	theBadGuy.speakRandomPhrases();
                damage = theBadGuy.attack();
                System.out.println(theBadGuy.getName() + " hits " + theHero.getName() + " for " + damage);
                theHero.takeDamage(damage);
            }
        }

        System.out.print("Our winner is : " );

        //Report the winner
        if (theHero.isAlive())
            System.out.println(theHero.getName());
        else
        if (theBadGuy.isAlive())
            System.out.println(theBadGuy.getName());
    }

}
