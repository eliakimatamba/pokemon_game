package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.Actors.Player;
import game.PokeMonster.Charmander;
import game.PokeMonster.Squirtle;
import game.ground.*;
import game.Actors.NurseJoy;

/**
 * The main class to start the game.
 * Created by:
 *
 * @author Riordan D. Alfredo
 * Modified by:
 */
public class Application {

    public static void main(String[] args) {

        World world = new World(new Display());

        FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(),
                new Floor(), new Tree(), new Lava(), new Puddle(), new Crater(), new Waterfall(),new Hay());

        List<String> map = Arrays.asList(
                ".............................................^^^^^^^^^^^^^^",
                "............,T,................................,...^^^^^O^^",
                ".....................................................^^^^^^",
                "........................................................^^^",
                "..........................#######........................^^",
                "..........................#_____#.........................^",
                "..........................#_____#..........................",
                "....T......~..............###_###..........................",
                "...~~~~~~~~................................................",
                "....~~W~~.....................................W............",
                "~~~~~~~....................................................",
                "~~W~~~.....................................................",
                "~~~~~~~~~..................................................");
        GameMap gameMap = new GameMap(groundFactory, map);
        world.addGameMap(gameMap);

        //Add player - Ash
        Player ash = new Player("Ash", '@', 1);
        world.addPlayer(ash, gameMap.at(32, 10));

        //Add Nurse Joy
        NurseJoy nurseJoy = new NurseJoy();
        gameMap.at(29,5).addActor(nurseJoy);



        world.run();

    }
}
