package com.cookforman.runner.controllers;

import com.cookforman.runner.Runner;
import com.cookforman.runner.model.AssetLoader;
import com.cookforman.runner.screens.GameScreen;
import com.cookforman.runner.view.GameRenderer;

/**
 * Created by kuksin-mv on 22.03.2016.
 */
public enum ScreenEnum
{
    LOAD
            {
                public GameRenderer getScreen(final Runner app, Object... params)
                {
                    return new GameRenderer(app, new AssetLoader(app));
                }
            },
    GAME
            {
                public GameRenderer getScreen(final Runner app, Object... params)
                {
                    return new GameRenderer(app, new GameScreen(app, (Integer)params[0]));
                }
            };

    public abstract GameRenderer getScreen(final Runner app, Object... params);
}
