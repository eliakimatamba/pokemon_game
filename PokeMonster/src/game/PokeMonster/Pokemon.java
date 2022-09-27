package game.PokeMonster;

import edu.monash.fit2099.engine.actors.Actor;
import game.Element;
import game.Status;


public abstract class Pokemon extends Actor{


 private String PokeName;


 public Element getPokemonElement() {
  return PokemonElement;
 }

 public void setGetPokemonElement(Element getPokemonElement) {
  this.PokemonElement = getPokemonElement;
 }

 private Element PokemonElement;
 private String PokeElement;

 /**
  * Constructor.
  *
  * @param name        the name of the Actor
  * @param displayChar the character that will represent the Actor in the display
  * @param hitPoints   the Actor's starting hit points
  */
 public Pokemon(String name, char displayChar, int hitPoints) {
  super(name, displayChar, hitPoints);
  this.PokeName = name;
  this.addCapability(Status.POKEMON);

 }

 public String getPokeName() {
   return PokeName;
 }


 public void ToAttack(){

 }



}
