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
 * ���� ����� ����� ������������ ������� �� ������
 */
public class GameRenderer
{
    private GameWorld gameWorld; //��� ������ � �������� ����
    private final Runner app;
    private Player player;

    private OrthographicCamera camera; //��������� ������

    private SpriteBatch batch; //��������� ����

    /**
     * ��� ��� {@link com.cookforman.runner.screens.GameScreen} ����� ������ � {@link GameWorld} � {@link GameRenderer}
     * �� �� ����� ��������� ������ GameRenderer � GameWorld
     * �������� � �������� ��������� GameWorld
     * @param gameWorld
     */
    public GameRenderer(final GameWorld gameWorld, final Runner app)
    {
        this.app = app;
    }

    /**
     * ����� ������ ������, ��� ��� ��������� ���� �� �����, �� ������� ����� �������� �������
     * ����� ��� ������� ����������� �� �������� �����
     * @param runTime
     */
    public void render(float runTime)
    {
        // ��� ����� ������� ����� ��� �� ������������� �� ������.
        // �� ���� �� ��������� ����� � ������ ������ ������, ��� �� �� �� �������� "����"
        Gdx.gl.glClearColor(255.0f, 255.0f, 255.0f, 1); // �� ��� ��������� ��� ������ � ���� ��� �� �����, �� ����� ����� ����������
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


    }
}
