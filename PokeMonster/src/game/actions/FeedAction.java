package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Element;
import game.PokeMonster.Pokemon;
import game.item.pokefruit.Pokefruit;
import game.AffectionManager;

/**
 * The class handles feeding pokemons using pokefruits, which is extended from Action class in engine.
 * @author Zhewen Zhu
 */
public class FeedAction extends Action {

    private Pokefruit pokefruit;
    private Pokemon pokemon;
    AffectionManager affectionManager = AffectionManager.getInstance();

    public FeedAction(Actor actor, Item pokefruit) {
        this.pokemon = (Pokemon) actor;
        this.pokefruit = (Pokefruit) pokefruit;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        Element pokefruitElement = pokefruit.getPokefruitElement();
        Element pokemonElement = pokemon.getPokemonElement();
        String returnMSG;
        if (pokemonElement == pokefruitElement){
            returnMSG = affectionManager.increaseAffection(pokemon,20);
        }
        else {
            returnMSG = affectionManager.decreaseAffection(pokemon,10);
        }
        actor.removeItemFromInventory(pokefruit);
        return returnMSG;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + "feeds a " + pokefruit + " to " + pokemon.getPokeName()
                + "AP(" + affectionManager.getAffectionPoint(pokemon) + ")";
    }
}
