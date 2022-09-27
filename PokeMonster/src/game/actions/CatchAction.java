package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.AffectionManager;
import game.PokeMonster.Pokemon;
import game.Status;
import game.item.Candy;
import game.item.Pokeball;

/**
 * The class handles catching of a pokemon, which is extended from Action class in engine.
 */
public class CatchAction extends Action {

   private AffectionManager affectionManager = AffectionManager.getInstance();
    private Pokemon pokemon;
    private Pokeball pokeball;
   private Location location;
    private Candy candy = new Candy();

    /**
     * The constructor of the catch action
     * @param actor
     */
    public CatchAction(Actor actor) {
        pokemon = (Pokemon) actor;
    }

    /**
     * if the targeted pokemon has enough affection level, it will be caught, put into a pokeball, and put into
     * player's inventory. If not, then will just decrease 10 affection level using affection manager
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return message of execute result
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String MSG = "";

        if (pokemon.hasCapability(Status.LIKETRAINER)){
            pokeball=new Pokeball(pokemon);
            actor.addItemToInventory(pokeball);
            location = map.locationOf(pokemon);
            location.addItem(candy);
            map.removeActor(pokemon);
            location.addItem(candy);
            MSG = "Catch successful. " + pokemon.getPokeName() + " has added to player's inventory";
        }
        else {
            affectionManager.decreaseAffection(pokemon,10);
            MSG = "Catch Unsuccessful, and you make [ " + pokemon.getPokeName() + "] unhappy. Affection level -10";
        }



        return MSG;
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Catch " + pokemon.getPokeName() + "AP(" + affectionManager.getAffectionPoint(pokemon) + ")" ;
    }
}
