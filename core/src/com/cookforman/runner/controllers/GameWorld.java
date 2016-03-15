package com.cookforman.runner.controllers;

import com.badlogic.gdx.Gdx;

/**
 * Created by kuksin-mv on 15.03.2016.
 */
public class GameWorld
{
    public GameWorld()
    {
        Gdx.app.log("GAME", "WORLD");
    }

    public void update(float delta)
    {
        Gdx.app.log("GW", "UPDATE");
    }
}
