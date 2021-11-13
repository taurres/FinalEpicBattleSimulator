import java.util.Random;

public abstract class Weapon {
    private String name;
    private int strength;
    private int durability;
    protected WeaponType type;

    /**
     * Abstract weapon constructor.
     *
     * @param name name of the weapon.
     * @param strength strength of the weapon.
     * @param durability durability of the weapon.
     */
    public Weapon(String name, int strength, int durability) {
        this.name = name;
        this.strength = strength;
        this.durability = durability;
    }

    /**
     * Weapon's normal attack method.
     *
     * @return normal damage created.
     */
    public abstract int normalAttack();

    /**
     * Weapon's special attack method
     * @return special damage created.
     */
    public abstract int specialAttack();

    /**
     * Getter of durability.
     * @return weapon's durability.
     */
    public int getDurability() {
        return this.durability;
    }

    /**
     * Getter of strength.
     * @return weapon's strength.
     */
    public int getStrength() {
        return strength;
    }

    /**
     * Reduce the durability.
     * @param cost the amount of durability to be deducted.
     */
    public void reduceDurability(double cost) {
        this.durability -= cost;
    }

    /**
     * toString() method of the weapon.
     * @return information of the weapon.
     */
    @Override
    public String toString() {
        return "name: " + this.name + "; damage: " + this.strength + "; durability: " + this.durability;
    }
}

class Melee extends Weapon {

    private int meleeCost = 1;
    private int meleeSpecialCost = 4;

    /**
     * Melee constructor.
     *
     * @param name name of Melee.
     * @param strength strength of Melee.
     * @param durability durability of Melee.
     */
    public Melee(String name, int strength, int durability) {
        super(name, strength, durability);
        this.type = WeaponType.Melee;

    }

    /**
     * Melee normal attack method.
     *
     * @return amount of damage.
     */
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

    /**
     * Melee special attack method.
     *
     * @return amount of special damage.
     */
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

    /**
     * Ranged constructor.
     *
     * @param name name of Ranged.
     * @param strength strength of Ranged.
     * @param durability durability of Ranged.
     */
    public Ranged(String name, int strength, int durability) {
        super(name, strength, durability);
        this.type = WeaponType.Ranged;
    }

    /**
     * Ranged normal attack method.
     *
     * @return amount of damage.
     */
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

    /**
     * Ranged special attack method.
     *
     * @return amount of special damage.
     */
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

    /**
     * Magic constructor.
     *
     * @param name name of Magic.
     * @param strength strength of Magic.
     * @param durability durability of Magic.
     */
    public Magic(String name, int strength, int durability) {
        super(name, strength, durability);
        this.type = WeaponType.Magic;
    }

    /**
     * Connect Magic weapon with its owner.
     *
     * @param p the character owns this Magic weapon.
     */
    public void connectWithOwner(Character p) {
        this.owner = p;
    }


    /**
     * Helper method that could get the owner's mana.
     *
     * @return owner's mana amount.
     */
    private int getOwnerMana() {
        return this.owner.getMana();
    }

    /**
     * Helper method that could reduce the owner's mana.
     *
     * @param cost the amount of mana to be deducted.
     */
    private void reduceMana(int cost) {
        if (this.owner.getMana() > 0) {
            this.owner.setMana(this.owner.getMana() - cost);
        } else {
            this.owner.setMana(0);
        }
    }


    /**
     * Magic normal attack method.
     *
     * @return amount of damage.
     */
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

    /**
     * Magic special attack method.
     *
     * @return amount of special damage.
     */
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
