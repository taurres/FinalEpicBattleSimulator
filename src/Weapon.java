import java.util.Random;

public abstract class Weapon {
    private String name;
    private int strength;
    private int durability;
    protected WeaponType type;

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
/*
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
    }*/

    public abstract int normalAttack();

    public abstract int specialAttack();

    public int getDurability() {
        return this.durability;
    }

    public int getStrength() {
        return strength;
    }

    public void reduceDurability(double cost) {
        this.durability -= cost;
    }

    @Override
    public String toString() {
        return "name: " + this.name + "; damage: " + this.strength + "; durability: " + this.durability;
    }
}

class Melee extends Weapon {

    private int meleeCost = 1;
    private int meleeSpecialCost = 4;

    public Melee(String name, int strength, int durability) {
        super(name, strength, durability);
        this.type = WeaponType.Melee;

    }

    @Override
    public int normalAttack() {
        if (this.getDurability() > 0) {
            Random r1 = new Random();
            this.reduceDurability(meleeCost);
            return 1 + r1.nextInt(this.getStrength() - 1);
        } else {
            return 0;
        }
    }

    @Override
    public int specialAttack() {
        if (this.getDurability() > 0) {
            Random r1 = new Random();
            this.reduceDurability(meleeSpecialCost);
            return this.getStrength() * 2;
        } else {
            return 0;
        }
    }
}

class Ranged extends Weapon {

    private int rangedCost = 1;
    private int rangedSpecialCost = 4;

    public Ranged(String name, int strength, int durability) {
        super(name, strength, durability);
        this.type = WeaponType.Ranged;
    }

    @Override
    public int normalAttack() {
        if (this.getDurability() > 0) {
            Random r1 = new Random();
            this.reduceDurability(rangedCost);
            return 1 + r1.nextInt(this.getStrength() - 1);
        } else {
            return 0;
        }
    }

    @Override
    public int specialAttack() {
        if (this.getDurability() > 0) {
            Random r1 = new Random();
            this.reduceDurability(rangedSpecialCost);
            return r1.nextInt(this.getStrength() * 3);
        } else {
            return 0;
        }
    }

}

class Magic extends Weapon {

    private double magicCost = 0.5;
    private double magicSpecialCost = 0.5;

    private int manaCost = 1;
    private int manaSpecialCost = 4;

    private Character owner;

    public Magic(String name, int strength, int durability) {
        super(name, strength, durability);
        this.type = WeaponType.Magic;
    }

    public void connectWithOwner(Character p) {
        this.owner = p;
    }

    //TODO: Need to setup mana in Character first, including getMana() and setMana().

    private int getOwnerMana() {
        return this.owner.getMana();
    }

    private void reduceMana(double cost) {
        if (this.owner.getMana() > 0) {
            this.owner.setMana(this.owner.getMana() - cost);
        } else {
            this.owner.setMana(0);
        }
    }


    @Override
    public int normalAttack() {
        if (this.getDurability() > 0) {
            if (getOwnerMana() > 0) {
                Random r1 = new Random();
                this.reduceDurability(magicCost);
                this.reduceMana(manaCost);
                return 1 + r1.nextInt(this.getStrength() - 1);
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    @Override
    public int specialAttack() {
        if (this.getDurability() > 0) {
            if (getOwnerMana() > 0) {
                Random r1 = new Random();
                this.reduceDurability(magicSpecialCost);
                this.reduceMana(manaSpecialCost);
                return this.getStrength() * 2;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }


}
