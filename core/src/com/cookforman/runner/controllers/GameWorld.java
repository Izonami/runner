package com.cookforman.runner.controllers;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.cookforman.runner.model.Player;

/**
 * Created by kuksin-mv on 15.03.2016.
 * Предполагается что тут будет вся логика касающаяся обновления объектов
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
     * Принимает дельту для совершения фреймозависимых вычислений
     * @param delta
     */
    public void update(float delta)
    {
        //test(delta);
        player.update(delta);
    }

    private void test(float delta)
    {
        // 136 и 204 это размер камеры указанной в GameRenderer
        circle.x += delta * 20; // На каждый фрейм двигаем объект по оси X на фрейм умноженный на 20
        if (circle.x > 136 + 6) // Если объект вышел за границу экрана (+ размер объекта, что бы он действительно скрылся)
        {
            circle.x = 0 - 6; // Ставим объект в начало экрана минус размер объекта, что бы он как бы выплывал из-за границы
            circle.y = MathUtils.random(0 + 6, 204 - 6); // Задаем рандомное положение по оси Y для минимума\максимума делаем +6\-6 что бы не появлялся за границей экрана
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
