package game.item.pokefruit;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.Element;

/**
 * class for water Pokefruit, extended from Pokefruit class.
 * @author Zhewen Zhu
 */
public class WaterPokefruit extends Pokefruit{
    /***
     * Constructor.
     */
    public WaterPokefruit() {
        super("Water Pokefruit", 'f', true, Element.WATER);
        this.addCapability(Element.WATER);
    }

    @Override
    public int price() {
        return 1;
    }

    @Override
    public String name() {
        return "Water Pokefruit";
    }

    @Override
    public void transaction(Actor actor) {
        actor.addItemToInventory(this);
    }
}
