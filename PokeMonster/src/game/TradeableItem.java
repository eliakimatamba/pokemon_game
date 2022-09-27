package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;

public interface TradeableItem {
    int price();
    String name();
    void transaction(Actor actor);
}
