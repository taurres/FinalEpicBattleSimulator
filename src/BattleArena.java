/**
 Battle Arena class object
 Facilitates an epic battle between two character class objects
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class BattleArena
{  
	private static List<Character> heroList = new ArrayList<Character>();
	private static List<Character> badGuyList = new ArrayList<Character>();
	//private static List<Weapon> weaponRack = new ArrayList<Weapon>();
	private static int round = 0;
	private static  int index1;
	private static  int index2;
    private Character theHero;
	private Character theBadGuy;

	//public BattleArena(Character theHero, Character theBadGuy)
    //{
        //this.theHero=theHero;
        //this.theBadGuy=theBadGuy;
    //}
	
	 
     
   
public static void start() {
	
	Character hero1 = new Character("Random rookie", 10, 10, 20);
    Character hero2 = new Character("Mysterious transfer student ", 20, 15, 10);
    Character hero3 = new Character("Elf prince",15,50, 5);
    
    Character badguy1 = new Character("Zombie Kiki", 30, 30, 20);
    Character badguy2 = new Character("Slime Coco", 60, 10, 10);
    Character badguy3 = new Character("Goblin Hehe", 90, 30, 5);
      
 // creating an ArrayList for heros

    heroList.add(hero1);
    heroList.add(hero2);
    heroList.add(hero3);
 // creating an ArrayList for badguys

    badGuyList.add(badguy1);
    badGuyList.add(badguy2);
    badGuyList.add(badguy3);
    

    
    
 // Repeat this process until all the bad guys or all of the heroes are defeated.
 		while (heroList.size() > 0 && badGuyList.size() > 0) {
 			round++;
 			//weaponRack.clear();
 			Random rand1 = new Random();
 			int index1 = rand1.nextInt(heroList.size());
 			Character theHero = (Character) heroList.get(index1);
 			
 			
 			 Random rand2 = new Random();
 			int index2 =  rand2.nextInt(badGuyList.size());
 			Character theBadGuy = (Character) badGuyList.get(index2);
 			
 			
 // call the fight method and passed in the selected hero and bad guy to start a battle
 			System.out.println("-------\nRound " + round + "! \n-------");
 			fight(theHero, theBadGuy);
 		}

 		if (heroList.isEmpty()) {
 			System.out.println("\nGame Over...\nThe Bad Guy Wins");
 		} else if (badGuyList.isEmpty()){
 			System.out.println("\nGame Over!\n The Hero Wins!");
 		}
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
        Melee knuckles = new Melee("diamond knuckles",3,40);
        Ranged bow = new Ranged("clockwork bow",4,60);
        Magic fireBall = new Magic("fireball",6,99);

        Scanner sc = new Scanner(System.in); 
        System.out.println("Choose a weapon for your hero: " + "\n" 
        +"A.Melee:knuckles"+ "\n"+"B.Ranged:clockwork bow"+ "\n"+"C.Magic:fireball"+"\n");
        String selectedWeapon = sc.nextLine();

        // Check if input is in [A,B,C].
        if (selectedWeapon.length() == 1 && java.lang.Character.isLetter(selectedWeapon.charAt(0))) {
            selectedWeapon = selectedWeapon.toUpperCase();
        }else {
            throw new RuntimeException("Input should be A or B or C.");
        }

        List<String> weaponOptionPool = Stream.of("A","B","C").collect(Collectors.toList());
        if (!weaponOptionPool.contains(selectedWeapon)) {
            throw new RuntimeException("Input should be A or B or C.");
        }

        if(selectedWeapon.equals("A")) {
        	theHero.setWeapon(knuckles);

        }
        else if(selectedWeapon.equals("B")) {
        	theHero.setWeapon(bow);
        }
        else if(selectedWeapon.equals("C")) {
        	theHero.setWeapon(fireBall);
        }

        System.out.println("Weapon: "+theHero.getWeapon());
        //Main game loop
        while(theHero.isAlive() && theBadGuy.isAlive())
        {
            theHero.reportStatus();
            theBadGuy.reportStatus();

        	Scanner sc1 = new Scanner(System.in); 
            System.out.println("It's your turn!"+ "\n"+"Select: A.attack B.attack with equipped weapon C.special attack with weapon D.ability");
            String selectedAttack = sc1.nextLine();

            // Check if input is in [A,B,C,D].
            if (selectedAttack.length() == 1 && java.lang.Character.isLetter(selectedAttack.charAt(0))) {
                selectedAttack = selectedAttack.toUpperCase();
            }else {
                throw new RuntimeException("Input should be A or B or C or D.");
            }

            List<String> attackOptionPool = Stream.of("A","B","C","D").collect(Collectors.toList());
            if (!attackOptionPool.contains(selectedAttack)) {
                throw new RuntimeException("Input should be A or B or C or D.");
            }

            if(selectedAttack.equals("A")) {
            	
                damage = theHero.attack();
            }
            else if(selectedAttack.equals("B")){
            	damage = theHero.attackWithWeapon();
            }
            else if(selectedAttack.equals("C")) {
            	damage = theHero.specAttackWithWeapon();
            }
            else if(selectedAttack.equals("D")) {
                System.out.println("Choose an ability to your hero!");
                System.out.println("1. Reborn gives you a second chance. Unless you don't need it :D");
                System.out.println("2. Refresh gives you a huge amount of hit points and mana.");
                String selectedAbility = sc1.nextLine();

                List<String> abilityOptionPool = Stream.of("1","2").collect(Collectors.toList());
                if (!abilityOptionPool.contains(selectedAbility)) {
                    throw new RuntimeException("Input should be 1 or 2.");
                }

                if (selectedAbility.equals("1")) {
                    new Reborn(theHero);
                }
                else if (selectedAbility.equals("2")) {
                    new Refresh(theHero);
                }
            	theHero.useAbility();
            }
            
            System.out.println(theHero.getName() + " hits " + theBadGuy.getName() + " for " + damage);
            theBadGuy.takeDamage(damage);

            //Pause for 1 seconds to add some suspense
            //This is an example of a checked exception. It won't work without it...
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //Don't do damage if 2nd combatant was killed
            if (theBadGuy.isAlive())
            {
            	//TODO Need to revise the random phrases method.
            	System.out.println(theBadGuy.getName() + " :  " );
            	theBadGuy.speakRandomPhrases();
                damage = theBadGuy.attack();
                System.out.println(theBadGuy.getName() + " hits " + theHero.getName() + " for " + damage);
                theHero.takeDamage(damage);
            }
        }



        //Report the winner
        if (theHero.isAlive()) {
        	System.out.println(theBadGuy.getName() + " Died. " + theHero.getName() + " Wins!!");
		badGuyList.remove(theBadGuy);}
            
        else if (theBadGuy.isAlive()) {
            System.out.println(theHero.getName() + " Died. " + theBadGuy.getName() + " Wins!!");
            heroList.remove(theHero);}
    }

}
