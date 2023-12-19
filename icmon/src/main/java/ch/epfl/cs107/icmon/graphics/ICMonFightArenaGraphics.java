package ch.epfl.cs107.icmon.graphics;

import ch.epfl.cs107.icmon.actor.pokemon.Pokemon.PokemonProperties;
import ch.epfl.cs107.play.engine.actor.Graphics;
import ch.epfl.cs107.play.engine.actor.GraphicsEntity;
import ch.epfl.cs107.play.engine.actor.ImageGraphics;
import ch.epfl.cs107.play.math.RegionOfInterest;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;

import static ch.epfl.cs107.play.io.ResourcePath.getBackground;
import static ch.epfl.cs107.play.io.ResourcePath.getSprite;
import static java.util.Objects.nonNull;

/**
 * ???
 *
 * @author Hamza REMMAL (hamza.remmal@epfl.ch)
 */
public final class ICMonFightArenaGraphics implements Graphics {

    private final ImageGraphics background;

    /** ??? */
    private final GraphicsEntity player;
    /** ??? */
    private final GraphicsEntity opponent;

    private final ICMonFightInfoGraphics playerInfo;

    private final ICMonFightInfoGraphics opponentInfo;

    private ICMonFightInteractionGraphics interactionGraphics;


    public ICMonFightArenaGraphics(float scaleFactor, PokemonProperties player, PokemonProperties opponent) {
        // HR : The background will be displayed in the top 2/3 part of the screen
        background = new ImageGraphics(getBackground("fight"), scaleFactor, scaleFactor * 2 / 3);
        background.setRelativeTransform(Transform.I.translated(0, scaleFactor / 3));
        // HR : Add the pokemon's fight sprite
        this.opponent = new GraphicsEntity(new Vector(scaleFactor * 2 / 3 - 1.5f, scaleFactor * 2 / 3 - 1f),
                new ImageGraphics(getSprite("pokemons/" + opponent.pokedexId()), 5, 5, new RegionOfInterest(0, 0, 80, 80), true));
        this.player = new GraphicsEntity(new Vector(0f, scaleFactor / 3), new ImageGraphics(getSprite("pokemons/back/" + player.pokedexId()), 5, 5, new RegionOfInterest(0, 0, 80, 80), true));
        // HR : Prepare the info's graphics
        this.opponentInfo = new ICMonFightInfoGraphics(new Vector(.75f, scaleFactor - 2.5f), opponent, false);
        this.playerInfo = new ICMonFightInfoGraphics(new Vector(scaleFactor - 6.5f, scaleFactor / 3 + .5f), player, true);
    }

    public void setInteractionGraphics(ICMonFightInteractionGraphics graphics){
        this.interactionGraphics = graphics;
    }

    @Override
    public void draw(Canvas canvas) {
        // HR : Draw the background
        background.draw(canvas);
        // HR : Draw the pokemons
        player.draw(canvas);
        opponent.draw(canvas);
        // HR : Draw the infos
        playerInfo.draw(canvas);
        opponentInfo.draw(canvas);
        if(nonNull(interactionGraphics))
            interactionGraphics.draw(canvas);
    }

}
