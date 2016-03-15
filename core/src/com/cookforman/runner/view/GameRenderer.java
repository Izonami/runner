package com.cookforman.runner.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.cookforman.runner.controllers.GameWorld;

/**
 * Created by kuksin-mv on 15.03.2016.
 * Этот класс будет отрисовывать объекты на экране
 */
public class GameRenderer
{
    private GameWorld gameWorld; //Даём доступ к игровому миру
    private OrthographicCamera camera;

    //Секция для тестирования
    private ShapeRenderer shapeRenderer;

    /**
     * Так как {@link com.cookforman.runner.screens.GameScreen} имеет доступ к {@link GameWorld} и {@link GameRenderer}
     * то он будет открывать доступ GameRenderer к GameWorld
     * принимая в качестве параметра GameWorld
     * @param gameWorld
     */
    public GameRenderer(final GameWorld gameWorld)
    {
        this.gameWorld = gameWorld;
        camera = new OrthographicCamera();
        camera.setToOrtho(true, 136, 204);

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);
    }

    public void render()
    {
        // Без этого объекты будут как бы размазываться по экрану.
        // По сути он обновляет экран и рисует объект заного, что бы он не оставлял "след"
        Gdx.gl.glClearColor(255.0f, 255.0f, 255.0f, 1); // На что конкретно это влияет я пока что не понял, ну кроме цвета бекграунда
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        test();
    }

    private void test()
    {
        /**
         * Filled - заполняет
         * Line - обрисовывает
         */
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        shapeRenderer.setColor(87 / 255.0f, 109 / 255.0f, 120 / 255.0f, 1);
        shapeRenderer.circle(gameWorld.getCircle().x, gameWorld.getCircle().y, gameWorld.getCircle().radius);

        shapeRenderer.end();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);

        shapeRenderer.setColor(255 / 255.0f, 109 / 255.0f, 120 / 255.0f, 1);
        shapeRenderer.circle(gameWorld.getCircle().x, gameWorld.getCircle().y, gameWorld.getCircle().radius);

        shapeRenderer.end();
    }
}
