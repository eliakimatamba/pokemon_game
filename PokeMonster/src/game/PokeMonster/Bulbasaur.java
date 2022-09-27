package game.PokeMonster;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Element;
import game.Status;
import game.TradeableItem;
import game.behaviours.Behaviour;
import game.behaviours.WanderBehaviour;
import game.time.TimePerception;
import game.time.TimePeriod;

import java.util.Map;
import java.util.TreeMap;

public class Bulbasaur extends Pokemon implements TradeableItem, TimePerception {
    private final Map<Integer, Behaviour> behaviours = new TreeMap<>(); // priority, behaviour
    /**
     * Constructor.
     *
     */
    public Bulbasaur() {
        super("Bulbasaur",'B',100);
        this.addCapability(Element.GRASS);
        this.behaviours.put(10, new WanderBehaviour());
        //  this.behaviours.put(5,new FollowBehaviour(player));
        //this.behaviours.put(0,new AttackBehaviour());
        setGetPokemonElement(Element.GRASS);
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
            hurt(5);
        }
        else {
            heal(5);
        }
        return new DoNothingAction();
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
