import java.util.Random;

/**
 * We creatively add an Ability element to the hero Character.
 * Player can select an Ability for the character each round.
 */
public abstract class Ability {

    protected Character character;
    protected int durability;

    /**
     * Generic constructor for Ability
     * @param character character to have the ability
     */
    public Ability(Character character) {
        this.character = character;
        character.setAbility(this);
        this.durability = 1;
    }

    /**
     * Generic method to execute the specific ability.
     * @throws RuntimeException when ability execution failed
     */
    public abstract void executeAbility();

    /**
     * Get the durability of an ability.
     * @return The durability of an ability.
     */
    public int getDurability() {
        return this.durability;
    }
}

/**
 * Reborn ability can bring a character back to life if the character is dead,
 * after reborn, the character will have random hit points at the maximum of its Strength.
 */
class Reborn extends Ability {

    /**
     * Constructor for Reborn ability
     * @param character character to have the ability
     */
    public Reborn(Character character) {
        super(character);
    }

    @Override
    public void executeAbility() {
        try {
            reborn();
            System.out.println("Execute Ability Reborn successfully! I am back to life again!");
        } catch (Exception e) {
            System.out.println("Execute Ability Reborn failed!");
            System.out.println(e.getMessage());
        }
    }

    /**
     * Bring character back to life,
     * give random hit points, at most character's strength
     * @throws RuntimeException if character is alive or durability is 0.
     */
    private void reborn() throws RuntimeException {
        if (!this.character.isAlive()) {
            if (this.durability > 0) {
                Random random = new Random();
                this.durability -= 1;
                // set hit points based on the character's strength
                character.setHitPoints(random.nextInt(character.getStrength()));
                character.setAlive(true);
                System.out.printf("%s refresh hitpoint to %d\n", character.getName(), character.getHitPoints());
            } else {
                throw new RuntimeException("Durability is 0.");
            }
        } else {
            throw new RuntimeException("Character is still alive!");
        }
    }

    @Override
    public String toString() {
        return "Reborn gives you a second chance. Unless you don't need it :D";
    }
}

/**
 * Refresh ability can add a certain amount to a character's hit points and mana.
 */
class Refresh extends Ability {

    /**
     * Hit points amount to be added.
     */
    private final int ADD_HIT_POINTS = 30;

    /**
     * Mana amount to be added.
     */
    private final int ADD_MANA = 30;

    /**
     * Constructor for Refresh ability
     * @param character character to have the ability
     */
    public Refresh(Character character) {
        super(character);
    }

    @Override
    public void executeAbility() {
        try {
            refresh();
            System.out.println("Execute Ability Refresh successfully");
        } catch (Exception e) {
            System.out.println("Execute Ability Refresh failed!");
            e.printStackTrace();
        }
    }

    /**
     * Add a certain amount to the hit points and mana.
     * @throws RuntimeException if character is dead or durability is 0.
     */
    private void refresh() throws RuntimeException {
        if (character.isAlive()) {
            if (this.durability > 0) {
                this.durability -= 1;
                int curHitPoints = character.getHitPoints();
                int curMana = character.getMana();
                character.setHitPoints(curHitPoints + ADD_HIT_POINTS);
                character.setMana(curMana + ADD_MANA);
            } else {
                throw new RuntimeException("Durability is 0.");
            }
        } else {
            throw new RuntimeException("Character is dead!");
        }
    }

    @Override
    public String toString() {
        return "set";
    }
}
