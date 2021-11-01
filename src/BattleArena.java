/**
 Battle Arena class object
 Facilitates an epic battle between two character class objects
 */
public class BattleArena
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
