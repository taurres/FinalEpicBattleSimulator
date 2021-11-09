import java.util.ArrayList;
import java.util.Random;

//Game driver
//Notice it's the only class declared as public.
public class GameBattleDriver
{
    public static void main(String [] args)
    {
        Character hero1 = new Character("Random rookie", 10, 10, 20);
        Character hero2 = new Character("Mysterious transfer student ", 20, 15, 10);
        Character hero3 = new Character("Elf prince",15,50, 5);
        
        Character badguy1 = new Character("Zombie Kiki", 30, 30, 20);
        Character badguy2 = new Character("Slime Coco", 60, 10, 10);
        Character badguy3 = new Character("Goblin Hehe", 90, 30, 5);
        
      

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

        BattleArena.fight(theHero, theBadGuy);

        /*
        Character m1 = new Character("m",100,50,60);
        Weapon sword = new Melee("Sword",100,20);
        System.out.println(sword.specialAttack());
        */
    }
}




