package game.ground;


import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.Element;
import game.PokeMonster.Charmander;
import game.item.pokefruit.FirePokefruit;
/**
 * Crater(one of the Spawning Ground)
 * @author Yunxi Liu
 */
public class Crater extends SpawningGround{


    /**
     * Constructor.
     */
    public Crater() {
        super('O', Element.FIRE);

        this.addCapability(Element.FIRE);
    }

    public void tick(Location location){
        //25% chance and no actor on the location-->drop a fire fruit
        if((int)(1 + (Math.random() * 100))<=25 && !location.containsAnActor()){
            //one location only has one fruit
            if(location.getItems().size()==0){
                location.addItem(new FirePokefruit());
            }
        //10% chance and no actor-->spawn one Charmander on one exit
        }else if ((int)(1 + (Math.random() * 100))<=10 && !location.containsAnActor()){
            for(Exit exit: location.getExits()){
                //that location has no actor
                if(!exit.getDestination().containsAnActor()){
                    exit.getDestination().addActor(new Charmander());
                    return;
                }}
        }
    }
}
