package com.cookforman.runner.model;

import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Izonami on 21.03.2016.
 */
public abstract class GameObject extends Actor
{
    public GameObject(float x , float y, int width, int height)
    {
        setSize(width, height);
        setPosition(x, y);
    }
}
