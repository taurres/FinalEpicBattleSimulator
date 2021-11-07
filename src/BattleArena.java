/**
 Battle Arena class object
 Facilitates an epic battle between two character class objects
 */
import java.util.Scanner;

public class BattleArena
{
    private Character c1;
    private Character c2;

    
    
    public BattleArena(Character c1, Character c2)
    {
        this.c1=c1;
        this.c2=c2;
    }

    /**
     * Epic battle between two characters
     * Method internal to class object
     */
    public static void fight(Character c1, Character c2)
    {
        System.out.println("Welcome to the Arena!");
        System.out.println("Today " + c1.getName() + " will battle against " + c2.getName() + "!\n");
        System.out.println("The hero " + c1.toString() + ".\n");
        System.out.println("The bad guy " + c2.toString() + ".\n");
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
        if(selectedWeapon=="A") {
        	//TODO How to set Weapon?
        	c1.setWeapon(knuckles);
        }
        else if(selectedWeapon=="B") {
        	c1.setWeapon(bow);
        }
        else if(selectedWeapon=="C") {
        	c1.setWeapon(fireBall);
        }
        
        //Main game loop
        while(c1.isAlive() && c2.isAlive())
        {
        	Scanner sc1 = new Scanner(System.in); 
            System.out.println("It's your turn!"+ "\n"+"Select: A.attack B.attack with equipped weapon C.special attack with weapon D.ability");
            String selectedAttack = sc1.nextLine(); 

            if(selectedAttack=="A") {
            	//TODO create weapon examples in driver(?)
                damage = c1.attack();
            }
            else if(selectedAttack=="B") {
            	damage = c1.attackWithWeapon();
            }
            else if(selectedAttack=="C") {
            	damage = c1.specAttackWithWeapon();
            }
            else if(selectedAttack=="D") {
            	damage = c1.AttackWithAbility();
            }
            
            System.out.println(c1.getName() + " hits " + c2.getName() + " for " + damage);
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
            	//TODO Need to revise the random phrases method.
            	c2.speakRandomPhrases();
                damage = c2.attack();
                System.out.println(c2.getName() + " hits " + c1.getName() + " for " + damage);
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
