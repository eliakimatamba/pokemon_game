package game.item.pokefruit;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.Element;

/**
 * class for grass Pokefruit, extended from Pokefruit class.
 * @author Zhewen Zhu
 */
public class GrassPokefruit extends Pokefruit{
    /***
     * Constructor.
     */
    public GrassPokefruit() {
        super("Grass Pokefruit", 'f', true, Element.GRASS);
        this.addCapability(Element.GRASS);
    }

    @Override
    public int price() {
        return 1;
    }

    @Override
    public String name() {
        return "Grass Pokefruit";
    }

    @Override
    public void transaction(Actor actor) {
        actor.addItemToInventory(this);
    }
}
