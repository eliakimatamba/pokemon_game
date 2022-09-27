package game.ground;

import edu.monash.fit2099.engine.positions.Ground;
import game.Element;
import game.Status;
/**
 * This is the general abstract class for Spawning Ground
 * @author Yunxi Liu
 */
public abstract class SpawningGround extends Ground {
    protected final Element groundElement;
    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     * @param groundElement element of each Spawning Ground
     *
     */
    public SpawningGround(char displayChar, Element groundElement) {
        super(displayChar);
        this.groundElement=groundElement;
        this.addCapability(Status.CANNOTBEEXPANDED);//the Spawning Ground can not be expanded
    }


}
