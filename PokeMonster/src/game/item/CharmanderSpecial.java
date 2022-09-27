package game.item;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.Weapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.AttackAction;

/**
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 * TODO: Use this class to store Pokemon's weapons (special attack) permanently.
 * If a Pokemon needs to use a weapon, put it into that Pokemon's inventory.
 * @see Actor#getWeapon() method.
 * @see AttackAction uses getWeapon() in the execute() method.
 */
public final class CharmanderSpecial extends WeaponItem implements Weapon {


    /**
     * Constructor.
     *
     * @param name        name of the item
     * @param displayChar character to use for display when item is on the ground
     * @param damage      amount of damage this weapon does
     * @param verb        verb to use for this weapon, e.g. "hits", "zaps"
     * @param hitRate     the probability/chance to hit the target.
     */
    public CharmanderSpecial(String name, char displayChar, int damage, String verb, int hitRate) {

        super("Ember", 'E', 20, "Sparks", 90);

       // super("Bubble",'>',25,"burbles",80);

    }




}
