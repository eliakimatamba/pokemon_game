package game.ground;


import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.Element;
import game.PokeMonster.Squirtle;
import game.item.pokefruit.WaterPokefruit;
/**
 * waterfall(one of the Spawning Ground)
 * @author Yunxi Liu
 */

public class Waterfall extends SpawningGround {

    private int waterElementCounter=0;
    /**
     * Constructor.
     */
    public Waterfall() {
        super('W', Element.WATER);
        this.addCapability(Element.WATER);
    }

    public void tick(Location location){
        waterElementCounter=0;
        //20% chance and no actor on the location-->drop a water fruit
        if((int)(1 + (Math.random() * 100))<=20 && !location.containsAnActor()){
            if(location.getItems().size()==0){
                location.addItem(new WaterPokefruit());
            }
        //20% chance and no actor and at least 2 water ground-->spawn one Squirtle on one exit
        }else if ((int)(1 + (Math.random() * 100))<=20 && !location.containsAnActor()){
            for(Exit exit: location.getExits()){
                if(exit.getDestination().getGround().hasCapability(Element.WATER)){
                    waterElementCounter++;
                    if(!exit.getDestination().containsAnActor() && waterElementCounter >=2){
                        exit.getDestination().addActor(new Squirtle());
                        return;

                    }
                }

            }
        }
    }


}
