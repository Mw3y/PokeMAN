package ch.epfl.cs107.icmon.actor.npc;

import ch.epfl.cs107.icmon.actor.ICMonFightableActor;
import ch.epfl.cs107.icmon.actor.ICMonPlayer;
import ch.epfl.cs107.icmon.actor.pokemon.Pokemon;
import ch.epfl.cs107.play.areagame.area.Area;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
import ch.epfl.cs107.play.math.Orientation;
import ch.epfl.cs107.play.math.RegionOfInterest;

import java.util.ArrayList;
import java.util.List;

public abstract class Trainer extends NPCActor implements ICMonFightableActor {

    private final List<Pokemon> pokemons = new ArrayList<>();
    private final String name;
    private boolean acceptsFights = false;
    private boolean hadADialogWithPlayer;

    private boolean disappearOnDefeat = true;

    /**
     * Represents a Pokémon trainer with a custom region of interest that the player can challenge.
     *
     * @param name             (String): The name of the trainer. Not null.
     * @param area             (Area): Owner area. Not null.
     * @param orientation      (Orientation): Initial orientation of the entity. Not null.
     * @param position         (Coordinate): Initial position of the entity. Not null.
     * @param spriteName       (String): Initial sprite of the trainer.
     * @param regionOfInterest (RegionOfInterest): The region of interest of the image
     */
    public Trainer(String name, Area area, Orientation orientation, DiscreteCoordinates position, String spriteName, RegionOfInterest regionOfInterest, boolean disappearOnDefeat) {
        super(area, orientation, position, spriteName, regionOfInterest);
        this.name = name;
        this.disappearOnDefeat = disappearOnDefeat;
    }

    /**
     * Represents a Pokémon trainer that the player can challenge.
     *
     * @param name        (String): The name of the trainer. Not null.
     * @param area        (Area): Owner area. Not null.
     * @param orientation (Orientation): Initial orientation of the entity. Not null.
     * @param position    (Coordinate): Initial position of the entity. Not null.
     * @param spriteName  (String): Initial sprite of the trainer.
     */
    public Trainer(String name, Area area, Orientation orientation, DiscreteCoordinates position, String spriteName) {
        super(area, orientation, position, spriteName);
        this.name = name;
    }

    /**
     * Starts a dialog with the player.
     * @param player - The player to chat with
     * @param name - The name of the dialog file
     */
    public void openDialogWith(ICMonPlayer player, String name) {
        player.openDialog(name);
        hadADialogWithPlayer = true;
    }

    /**
     * @return whether the player has already talked to this trainer or not.
     */
    public boolean hadADialogWithPlayer() {
        return hadADialogWithPlayer;
    }

    /**
     * @return whether the player should disappear on defeat.
     */
    public boolean disappearsOnDefeat() {
        return disappearOnDefeat;
    }

    /**
     * Gets the name of the trainer.
     *
     * @return yhe name if this trainer.
     */
    public String name() {
        return name;
    }

    /**
     * Gives a Pokémon to the player.
     *
     * @param pokemon (Pokemon)
     * @return
     */
    protected boolean givePokemon(Pokemon pokemon) {
        assert pokemon != null;
        return pokemons.add(pokemon);
    }

    /**
     * Checks if the player has got Pokémon able to fight.
     *
     * @return true if the list of Pokémon is not empty and if not all of them are KO.
     */
    public boolean hasHealthyPokemon() {
        for (Pokemon pokemon : pokemons) {
            if (!pokemon.properties().isKO())
                return true;
        }
        return false;
    }

    /**
     * @return true if the player is able to fight.
     */
    public boolean acceptsFights() {
        return this.acceptsFights;
    }

    /**
     * Setter for acceptsFights.
     *
     * @param acceptance (boolean) : the capability of the player to accept a fight.
     */
    public void setFightsAcceptance(boolean acceptance) {
        acceptsFights = acceptance;
    }

    /**
     * Gives access to its Pokémon list to all Trainer subclasses.
     *
     * @return the trainer Pokémon list.
     */
    protected List<Pokemon> getPokemons() {
        return pokemons;
    }


}
