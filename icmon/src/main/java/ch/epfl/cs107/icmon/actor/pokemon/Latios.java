package ch.epfl.cs107.icmon.actor.pokemon;

import ch.epfl.cs107.icmon.actor.pokemon.actions.Attack;
import ch.epfl.cs107.icmon.actor.pokemon.actions.RunAway;
import ch.epfl.cs107.icmon.gamelogic.fights.ICMonFightAction;
import ch.epfl.cs107.icmon.handler.ICMonInteractionVisitor;
import ch.epfl.cs107.play.areagame.area.Area;
import ch.epfl.cs107.play.areagame.handler.AreaInteractionVisitor;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
import ch.epfl.cs107.play.math.Orientation;

import java.util.List;

public class Latios extends Pokemon {

    public static final String NAME = "latios";
    public static final int DAMAGES = 1;
    public static final int HP_MAX = 10;

    public Latios(Area area, Orientation orientation, DiscreteCoordinates position) {
        super(area, orientation, position, NAME, 381, DAMAGES, 30, HP_MAX, List.of(new Attack(), new RunAway()));
    }
}
