package com.cookforman.runner.screens;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.cookforman.runner.Runner;
import com.cookforman.runner.view.GameRenderer;

/**
 * Created by kuksin-mv on 15.03.2016.
 */
public class GameScreen extends AbstractScreen
{
    private GameRenderer gameRenderer;
    private World world;

    public GameScreen(final Runner app, Integer level)
    {
        super(app);

        world = new World(new Vector2(0, -10), true);
        gameRenderer = new GameRenderer(app, this);
    }

    @Override
    public void render(float delta)
    {
        gameRenderer.render(delta);
    }

    public World getWorld()
    {
        return world;
    }

}
