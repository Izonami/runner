package com.cookforman.runner.controllers;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.cookforman.runner.model.Player;

/**
 * Created by kuksin-mv on 15.03.2016.
 * �������������� ��� ��� ����� ��� ������ ���������� ���������� ��������
 */
public class GameWorld
{
    private Circle circle = new Circle(-6, 13, 6);
    private Player player;

    public GameWorld()
    {
        this.player = new Player(-6, 13, circle);
    }

    /**
     * ��������� ������ ��� ���������� ��������������� ����������
     * @param delta
     */
    public void update(float delta)
    {
        //test(delta);
        player.update(delta);
    }

    private void test(float delta)
    {
        // 136 � 204 ��� ������ ������ ��������� � GameRenderer
        circle.x += delta * 20; // �� ������ ����� ������� ������ �� ��� X �� ����� ���������� �� 20
        if (circle.x > 136 + 6) // ���� ������ ����� �� ������� ������ (+ ������ �������, ��� �� �� ������������� �������)
        {
            circle.x = 0 - 6; // ������ ������ � ������ ������ ����� ������ �������, ��� �� �� ��� �� �������� ��-�� �������
            circle.y = MathUtils.random(0 + 6, 204 - 6); // ������ ��������� ��������� �� ��� Y ��� ��������\��������� ������ +6\-6 ��� �� �� ��������� �� �������� ������
        }
    }

    public Circle getCircle()
    {
        return circle;
    }

    public Player getPlayer()
    {
        return player;
    }
}
