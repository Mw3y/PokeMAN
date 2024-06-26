package ch.epfl.cs107.icmon.gamelogic.actions;

import ch.epfl.cs107.icmon.actor.ICMonPlayer;
import ch.epfl.cs107.icmon.actor.pokemon.Pokemon;

public class GivePokemonToPlayerAction implements Action{
    private final Pokemon pokemon;
    private final ICMonPlayer player;

    /**
     * Constructor for GivePokemonPlayerAction
     * @param pokemon (Pokemon)
     * @param player (ICMonPlayer)
     */
    public GivePokemonToPlayerAction(Pokemon pokemon, ICMonPlayer player){
        assert pokemon != null;
        assert player != null;
        this.pokemon = pokemon;
        this.player = player;
    }

    /**
     * Calls method givePokemon().
     */
    @Override
    public void perform() {
        System.out.println("action.give." + pokemon.toString() + ".to.player");
        player.givePokemon(pokemon);
    }
}
