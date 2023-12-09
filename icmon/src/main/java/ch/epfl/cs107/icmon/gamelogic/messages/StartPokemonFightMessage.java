package ch.epfl.cs107.icmon.gamelogic.messages;

import ch.epfl.cs107.icmon.ICMon;
import ch.epfl.cs107.icmon.actor.ICMonPlayer;
import ch.epfl.cs107.icmon.actor.pokemon.Pokemon;
import ch.epfl.cs107.icmon.gamelogic.actions.RegisterEventAction;
import ch.epfl.cs107.icmon.gamelogic.actions.UnregisterEventAction;
import ch.epfl.cs107.icmon.gamelogic.events.PokemonFightEvent;

public class StartPokemonFightMessage implements GamePlayMessage {

    private final Pokemon pokemon;
    private final Pokemon playerPokemon;

    public StartPokemonFightMessage(Pokemon pokemon, Pokemon playerPokemon) {
        this.pokemon = pokemon;
        this.playerPokemon = playerPokemon;
    }

    @Override
    public void process(ICMonPlayer player, ICMon.ICMonGameState gameState, ICMon.ICMonEventManager eventManager) {
        final PokemonFightEvent event = new PokemonFightEvent(gameState, eventManager, player, playerPokemon, pokemon);
        event.onStart(new RegisterEventAction(eventManager, event));
        event.onComplete(new UnregisterEventAction(eventManager, event));
        gameState.send(new SuspendWithEventMessage(event));
    }

}
