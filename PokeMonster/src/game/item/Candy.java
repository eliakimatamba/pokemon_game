package game.item;

import edu.monash.fit2099.engine.items.Item;
import game.Status;

/**
 * class for candy objects in REQ3, will use to trade with nurse joy for items.
 * @author Zhewen Zhu
 */
public class Candy extends Item {
    /***
     * Constructor.
     */
    public Candy() {
        super("Candy", '*', true);
        this.addCapability(Status.CANDY);
    }
}
