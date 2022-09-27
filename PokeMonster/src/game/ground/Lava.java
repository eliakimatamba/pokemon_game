package game.ground;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Element;
import game.PokeMonster.Bulbasaur;
import game.Status;
import game.item.Candy;
import game.item.pokefruit.WaterPokefruit;
import game.time.TimePerception;
import game.time.TimePeriod;

/**
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by: Yunxi Liu
 *
 */
public class Lava extends Ground implements TimePerception {

    /**
     * Constructor.
     */
    public Lava() {
        super('^');
        this.addCapability(Element.FIRE);

        this.registerInstance();
    }

    public void tick(Location location){

        //10% chance and day
        if(this.hasCapability(TimePeriod.DAY) && (int)(1 + (Math.random() * 100))<=10){
            for(Exit exit: location.getExits()){
                //and the surrounding is expandable
                if(!exit.getDestination().getGround().hasCapability(Status.CANNOTBEEXPANDED)){
                    exit.getDestination().setGround(new Lava());
                    }
            }
        }
        //10% chance and night
        else if (!this.hasCapability(TimePeriod.DAY) && (int)(1 + (Math.random() * 100))<=10){
            location.setGround(new Dirt());
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
