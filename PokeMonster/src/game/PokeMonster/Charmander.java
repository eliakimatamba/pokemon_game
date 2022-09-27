package game.PokeMonster;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.capabilities.CapabilitySet;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.positions.*;
import game.AttackAction;
import game.Element;
import game.TradeableItem;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.item.Pokeball;
import game.time.TimePerception;
import game.time.TimePeriod;

import java.time.MonthDay;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by:
 *
 * @author Riordan D. Alfredo
 * Modified by:
 */
public class Charmander extends Pokemon implements TradeableItem, TimePerception {
    //FIXME: Change it to a sorted map (is it TreeMap? HashMap? LinkedHashMap?)
    private final Map<Integer, Behaviour> behaviours = new TreeMap<>(); // priority, behaviour
    private final CapabilitySet capabilitySet = new CapabilitySet();
    /**
     * Constructor.
     */
    public Charmander() {
        super("Charmander", 'C',100);
        // HINT: add more relevant behaviours here
        this.addCapability(Element.FIRE);
       // Location location = gameMap.locationOf(this);
        //Location location1 = new Location(gameMap, location.x(), location.y()+1);
        //gameMap.addActor(this, location1);

        //Behaviour followBehaviour = new FollowBehaviour();


        //followBehaviour.getAction(this,gameMap).execute(this, gameMap);

         this.behaviours.put(10, new WanderBehaviour());
        //this.behaviours.put(5,new FollowBehaviour(this,));
        this.behaviours.put(0,new AttackBehaviour());
        setGetPokemonElement(Element.FIRE);
        this.registerInstance();

    }

    /**
     * @param otherActor the Actor that might perform an action.
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return list of actions
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        actions.add(new AttackAction(this, direction));
        //FIXME: allow other actor to attack this Charmander (incl. Player). Please check requirement! :)
        return actions;
    }

    /**
     * By using behaviour loops, it will decide what will be the next action automatically.
     *
     * @see Actor#playTurn(ActionList, Action, GameMap, Display)
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if (action != null)
                return action;
        }
        if(hasCapability(TimePeriod.DAY)){
            heal(10);

        }
        else {
            hurt(10);
        }
        return new DoNothingAction();
    }

    /**
     * @param isEquipping FIXME: develop a logic to toggle weapon (put a selected weapon to the inventory - used!);
     */
    public void toggleWeapon(boolean isEquipping) {

    }

    @Override
    public int price() {
        return 5;
    }

    @Override
    public String name() {
        return this.getPokeName();
    }

    @Override
    public void transaction(Actor actor) {
        Pokeball pokeball = new Pokeball(this);
        actor.addItemToInventory(pokeball);
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
