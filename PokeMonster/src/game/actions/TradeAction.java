package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Status;
import game.TradeableItem;
import game.item.Candy;

import java.util.List;


/**
 * The class which handles trading between player and nurse Joy, which is extended from Action class in engine.
 * @author Zhewen Zhu
 */
public class TradeAction extends Action {
    private Candy candy = new Candy();

    private TradeableItem tradeableItem;

    public TradeAction(TradeableItem item) {
        this.tradeableItem = item;
    }

    /**
     * first get the item from the tradeable item, then send it to check the balance of candy.
     * If the balance is enough, then start the transaction, if no then return the message to notify the player
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return the executed result
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String MSG = "";
        int price = tradeableItem.price();
        boolean flag = balanceCheck(actor,price);
        if (flag){
            tradeableItem.transaction(actor);
            MSG = "Transaction complete. Player has trade" + tradeableItem.name() + " from Nurse Joy";
        }
        else {
            MSG = "Transaction failed. It looks like you don't have enough candy. You know the rules, and so do I!";
        }
        return MSG;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + "Trade " + tradeableItem.name() + " from Nurse Joy with " + tradeableItem.price() +" candies";
    }

    private boolean balanceCheck(Actor actor, int cost){
        boolean flag = false;
        int inventoryIndex =0;
        int candyCount = 0;
        List<Item> actorInventory= actor.getInventory();
        while(inventoryIndex < actorInventory.size()){
            if (actorInventory.get(inventoryIndex).hasCapability(Status.CANDY)){
                candyCount++;
            }
            inventoryIndex++;
        }
        if (candyCount >= cost){
            while (cost > 0){
                actor.removeItemFromInventory(candy);
                cost--;
            }
            flag = true;
        }
        return flag;
    }
}
