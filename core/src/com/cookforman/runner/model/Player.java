package com.cookforman.runner.model;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by kuksin-mv on 15.03.2016.
 */
public class Player
{
    private Circle circle;

    private Vector2 position; //Положение объекта
    private Vector2 velocity; //Передвижение объекта
    private Vector2 acceleration; //Ускорение объекта

    private float rotation; // Поворот объекта
    // Размеры объекта
    private int width;
    private int height;

    public Player(float x , float y)
    {
        this.position = new Vector2(x, y);
        this.velocity = new Vector2(0, 0);
        this.acceleration = new Vector2(0, 460);
    }

    public Player(float x, float y, int width, int height)
    {
        this(x, y);
        this.width = width;
        this.height = height;
    }

    public Player(float x, float y, Circle circle)
    {
        this(x, y);
        this.circle = circle;
    }

    public void update(float delta)
    {
        velocity.add(acceleration.scl(delta));

        if(velocity.y > 200)
            velocity.y = 200;

        position.add(velocity.scl(delta));
    }

    public void onClick()
    {
        velocity.y = -140;
    }

    public float getX()
    {
        return position.x;
    }

    public float getY()
    {
        return position.y;
    }

    public float getWidth()
    {
        return width;
    }

    public float getHeight()
    {
        return height;
    }

    public float getRotation()
    {
        return rotation;
    }

}
