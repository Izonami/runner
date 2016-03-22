package com.cookforman.runner.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.cookforman.runner.Runner;
import com.cookforman.runner.model.Player;
import com.cookforman.runner.utils.Constants;

/**
 * Created by kuksin-mv on 15.03.2016.
 */
public class GameScreen extends AbstractScreen
{
    Texture texture;
    TextureRegion textureRegion;
    Player player;

    private World world;

    public GameScreen(final Runner app, Integer level)
    {
        super(app);

        texture = app.assets.get(Constants.TEXTURE_PATH, Texture.class);
        world = new World(new Vector2(0, -10), true);

    }

    @Override
    public void buildStage()
    {
        Image bg = new Image(texture);
        //addActor(bg);

        player = new Player(world, 1, 1);
        addActor(player);

        bg.addListener(cLis(app, ScreenEnum.LOAD));
    }

    @Override
    public void render(float delta)
    {
        super.render(delta);

        world.step(1/60f, 4, 4);
    }

    public static InputListener cLis(final Runner app, final ScreenEnum screenEnum, final Object... par)
    {
        return
                new InputListener()
                {
                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
                    {
                        ScreenManager.getInstanse().showScreen(app, screenEnum, par);
                        return false;
                    }
                };
    }
}
