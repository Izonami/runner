package com.cookforman.runner.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.cookforman.runner.Runner;
import com.cookforman.runner.model.Boll;
import com.cookforman.runner.model.Player;
import com.cookforman.runner.utils.Constants;

/**
 * Created by kuksin-mv on 15.03.2016.
 */
public class GameScreen extends AbstractScreen
{
    Texture texture;
    TextureRegion textureRegion;
    Player player,player2,player3;
    Boll boll;
    Box2DDebugRenderer renderer;

    private World world;

    public GameScreen(final Runner app, Integer level)
    {
        super(app);

        texture = app.assets.get(Constants.TEXTURE_PATH, Texture.class);
        world = new World(new Vector2(0, -10), true);
        renderer = new Box2DDebugRenderer();

    }

    @Override
    public void buildStage()
    {
        Image bg = new Image(texture);
        //addActor(bg);

        player = new Player(world, 0, 0, 1, Constants.GAME_WIDTH, 0, BodyDef.BodyType.StaticBody);
        player2 = new Player(world, 1, 0, Constants.GAME_WIDTH, 0, 0, BodyDef.BodyType.StaticBody);
        player3 = new Player(world, 0, Constants.GAME_HEIGHT, 1, Constants.GAME_HEIGHT, 0, BodyDef.BodyType.StaticBody);
        boll = new Boll(world, 10, 10, 2, 1, BodyDef.BodyType.DynamicBody);
        addActor(boll);
        addActor(player);
        addActor(player2);
        addActor(player3);


        bg.addListener(cLis(app, ScreenEnum.LOAD));
        this.setDebugAll(true);
    }

    @Override
    public void render(float delta)
    {
        super.render(delta);
        //renderer.render(world, this.getCamera().combined);
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
