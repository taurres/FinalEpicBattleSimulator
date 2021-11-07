/**
 Battle Arena class object
 Facilitates an epic battle between two character class objects
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BattleArena
{

    Character hero1 = new Character("Random rookie", 10, 10);
    Character hero2 = new Character("Mysterious transfer student ", 20, 15);
    Character hero3 = new Character("Elf prince",15,50);
    
    Character badguy1 = new Character("Zombie Kiki", 10, 30);
    Character badguy2 = new Character("Slime Coco", 30, 10);
    Character badguy3 = new Character("Goblin Hehe", 30, 30);
    
  

    // creating an ArrayList for heros
    ArrayList heros = new ArrayList();  
    heros.add(hero1);
    heros.add(hero2);
    heros.add(hero3);
 // creating an ArrayList for badguys
    ArrayList badguys = new ArrayList();
    badguys.add(badguy1);
    badguys.add(badguy2);
    badguys.add(badguy3);


    Random rand1 = new Random();
    int index1 = rand1.nextInt(3);
    Character theHero = (Character) heros.get(index1);
    
    Random rand2 = new Random();
    int index2 = rand1.nextInt(3);
    Character theBadGuy = (Character) badguys.get(index2);

    
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
        if(selectedWeapon=="A") {
        	//TODO How to set Weapon?
        	theHero.setWeapon(knuckles);
        }
        else if(selectedWeapon=="B") {
        	theHero.setWeapon(bow);
        }
        else if(selectedWeapon=="C") {
        	theHero.setWeapon(fireBall);
        }
        
        //Main game loop
        while(theHero.isAlive() && theBadGuy.isAlive())
        {
        	Scanner sc1 = new Scanner(System.in); 
            System.out.println("It's your turn!"+ "\n"+"Select: A.attack B.attack with equipped weapon C.special attack with weapon D.ability");
            String selectedAttack = sc1.nextLine(); 

            if(selectedAttack=="A") {
            	//TODO create weapon examples in driver(?)
                damage = theHero.attack();
            }
            else if(selectedAttack=="B") {
            	damage = theHero.attackWithWeapon();
            }
            else if(selectedAttack=="C") {
            	damage = theHero.specAttackWithWeapon();
            }
            else if(selectedAttack=="D") {
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
