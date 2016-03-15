package com.cookforman.runner.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.cookforman.runner.controllers.GameWorld;

/**
 * Created by kuksin-mv on 15.03.2016.
 * ���� ����� ����� ������������ ������� �� ������
 */
public class GameRenderer
{
    private GameWorld gameWorld; //��� ������ � �������� ����
    private OrthographicCamera camera;

    //������ ��� ������������
    private ShapeRenderer shapeRenderer;

    /**
     * ��� ��� {@link com.cookforman.runner.screens.GameScreen} ����� ������ � {@link GameWorld} � {@link GameRenderer}
     * �� �� ����� ��������� ������ GameRenderer � GameWorld
     * �������� � �������� ��������� GameWorld
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
        // ��� ����� ������� ����� ��� �� ������������� �� ������.
        // �� ���� �� ��������� ����� � ������ ������ ������, ��� �� �� �� �������� "����"
        Gdx.gl.glClearColor(255.0f, 255.0f, 255.0f, 1); // �� ��� ��������� ��� ������ � ���� ��� �� �����, �� ����� ����� ����������
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        test();
    }

    private void test()
    {
        /**
         * Filled - ���������
         * Line - ������������
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
