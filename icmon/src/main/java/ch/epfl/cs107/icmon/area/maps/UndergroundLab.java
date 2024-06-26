package ch.epfl.cs107.icmon.area.maps;

import ch.epfl.cs107.icmon.actor.ICMonPlayer;
import ch.epfl.cs107.icmon.actor.misc.Door;
import ch.epfl.cs107.icmon.actor.npc.league.*;
import ch.epfl.cs107.icmon.area.ICMonArea;
import ch.epfl.cs107.play.engine.actor.Background;
import ch.epfl.cs107.play.engine.actor.Foreground;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
import ch.epfl.cs107.play.math.Orientation;

public class UndergroundLab extends ICMonArea {

    public static final String TITLE = "underground_lab";

    private boolean hasInfoDialogBeenShown;

    @Override
    public String getTitle() {
        return TITLE;
    }

    @Override
    public String getAmbiantSound() {
        return "cold_storage";
    }

    @Override
    protected void createArea() {
        registerActor(new Background(this));
        registerActor(new Foreground(this));
        registerActor(new Door(Town.TITLE, new DiscreteCoordinates(21,6), this, new DiscreteCoordinates(24, 11)));
        registerActor(new AnnaLachowska(this, Orientation.DOWN, new DiscreteCoordinates(5, 25)));
        registerActor(new NicolasBoumal(this, Orientation.DOWN, new DiscreteCoordinates(25, 24)));
        registerActor(new TanjaKaser(this, Orientation.DOWN, new DiscreteCoordinates(5, 15)));
        registerActor(new FredericBlanc(this, Orientation.DOWN, new DiscreteCoordinates(34, 16)));
        registerActor(new JamilaSam(this, Orientation.DOWN, new DiscreteCoordinates(31, 36)));
    }

    @Override
    public void onEnter(ICMonPlayer player) {
        if (!hasInfoDialogBeenShown)
            player.openDialog("welcome_to_rolex_league");
        hasInfoDialogBeenShown = true;
    }

    @Override
    public DiscreteCoordinates getPlayerSpawnPosition() {
        return new DiscreteCoordinates(19, 4);
    }
}
