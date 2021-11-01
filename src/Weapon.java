import java.util.Random;

public class Weapon
{

    private String name;
    private int strength;
    private int durability;

    /*TODO add no argument constructor constructor*/
    /*TODO add three argument constructor*/
    /*TODO create an attack method that returns a random value from 1 to weapon's strength and deducts 1 from durability*/
    /*TODO in the attack method if durability is 0 return 0*/
    /*TODO create a toString override*/
    public Weapon() {
        this.name = "Master Sword";
        this.strength = 5;
        this.durability = 99999;
    }

    public Weapon(String name, int strength, int durability) {
        this.name = name;
        this.strength = strength;
        this.durability = durability;
    }

    public int getDamage() {
        if (this.durability > 0) {
            Random r1 = new Random();

            int doubleDamageChance = r1.nextInt(10);
            if (doubleDamageChance > 7) {
                this.durability -= 2;
                return (this.strength * 2);
            } else {
                this.durability -= 1;
                return 1 + r1.nextInt(this.strength - 1);
            }
        } else {
            this.durability = 0;
            return 0;
        }
    }

    public int getDurability() {
        return this.durability;
    }

    @Override
    public String toString() {
        return "name: " + this.name + "; damage: " + this.strength + "; durability: " + this.durability;
    }
}


/*TODO Add one creative element all your own*/