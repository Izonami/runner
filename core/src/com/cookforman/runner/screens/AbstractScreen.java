package com.cookforman.runner.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.cookforman.runner.Runner;
import com.cookforman.runner.utils.Constants;

import static com.cookforman.runner.utils.Constants.FOG;

/**
 * Created by kuksin-mv on 18.03.2016.
 */
public abstract class AbstractScreen extends Stage implements Screen
{
    protected final Runner app;
    private final float r = 0f, g = 0f, b = 0f, a = 0f;

    public AbstractScreen(final Runner app)
    {
        super(new StretchViewport(Constants.GAME_WIDTH/8, Constants.GAME_HEIGHT/8));

        this.app = app;
    }

    @Override
    public void show()
    {
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta)
    {
        // Без этого объекты будут как бы размазываться по экрану.
        // По сути он обновляет экран и рисует объект заного, что бы он не оставлял "след"
        Gdx.gl.glClearColor(r, g, b, a); // На что конкретно это влияет я пока что не понял, ну кроме цвета бекграунда
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT | (Gdx.graphics.getBufferFormat().coverageSampling ? GL20.GL_COVERAGE_BUFFER_BIT_NV : 0));

        super.act(delta);
        super.draw();
    }

    @Override
    public void resize(int width, int height)
    {
        Gdx.app.log(FOG, "Resizing screen: " + getName() + " to: " + width + " x " + height);
        getViewport().update(width, height, true);
    }

    @Override
    public void pause()
    {
        Gdx.app.log(FOG, "Pause screen: " + getName());
    }

    @Override
    public void resume()
    {
        Gdx.app.log(FOG, "Resume screen: " + getName());
    }

    @Override
    public void hide()
    {
        Gdx.app.log(FOG, "Hide screen: " + getName());
    }

    @Override
    public void dispose()
    {
        Gdx.app.log(FOG, "Dispose screen: " + getName());
    }

    private String getName()
    {
        return getClass().getSimpleName();
    }

    public abstract World getWorld();
}
