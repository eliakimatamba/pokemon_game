package game.item.pokefruit;

import edu.monash.fit2099.engine.items.Item;
import game.Element;
import game.TradeableItem;

import javax.swing.text.TabableView;

/**
 * This is the general abstract class for all Pokefruit objects
 * @author Zhewen Zhu
 */
public abstract class Pokefruit extends Item implements TradeableItem {

    private final Element pokefruitElement;

    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public Pokefruit(String name, char displayChar, boolean portable,Element pokefruitElement) {
        super(name, displayChar, portable);
        this.pokefruitElement=pokefruitElement;
    }

    public Element getPokefruitElement() {
        return pokefruitElement;
    }
}
