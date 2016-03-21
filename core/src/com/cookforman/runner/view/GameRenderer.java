package com.cookforman.runner.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cookforman.runner.Runner;
import com.cookforman.runner.controllers.GameWorld;
import com.cookforman.runner.model.Player;

/**
 * Created by kuksin-mv on 15.03.2016.
 * Этот класс будет отрисовывать объекты на экране
 */
public class GameRenderer
{
    private GameWorld gameWorld; //Даём доступ к игровому миру
    private final Runner app;
    private Player player;

    private OrthographicCamera camera; //Объявляем камеру

    private SpriteBatch batch; //Объявляем батч

    /**
     * Так как {@link com.cookforman.runner.screens.GameScreen} имеет доступ к {@link GameWorld} и {@link GameRenderer}
     * то он будет открывать доступ GameRenderer к GameWorld
     * принимая в качестве параметра GameWorld
     * @param gameWorld
     */
    public GameRenderer(final GameWorld gameWorld, final Runner app)
    {
        this.app = app;
    }

    /**
     * Очень важный мемент, так как отрисовка идет по слоям, то сначала нужно рисовать задники
     * потом уже объекты находящиеся на переднем плане
     * @param runTime
     */
    public void render(float runTime)
    {
        // Без этого объекты будут как бы размазываться по экрану.
        // По сути он обновляет экран и рисует объект заного, что бы он не оставлял "след"
        Gdx.gl.glClearColor(255.0f, 255.0f, 255.0f, 1); // На что конкретно это влияет я пока что не понял, ну кроме цвета бекграунда
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


    }
}
