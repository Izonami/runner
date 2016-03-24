package com.cookforman.runner.screens;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.cookforman.runner.Runner;
import com.cookforman.runner.model.Background;
import com.cookforman.runner.model.Boll;
import com.cookforman.runner.model.Player;

/**
 * Created by kuksin-mv on 15.03.2016.
 */
public class GameScreen extends AbstractScreen
{
    private World world;
    Player player,player2,player3;
    Background background;
    public Boll boll;
    Box2DDebugRenderer renderer;

    public GameScreen(final Runner app, Integer level)
    {
        super(app);

        System.out.println("Level: " + level.toString());
        world = new World(new Vector2(0, -10), true);
        renderer = new Box2DDebugRenderer();

        buildStage();
    }

    public void buildStage()
    {
        //System.out.println("Build");
        //player = new Player(getWorld(), 0, 0, 1, GAME_WIDTH, 0, BodyDef.BodyType.StaticBody);
        // player2 = new Player(getWorld(), 1, 0, Constants.GAME_WIDTH, 0, 0, BodyDef.BodyType.StaticBody);
        // player3 = new Player(getWorld(), 0, Constants.GAME_HEIGHT, 1, Constants.GAME_HEIGHT, 0, BodyDef.BodyType.StaticBody);
        background = new Background(world);
        boll = new Boll(world, 10, 10, 2, 1, BodyDef.BodyType.DynamicBody);

        boll.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                boll.setPosition(x, y);

            }
        });

        addActor(background);
        addActor(boll);


        //addActor(player);
        //addActor(player2);
        //addActor(player3);

        this.setDebugAll(true);
    }

    @Override
    public void render(float delta)
    {
        renderer.render(world, getCamera().combined);

        world.step(1 / 60f, 4, 4);
    }
}
