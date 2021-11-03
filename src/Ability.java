import java.util.Random;

/**
 * We creatively add a Skill element to the hero Character.
 * Player can select a skill for the character each round.
 */
public abstract class Ability {

    protected Character character;

    /**
     * Generic method to execute the specific ability.
     * @return
     */
    public abstract int executeAbility();
}

/**
 * Reborn ability can refresh the hitpoint of a character if the character is dead
 */
class Reborn extends Ability {

    private int durability;

    public Reborn(Character character) {
        this.durability = 1;
    }

    /**
     * refresh random hitpoint, at most character's stregth
     */
    private void reborn() {
        if (this.durability > 0) {
            Random random = new Random();
            this.durability -= 1;
            // set hit points based on the character's strength
            character.setHitPoints(random.nextInt(character.getStrength()));
            character.setAlive();
            System.out.printf("%s refresh hitpoint to %d\n", character.getName(), character.getHitPoints());
        }
    }

    @Override
    public int executeAbility() {
        try {
            reborn();
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }
}
