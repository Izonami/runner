package com.cookforman.runner.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.cookforman.runner.Runner;
import com.cookforman.runner.screens.AbstractScreen;

/**
 * Created by kuksin-mv on 15.03.2016.
 * Этот класс будет отрисовывать объекты на экране
 */
public class GameRenderer implements Screen
{
    private static final float r = 0f, g = 0f, b = 0f, a = 0f;

    private final Runner app;
    private final AbstractScreen screen;

    public GameRenderer(final Runner app, final AbstractScreen screen)
    {
        this.app = app;
        this.screen = screen;
    }

    @Override
    public void show()
    {
        Gdx.input.setInputProcessor(screen);
    }

    @Override
    public void render(float delta)
    {
        // Без этого объекты будут как бы размазываться по экрану.
        // По сути он обновляет экран и рисует объект заного, что бы он не оставлял "след"
        Gdx.gl.glClearColor(r, g, b, a); // На что конкретно это влияет я пока что не понял, ну кроме цвета бекграунда
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT | (Gdx.graphics.getBufferFormat().coverageSampling ? GL20.GL_COVERAGE_BUFFER_BIT_NV : 0));

        screen.act(delta);
        screen.draw();

        screen.render(delta);


    }

    @Override
    public void resize(int width, int height)
    {
        screen.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
