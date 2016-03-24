package com.cookforman.runner.screens;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.cookforman.runner.Runner;
import com.cookforman.runner.model.Background;
import com.cookforman.runner.model.Boll;

/**
 * Created by kuksin-mv on 15.03.2016.
 */
public class GameScreen extends AbstractScreen
{
    private World world;
    private Background background;
    private Boll boll;
    private final Box2DDebugRenderer renderer;

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
        background = new Background(world);
        //boll = new Boll(world, 10, 10, 2, 10, BodyDef.BodyType.DynamicBody);
        BodyDef def = new BodyDef();
        def.type = BodyDef.BodyType.DynamicBody;
        Body body = world.createBody(def);
        boll = new Boll(body);

        boll.getBody().setTransform(3.0f, 4.0f, 0);
        boll.getBody().setFixedRotation(true);
        boll.setFriction(200f);

        addActor(background);
        addActor(boll);

        this.setDebugAll(true);
    }

    @Override
    public void render(float delta)
    {
        renderer.render(world, getCamera().combined);

        world.step(1 / 60f, 4, 4);

        this.addListener(new InputListener()
        {
            @Override
            public boolean keyDown(InputEvent event, int keycode)
            {
                switch (keycode)
                {
                    case 22:
                        boll.getVelocity().x = Boll.SPEED;
                        System.out.println(">>");
                        break;
                    case 19:
                        boll.getVelocity().x =- Boll.SPEED;
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        boll.update(delta);
    }
}
