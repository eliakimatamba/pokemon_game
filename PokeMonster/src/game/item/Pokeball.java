package game.item;

import edu.monash.fit2099.engine.items.Item;
import game.PokeMonster.Pokemon;

/**
 * class for Pokeball in REQ3, use to catch or store a Pokemon
 * @author Zhewen ZHu
 */
public class Pokeball extends Item {

    private Pokemon pokemon;

    /***
     * Constructor.
     */
    public Pokeball(Pokemon pokemon) {
        super("Pokeball", '0', true);
        this.pokemon = pokemon;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }
}
