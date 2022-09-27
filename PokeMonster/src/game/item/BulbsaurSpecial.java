package game.item;

import edu.monash.fit2099.engine.weapons.Weapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;

public class BulbsaurSpecial extends WeaponItem implements Weapon {
    /**
     * Constructor.
     *
     * @param name        name of the item
     * @param displayChar character to use for display when item is on the ground
     * @param damage      amount of damage this weapon does
     * @param verb        verb to use for this weapon, e.g. "hits", "zaps"
     * @param hitRate     the probability/chance to hit the target.
     */
    public BulbsaurSpecial(String name, char displayChar, int damage, String verb, int hitRate) {
        super("Vine whip", '/', 30, "whips", 70);
    }
}
