package game.PokeMonster;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.AttackAction;
import game.Element;
import game.Status;
import game.TradeableItem;
import game.behaviours.Behaviour;
import game.behaviours.WanderBehaviour;
import game.time.TimePerception;
import game.time.TimePeriod;

import java.util.Map;
import java.util.TreeMap;


public class Squirtle extends Pokemon implements TradeableItem, TimePerception {

    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    private final Map<Integer, Behaviour> behaviours = new TreeMap<>(); // priority, behaviour
    public Squirtle() {
        super("Squirtle",'S',100);
        // HINT: add more relevant behaviours here
        this.addCapability(Element.WATER);
        this.behaviours.put(10, new WanderBehaviour());
        //  this.behaviours.put(5,new FollowBehaviour(player));
        //this.behaviours.put(0,new AttackBehaviour());
        setGetPokemonElement(Element.WATER);
        this.registerInstance();
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if (action != null)
                return action;
        }
        if(hasCapability(TimePeriod.DAY))
        {
            hurt(10);
        }
        else{
            heal(10);
        }
        return new DoNothingAction();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        actions.add(new AttackAction(this, direction));
        //FIXME: allow other actor to attack this Charmander (incl. Player). Please check requirement! :)
        return actions;
    }
    @Override
    public int price() {
        return 0;
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public void transaction(Actor actor) {

    }

    @Override
    public void dayEffect() {
        this.addCapability(TimePeriod.DAY);
    }

    @Override
    public void nightEffect() {
        this.addCapability(TimePeriod.NIGHT);
    }
}
