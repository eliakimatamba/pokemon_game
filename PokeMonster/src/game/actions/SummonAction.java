package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.AffectionManager;
import game.PokeMonster.Pokemon;
import game.item.Pokeball;

import java.util.List;
import java.util.Random;

/**
 * The class that handles summon of pokemons, which is extended from Action class in engine.
 * @author shenghong Huang
 */
public class SummonAction extends Action {
    public SummonAction(Item pokeball, Location playerLocation) {
        this.pokeball = (Pokeball) pokeball;
        this.playerLocation = playerLocation;
    }

    private Pokeball pokeball;
    private Location playerLocation;
    private Pokemon pokemon;

    @Override
    public String execute(Actor actor, GameMap map) {
        pokemon = pokeball.getPokemon();
        List<Exit> surrounding = playerLocation.getExits();
        Location PKMLocation = surrounding.get(0).getDestination();
       PKMLocation.addActor(pokemon);
       actor.removeItemFromInventory(pokeball);
        return "I choose you... [ " + pokemon.getPokeName() + " ]";
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Release " + pokemon.getPokeName() + " to the world";
    }
}
