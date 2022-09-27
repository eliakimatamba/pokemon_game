package game.item.pokefruit;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Element;
import game.TradeableItem;

/**
 * class for fire Pokefruit, extended from Pokefruit class.
 * @author Zhewen Zhu
 */
public class FirePokefruit extends Pokefruit implements TradeableItem {
    /***
     * Constructor.
     */
    public FirePokefruit() {
        super("Fire Pokefruit", 'f', true, Element.FIRE);
        this.addCapability(Element.FIRE);
    }

    @Override
    public int price() {
        return 1;
    }

    @Override
    public String name() {
        return "Fire Pokefruit";
    }

    @Override
    public void transaction(Actor actor) {
        actor.addItemToInventory(this);
    }

}
