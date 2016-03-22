package com.cookforman.runner.screens;

import com.cookforman.runner.Runner;
import com.cookforman.runner.model.AssetLoader;

/**
 * Created by kuksin-mv on 22.03.2016.
 */
public enum ScreenEnum
{
    LOAD
            {
                public AbstractScreen getScreen(final Runner app, Object... params)
                {
                    return new AssetLoader(app);
                }
            },
    GAME
            {
                public AbstractScreen getScreen(final Runner app, Object... params)
                {
                    return new GameScreen(app, (Integer) params[0]);
                }
            };

    public abstract AbstractScreen getScreen(final Runner app, Object... params);
}
