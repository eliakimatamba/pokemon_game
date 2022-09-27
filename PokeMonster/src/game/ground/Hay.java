package game.ground;

import edu.monash.fit2099.engine.positions.Ground;
import game.Element;
/**
 * hay(one of the Ground)
 * @author Yunxi Liu
 */
public class Hay extends Ground {
    /**
     * Constructor.
     */
    public Hay() {
        super(',');
        this.addCapability(Element.GRASS);
    }
}
