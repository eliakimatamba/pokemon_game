package game.Actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.PokeMonster.Charmander;
import game.Status;
import game.actions.TradeAction;
import game.item.pokefruit.FirePokefruit;
import game.item.pokefruit.GrassPokefruit;
import game.item.pokefruit.WaterPokefruit;

/**
 * The class for nurse joy in REQ6, player can trade with this actor using TradeAction class
 * @author Zhewen Zhu
 */
public class NurseJoy extends Actor {

    FirePokefruit firePokefruit = new FirePokefruit();
    GrassPokefruit grassPokefruit = new GrassPokefruit();
    WaterPokefruit waterPokefruit = new WaterPokefruit();
    Charmander charmander = new Charmander();

    private static NurseJoy instance;

    /**
     * Constructor.
     */
    public NurseJoy() {
        super("Nurse Joy", '%', 100000);
        this.addCapability(Status.IMMUNE);
    }

    /**
     * a singleton relationship, as there will be only one nurse joy
     *
     * @return the instance of nurse joy
     */
    public static NurseJoy getInstance() {
        if (instance == null) {
            instance = new NurseJoy();
        }
        return instance;
    }
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actionList = new ActionList();
        actionList.add(new TradeAction(firePokefruit));
        actionList.add(new TradeAction(waterPokefruit));
        actionList.add(new TradeAction(grassPokefruit));
        actionList.add(new TradeAction(charmander));
        return actionList;
    }
}
