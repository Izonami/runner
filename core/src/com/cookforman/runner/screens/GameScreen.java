package com.cookforman.runner.screens;

import com.badlogic.gdx.Gdx;
import com.cookforman.runner.Runner;
import com.cookforman.runner.controllers.GameWorld;
import com.cookforman.runner.controllers.InputHandler;
import com.cookforman.runner.view.GameRenderer;

/**
 * Created by kuksin-mv on 15.03.2016.
 */
public class GameScreen extends AbstractScreen
{
    private GameWorld gameWorld;
    private GameRenderer gameRenderer;

    private float runTime = 0;

    public GameScreen(final Runner app)
    {
        super(app);

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 136; //136 Это ширина камеры!
        float gameHight = screenHeight / (screenWidth / gameWidth);

        int midPointY = (int) (gameHight / 2); // Это нужно что бы положение было независимо от разрешения экрана

        gameWorld = new GameWorld(midPointY);
        gameRenderer = new GameRenderer(gameWorld, app, (int)gameHight, midPointY);

        Gdx.input.setInputProcessor( new InputHandler(gameWorld)); //Задаем инпут процессор и передаем в него персонажа
    }

    @Override
    public void show()
    {
        Gdx.app.log("RUNNER", "show");
    }

    @Override
    public void render(float delta)
    {
        runTime += delta;

        gameWorld.update(delta);
        gameRenderer.render(runTime);
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
