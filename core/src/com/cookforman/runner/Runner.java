package com.cookforman.runner;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.cookforman.runner.screens.GameScreen;

public class Runner extends Game
{

    @Override
    public void create()
    {
        Gdx.app.log("RUNNER", "create");

        setScreen( new GameScreen());
    }
}
