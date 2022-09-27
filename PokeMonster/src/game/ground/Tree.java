package game.ground;


import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.Element;
import game.PokeMonster.Bulbasaur;
import game.Status;
import game.item.Candy;
import game.item.pokefruit.GrassPokefruit;
import game.time.TimePerception;
import game.time.TimePeriod;

/**
 * Tree(one of the Spawning Ground)
 * @author Yunxi Liu
 */
public class Tree extends SpawningGround implements TimePerception {

    private int grassElementCounter;
    /**
     * Constructor.
     *
     */
    public Tree() {
        super('T', Element.GRASS);
        this.addCapability(Element.GRASS);
        this.registerInstance();
    }

    public void tick(Location location){
        grassElementCounter=0;
        //15% chance and no actor on the location-->drop a grass fruit
        if((int)(1 + (Math.random() * 100))<=15 && !location.containsAnActor()){
            if(location.getItems().size()==0){
                location.addItem(new GrassPokefruit());

            }
            //15% chance and no actor on the location
        }else if ((int)(1 + (Math.random() * 100))<=15 && !location.containsAnActor()){
            for(Exit exit: location.getExits()){
                //check for the surrounding elements
                if(exit.getDestination().getGround().hasCapability(Element.GRASS)){
                    grassElementCounter++;
                    //no actor on the location and at least 1 grass element around
                    if(!exit.getDestination().containsAnActor() && grassElementCounter>=1){
                        exit.getDestination().addActor(new Bulbasaur());
                        return;
                    }
                }
            }
        }
        //5% chance and day -->drop candy
        if(this.hasCapability(TimePeriod.DAY) && (int)(1 + (Math.random() * 100))<=5){
            location.addItem(new Candy());

        //10% chance and night
        }else if (!this.hasCapability(TimePeriod.DAY) && (int)(1 + (Math.random() * 100))<=10){
            for(Exit exit: location.getExits()){
                //expandable? and no actor on that location
                if(!exit.getDestination().getGround().hasCapability(Status.CANNOTBEEXPANDED) && !exit.getDestination().containsAnActor()){
                    //Tree and Hay half-and-half
                    if((int)(1 + (Math.random() * 100))<=50){
                        exit.getDestination().setGround(new Tree());
                    }else{
                        exit.getDestination().setGround(new Hay());

            }}}

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
