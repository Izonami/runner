package com.cookforman.runner.model;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by kuksin-mv on 22.03.2016.
 */
public class Boll extends GameObject
{

    public Boll(World world, float x, float y, int r, float g, BodyDef.BodyType type)
    {
        super(world);
        setBounds(x, y, r, r);

        CircleShape shape = new CircleShape();
        shape.setRadius(r);

        createBody(shape, type);
        body.setGravityScale(g);
    }

    @Override
    public void draw(Batch batch, float parentAlpha)
    {
        setPosition(body.getPosition().x, body.getPosition().y);
    }
}
