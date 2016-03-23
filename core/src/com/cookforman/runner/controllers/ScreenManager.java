package com.cookforman.runner.controllers;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.cookforman.runner.Runner;
import com.cookforman.runner.screens.AbstractScreen;

/**
 * Created by kuksin-mv on 22.03.2016.
 */
public class ScreenManager
{
    private static ScreenManager instanse;

    private Game game;

    private ScreenManager(){}

    public static ScreenManager getInstanse()
    {
        if (instanse == null)
            instanse = new ScreenManager();

        return instanse;
    }

    public void init(Game game)
    {
        this.game = game;
    }

    public void showScreen(final Runner app, ScreenEnum screenEnum, Object... params)
    {
        Screen currntScreen = game.getScreen();

        AbstractScreen newScreen = screenEnum.getScreen(app, params);


        game.setScreen(newScreen);

        if (currntScreen != null)
            currntScreen.dispose();
    }
}
