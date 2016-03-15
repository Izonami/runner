package com.cookforman.runner;

import com.badlogic.gdx.Game;
import com.cookforman.runner.screens.GameScreen;

public class Runner extends Game
{

    @Override
    public void create()
    {
        setScreen( new GameScreen());
    }
}
