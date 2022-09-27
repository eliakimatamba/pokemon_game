package game.Actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.positions.Location;
import game.Element;
import game.Status;
import game.actions.CatchAction;
import game.actions.FeedAction;
import game.actions.SummonAction;
import game.time.TimePerceptionManager;

import java.util.List;

/**
 * Class representing the Player.
 *
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 */
public class Player extends Actor {

	private final Menu menu = new Menu();

	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
		this.addCapability(Status.IMMUNE);
	}

	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {

		// The location of player currently at
		Location currentPosition = map.locationOf(this);
		//player's surrounding blokes
		List<Exit> surrounding = currentPosition.getExits();

		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();

		// if having pokemon stand around player
		for (int exitIndex = 0; exitIndex < surrounding.size(); exitIndex++){
			if (surrounding.get(exitIndex).getDestination().containsAnActor()){
				if (surrounding.get(exitIndex).getDestination().getActor().hasCapability(Status.POKEMON)){
					if(surrounding.get(exitIndex).getDestination().getActor().hasCapability(Status.CATCHABLE)){
						actions.add(new CatchAction(surrounding.get(exitIndex).getDestination().getActor()));
					}
					// if having pokefruit in the inventory at the same time, then introduce feed action

					List<Item> playerInventory = this.getInventory();
					for (int itemIndex = 0; itemIndex < playerInventory.size(); itemIndex++){
						if (playerInventory.get(itemIndex).hasCapability(Element.WATER)){
							actions.add(new FeedAction(surrounding.get(exitIndex).getDestination().getActor(),
									playerInventory.get(itemIndex)));
						}
						else if (playerInventory.get(itemIndex).hasCapability(Element.FIRE)){
							actions.add(new FeedAction(surrounding.get(exitIndex).getDestination().getActor(),
									playerInventory.get(itemIndex)));
						}
						else if (playerInventory.get(itemIndex).hasCapability(Element.GRASS)){
							actions.add(new FeedAction(surrounding.get(exitIndex).getDestination().getActor(),
									playerInventory.get(itemIndex)));
						}
						else if (playerInventory.get(itemIndex).getDisplayChar() == '0'){
							actions.add(new SummonAction(playerInventory.get(itemIndex),currentPosition));
						}
					}
				}
			}
		}
		TimePerceptionManager.getInstance().run();
		return menu.showMenu(this, actions, display);
	}

	@Override
	public char getDisplayChar() {
		return super.getDisplayChar();
	}
}
