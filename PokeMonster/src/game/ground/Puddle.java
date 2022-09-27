package game.ground;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Element;
import game.Status;
import game.time.TimePerception;
import game.time.TimePeriod;
/**
 * puddle(one of the Ground)
 * @author Yunxi Liu
 */
public class Puddle extends Ground implements TimePerception {

    /**
     * Constructor.
     *
     */
    public Puddle() {
        super('~');
        this.addCapability(Element.WATER);
        this.registerInstance();
    }
    public void tick(Location location){

        //10% chance and day
        if (this.hasCapability(TimePeriod.DAY) && (int)(1 + (Math.random() * 100))<=10){
            location.setGround(new Dirt());
        }
        //10% chance and night
        else if(!this.hasCapability(TimePeriod.DAY) && (int)(1 + (Math.random() * 100))<=10){
            for(Exit exit: location.getExits()){
                //and the surrounding is expandable
                if(!exit.getDestination().getGround().hasCapability(Status.CANNOTBEEXPANDED)){
                    exit.getDestination().setGround(new Puddle());

                }
            }
        }

    }
    @Override
    public void dayEffect() {
        this.addCapability(TimePeriod.DAY);
        //make the capability "Day"
    }

    @Override
    public void nightEffect() {
       this.removeCapability(TimePeriod.DAY);
        //remove the capability "Day"  (considered as night)
    }
}
