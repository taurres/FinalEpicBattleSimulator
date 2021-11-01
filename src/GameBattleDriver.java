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





