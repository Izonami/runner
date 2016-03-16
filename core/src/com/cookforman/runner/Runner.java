package com.cookforman.runner;

import com.badlogic.gdx.Game;
import com.cookforman.runner.model.AssetLoader;
import com.cookforman.runner.screens.GameScreen;

public class Runner extends Game
{

    @Override
    public void create()
    {
        AssetLoader.load();//Загружаем текстурки
        setScreen(new GameScreen());
    }

    @Override
    public void dispose()
    {
        super.dispose();
        AssetLoader.dispose();
    }
}
