package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.*;
import game.PokeMonster.Charmander;
import game.PokeMonster.Pokemon;
import game.PokeMonster.Squirtle;

/**
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 */
public class AttackBehaviour extends Action implements Behaviour {

    /**
     *  HINT: develop a logic to check surrounding, check elements, and return an action to attack that opponent.
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Actor Charmander= new Charmander();

        if(ElementsHelper.hasAnySimilarElements(actor, Charmander.findCapabilitiesByType(Element.class))){
            return new AttackAction(Charmander, "here"); // behaviour will stop here.
        }
        return null; // go to next behaviour
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
