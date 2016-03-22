package com.cookforman.runner.model;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by kuksin-mv on 15.03.2016.
 */
public class Player extends GameObject
{
    public Player(World world, int width, int height)
    {
        super(world, width, height);
        setBounds(10, 40, 1, 2);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(1, 2);

        createBody(shape, BodyDef.BodyType.DynamicBody);
    }

    @Override
    public void draw(Batch batch, float parentAlpha)
    {
        setPosition(body.getPosition().x, body.getPosition().y);
    }

}
