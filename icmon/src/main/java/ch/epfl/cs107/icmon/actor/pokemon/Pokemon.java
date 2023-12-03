package ch.epfl.cs107.icmon.actor.pokemon;

import ch.epfl.cs107.icmon.ICMon;
import ch.epfl.cs107.icmon.actor.ICMonActor;
import ch.epfl.cs107.icmon.actor.ICMonFightableActor;
import ch.epfl.cs107.icmon.actor.ICMonPlayer;
import ch.epfl.cs107.icmon.gamelogic.events.PokemonFightEvent;
import ch.epfl.cs107.icmon.gamelogic.messages.StartPokemonFightMessage;
import ch.epfl.cs107.play.areagame.area.Area;
import ch.epfl.cs107.play.engine.actor.RPGSprite;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
import ch.epfl.cs107.play.math.Orientation;
import ch.epfl.cs107.play.window.Canvas;

/**
 * ???
 *
 * @author Hamza REMMAL (hamza.remmal@epfl.ch)
 */
public abstract class Pokemon extends ICMonActor implements ICMonFightableActor {
    private String name;
    private int hpMax;
    private int hp;
    private int damages;
    private RPGSprite sprite;

    public Pokemon(Area area, Orientation orientation, DiscreteCoordinates position, String name, int damages, int hpMax) {
        super(area, orientation, position);
        this.name = name;
        this.hpMax = hpMax;
        this.hp = hp;
        this.damages = damages;
        this.sprite = new RPGSprite("pokemon/" + name, 1, 1, this);
    }

    @Override
    public void draw(Canvas canvas) {
        sprite.draw(canvas);
    }

    /**
     * @author Hamza REMMAL (hamza.remmal@epfl.ch)
     */
    public final class PokemonProperties {

        public String name() {
            return null;
        }

        public float hp() {
            return 0f;
        }

        public float maxHp() {
            return 0f;
        }

        public int damage() {
            return 0;
        }

    }

}