package com.cookforman.runner.model.background;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.cookforman.runner.model.Player;

import java.util.Random;

/**
 * Created by kuksin-mv on 16.03.2016.
 */
public class Pipe extends Scrollable
{
    private Random r;

    private Rectangle skullUp, skullDown, barUp, barDown;

    public static final int VERTICAL_GAP = 45;
    public static final int SKULL_WIDTH = 24;
    public static final int SKULL_HEIGHT = 11;
    private float groundY;

    public Pipe(float x, float y, int width, int height, float scrollSpeed, float groundY)
    {
        super(x, y, width, height, scrollSpeed);

        // �������������� ������ ���� Random ��� ��������� ��������� �����
        r = new Random();

        skullUp = new Rectangle();
        skullDown = new Rectangle();
        barUp = new Rectangle();
        barDown = new Rectangle();

        this.groundY = groundY;
    }

    @Override
    public void update(float delta)
    {
        // �������� ����� update � ������������ ������ (Scrollable)
        super.update(delta);

        // ����� set() ��������� ��� ��������� ���������� ������ �������� ���� - x, y
        // ������ � width � height

        barUp.set(position.x, position.y, width, height);
        barDown.set(position.x, position.y + height + VERTICAL_GAP, width,
                groundY - (position.y + height + VERTICAL_GAP));

        // ������ ������ 24 �������. ������ ����� ����� 22 �������. ��� ��� �����
        // ������ ���� ������ �� 1 ������� ����� (��� ��� ����� ����� �������������
        // ������������ �����).

        // This shift is equivalent to: (SKULL_WIDTH - width) / 2
        skullUp.set(position.x - (SKULL_WIDTH - width) / 2, position.y + height
                - SKULL_HEIGHT, SKULL_WIDTH, SKULL_HEIGHT);
        skullDown.set(position.x - (SKULL_WIDTH - width) / 2, barDown.y,
                SKULL_WIDTH, SKULL_HEIGHT);

    }

    @Override
    public void reset(float newX)
    {
        super.reset(newX);
        // �������� ������ �������� �� ��������� ��������
        height = r.nextInt(90) + 15;
    }

    public Rectangle getSkullUp() {
        return skullUp;
    }

    public Rectangle getSkullDown() {
        return skullDown;
    }

    public Rectangle getBarUp() {
        return barUp;
    }

    public Rectangle getBarDown() {
        return barDown;
    }

    public boolean collides(Player player)
    {
        //� ������ ���� ������� �������� �������, ������ ��������� ������(+ ��� ������)
        if (position.x < player.getX() + player.getWidth())
        {
            return (Intersector.overlaps(player.getBoundingCircle(), skullUp) ||
                    Intersector.overlaps(player.getBoundingCircle(), skullDown) ||
                    Intersector.overlaps(player.getBoundingCircle(), barUp) ||
                    Intersector.overlaps(player.getBoundingCircle(), barDown));
        }
        return false;
    }
}
