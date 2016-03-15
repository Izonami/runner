package com.cookforman.runner.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.cookforman.runner.controllers.GameWorld;
import com.cookforman.runner.view.GameRenderer;

/**
 * Created by kuksin-mv on 15.03.2016.
 */
public class GameScreen implements Screen
{
    private GameWorld gameWorld;
    private GameRenderer gameRenderer;

    public GameScreen()
    {
        gameWorld = new GameWorld();
        gameRenderer = new GameRenderer(gameWorld);
    }

    @Override
    public void show()
    {
        Gdx.app.log("RUNNER", "show");
    }

    @Override
    public void render(float delta)
    {
        Gdx.app.log("RUNNER FPS", String.valueOf((int) (1 / delta)));
        Gdx.gl.glClearColor(10 / 255.0f, 15 / 255.0f, 230 / 255.0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        gameWorld.update(delta);
        gameRenderer.render();
    }

    @Override
    public void resize(int width, int height)
    {
        Gdx.app.log("RUNNER", "width: " + width + "\n" + "height: " + height);
    }

    @Override
    public void pause()
    {
        Gdx.app.log("RUNNER", "pause");
    }

    @Override
    public void resume()
    {
        Gdx.app.log("RUNNER", "resume");
    }

    @Override
    public void hide()
    {
        Gdx.app.log("RUNNER", "hide");
    }

    @Override
    public void dispose()
    {
        Gdx.app.log("RUNNER", "dispose");
    }
}
