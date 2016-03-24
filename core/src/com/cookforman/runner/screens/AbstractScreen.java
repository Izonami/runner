package com.cookforman.runner.screens;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.cookforman.runner.Runner;
import com.cookforman.runner.utils.Constants;

/**
 * Created by kuksin-mv on 18.03.2016.
 */
public abstract class AbstractScreen extends Stage
{
    protected final Runner app;

    public AbstractScreen(final Runner app)
    {
        super(new StretchViewport(Constants.GAME_WIDTH/8, Constants.GAME_HEIGHT/8));

        this.app = app;
    }

    public abstract void render(float delta);

}
