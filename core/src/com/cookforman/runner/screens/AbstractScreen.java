package com.cookforman.runner.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.cookforman.runner.Runner;

import static com.cookforman.runner.utils.Constants.FOG;

/**
 * Created by kuksin-mv on 18.03.2016.
 */
public abstract class AbstractScreen implements Screen
{
    protected final Runner app;

    private final float r = 0f, g = 0f, b = 0f, a = 0f;
    private Camera camera;
    private int width = Gdx.graphics.getWidth();
    private int height = Gdx.graphics.getHeight();

    public AbstractScreen(final Runner app)
    {
        this.app = app;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(r, g, b, a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT | (Gdx.graphics.getBufferFormat().coverageSampling ? GL20.GL_COVERAGE_BUFFER_BIT_NV : 0));
    }

    @Override
    public void resize(int width, int height)
    {
        Gdx.app.log(FOG, "Resizing screen: " + getName() + " to: " + width + " x " + height);
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

    public Camera getCamera()
    {
        return camera;
    }

    public void setCamera(Camera camera)
    {
        this.camera = camera;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    private String getName()
    {
        return getClass().getSimpleName();
    }
}
