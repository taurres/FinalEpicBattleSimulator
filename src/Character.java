/**
 * @author: Jie Chen, Jiaxi Wen, LaiYun Choi, Yilin Zhou
 * Character class
 * Generic RPG Character
 */

import java.util.Random;

public class Character {
    private String name;
    private int hitPoints;
    private int strength;
    private boolean alive;
    private Weapon weapon;
    private Ability ability;
    private int mana;
    public static int numChars = 0;


    /**
     * Construct a character object
     * Initializing all variables other than alive, Weapon, Ability
     * Set alive to be true
     *
     * @param name      - characters name
     * @param hitPoints - initial set of hitPoints for our character
     * @param strength  - initial strength of our character.
     */
    public Character(String name, int hitPoints, int strength, int mana) {
        numChars++;
        alive = true;
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
        this.mana = mana;
    }

    /**
     * Construct a character object
     * Initializing all variables other than alive and set alive to be true
     *
     * @param name      - characters name
     * @param hitPoints - initial set of hitPoints for our character
     * @param strength  - initial strength of our character.
     */
    public Character(String name, int hitPoints, int strength, int mana, Weapon weapon, Ability ability) {
        numChars++;
        alive = true;
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
        this.weapon = weapon;
        this.ability = ability;
        this.mana = mana;
    }

    /**
     * This is the normal attack method
     *
     * @return the normal attack damage
     */
    public int attack() {
        Random random = new Random();
        return random.nextInt(strength);
    }

    /**
     * This is the attack with weapon method
     *
     * @return the attack with weapon damage
     */
    public int attackWithWeapon() {
        Random random = new Random();
        return random.nextInt(strength) + this.weapon.normalAttack();
    }

    /**
     * This is the special attack with weapon method
     *
     * @return the special attack with weapon damage
     */
    public int specAttackWithWeapon() {
        Random random = new Random();
        return random.nextInt(strength) + this.weapon.specialAttack();
    }

    /**
     * This is the method to use ability
     */
    public void useAbility() {
        if (this.ability == null) {
            System.out.println("There is no ability to use!");
        } else {
            this.ability.executeAbility();
            if (this.ability.getDurability() == 0) {
                this.ability = null;
            }
        }
    }

    /**
     * This is the method to speak random phrases
     */
    public void speakRandomPhrases() {
        Random random = new Random();
        int index = random.nextInt(3) + 1;
        switch (index) {
            case 1:
                System.out.println("You are a bad guy");
            case 2:
                System.out.println("Oops!");
            case 3:
                System.out.println("I will kill you!");
        }
    }

    /**
     * This is the method to take damage
     * Hit points will minus the damage
     */
    public void takeDamage(int damage) {
        setHitPoints(hitPoints - damage);
    }

    /**
     * Return the value of the alive status variable
     * Allows outside objects to determine if current character is alive
     *
     * @return value of alive status variable
     */
    public boolean isAlive() {
        return alive;
    }

    @Override
    public String toString() {
        return "name : " + name + "\nHit Points : " + hitPoints + "\nMana : " + mana
                + "\nStrength : " + strength
                + "\nis alive : " + alive + "\nWeapon : " + weapon;
    }

    /**
     * The getter for name
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * The getter for hit points
     *
     * @return the hit points
     */
    public int getHitPoints() {
        return hitPoints;
    }

    /**
     * The getter for strength
     *
     * @return the strength
     */
    public int getStrength() {
        return strength;
    }

    /**
     * The getter for weapon
     *
     * @return the weapon
     */
    public Weapon getWeapon() {
        return weapon;
    }

    /**
     * The getter for mana
     *
     * @return the mana
     */
    public int getMana() {
        return mana;
    }

    /**
     * The setter for weapon
     */
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
        if (weapon instanceof Magic) {
            ((Magic) weapon).connectWithOwner(this);
        }
    }

    /**
     * The setter for name
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    /**
     * The setter for ability
     */
    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    /**
     * Basic setter for hitPoints
     * Assigns new value to character hitPoints
     *
     * @param hitPoints - the hit points of the character
     */
    public void setHitPoints(int hitPoints) {
        if (hitPoints <= 0) {
            this.hitPoints = 0;
            this.alive = false;
            if (this.ability != null && this.ability.getClass().equals(Reborn.class)) {
                useAbility();
            }
        } else {
            this.hitPoints = hitPoints;
        }
    }

    /**
     * Basic setter for mana
     * Assigns new value to character mana
     *
     * @param mana - the mana of the character
     */
    public void setMana(int mana) {
        if (mana <= 0) {
            this.mana = 0;
        } else {
            this.mana = mana;
        }
    }

    public void reportStatus() {
        System.out.println(this.getName() + " has HitPoints:" + this.getHitPoints() + "  Mana:" + this.getMana());
    }
}
