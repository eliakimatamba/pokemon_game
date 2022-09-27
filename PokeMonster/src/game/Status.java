package game;

/**
 * Use this enum class to give `buff` or `debuff`.
 * It is also useful to give a `state` to abilities or actions that can be attached-detached.
 */
public enum Status {
    IMMUNE, // an enum to identify that an object is immune to any attack.
    HOSTILE, // use this status to be considered hostile towards enemy (e.g., to be attacked by enemy)
    CATCHABLE,
    TRADER,  //The actor who can trade with, currently will be Nurse Joy
    POKEMON,//For identifying Pokemons
    DISLIKETRAINER, // for affection level of pokemon, if it dislikes the trainer, it will no longer be able tp feed
   FOLLOWTRAINER, // For affection level of Pokemon, if it reaches this level, then it can follow the trainer
    LIKETRAINER, // for affection level of pokemon higher then 50, willing to be capture
    CANDY, //helps to identify the candy object in Inventory
    CANNOTBEEXPANDED //the ground will have this for not be expanded by other normal ground

}
