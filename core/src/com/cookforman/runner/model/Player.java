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
    public Player(World world, float x, float y, int w, int h, float g, BodyDef.BodyType type)
    {
        super(world);
        setPosition(x, y);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(w, h/3);

        createBody(shape, type);
        body.setGravityScale(g);
    }

    @Override
    public void draw(Batch batch, float parentAlpha)
    {
        setPosition(body.getPosition().x, body.getPosition().y);
    }

}
