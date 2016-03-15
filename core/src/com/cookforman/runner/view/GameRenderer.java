package com.cookforman.runner.view;

import com.badlogic.gdx.Gdx;
import com.cookforman.runner.controllers.GameWorld;

/**
 * Created by kuksin-mv on 15.03.2016.
 */
public class GameRenderer
{
    private GameWorld gameWorld;

    public GameRenderer(final GameWorld gameWorld)
    {
        this.gameWorld = gameWorld;
    }

    public void render()
    {
        Gdx.app.log("GR", "UPDATE");
    }
}
