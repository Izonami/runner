package com.cookforman.runner.model;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by kuksin-mv on 15.03.2016.
 */
public class Player extends GameObject
{
    private Circle boundingCircle;

    private Vector2 velocity; //Передвижение объекта
    private Vector2 acceleration; //Ускорение объекта

    private float rotation; // Поворот объекта

    private boolean isAlive;

    public Player(float x , float y, int width, int height)
    {
        super(x, y, width, height);
        this.velocity = new Vector2(0, 0);
        this.acceleration = new Vector2(0, 460);

        boundingCircle = new Circle();

        isAlive = true;
    }

    public void update(float delta)
    {
        velocity.add(acceleration.scl(delta));
        acceleration.scl(1/delta);

        if(velocity.y > 200)
            velocity.y = 200;

        // проверяем потолок
        if (position.y < -13)
        {
            position.y = -13;
            velocity.y = 0;
        }

        position.add(velocity.cpy().scl(delta));
        boundingCircle.set(position.x + 9, position.y + 6, 6.5f);

        // повернуть против часовой стрелки
        if (velocity.y < 0)
        {
            rotation -= 600 * delta;

            if (rotation < -20)
            {
                rotation = -20;
            }
        }

        // Повернуть по часовой стрелке
        if (isFalling() || !isAlive)
        {
            rotation += 480 * delta;
            if (rotation > 35)
            {
                rotation = 35;
            }

        }
    }

    public void onClick()
    {
        if(isAlive)
            velocity.y = -100;
    }

    public float getX()
    {
        return position.x;
    }

    public float getY()
    {
        return position.y;
    }

    public boolean isFalling()
    {
        return velocity.y > 110;
    }

    public boolean shouldntFlap()
    {
        return velocity.y > 70 || !isAlive;
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

    public Circle getBoundingCircle()
    {
        return boundingCircle;
    }

    public boolean isAlive()
    {
        return isAlive;
    }

    public void die()
    {
        isAlive = false;
        velocity.y = 0;
    }

    public void isGround()
    {
        acceleration.y = 0;
        velocity.y = 0;
    }

}
