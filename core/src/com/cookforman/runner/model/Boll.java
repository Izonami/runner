package com.cookforman.runner.model;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;

/**
 * Created by kuksin-mv on 22.03.2016.
 */
public class Boll extends GameObject
{
    final static float MAX_VELOCITY = 3f;
    public final static float SPEED = 5f;
    public final static float SIZE = 0.8f;

    Fixture playerPhysicsFixture;
    Fixture playerSensorFixture;
    Body box;

    public Boll(Body b)
    {
        super(b);

        box = b;
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(1f, 1f);

        playerPhysicsFixture = box.createFixture(shape, 3);
        shape.dispose();

        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(2f);
        circleShape.setPosition(new Vector2(0f,0f));
        playerSensorFixture = box.createFixture(circleShape, 1);

        setFriction(10f);
        circleShape.dispose();

        //box.setBullet(true);
    }

    public Body getBody()
    {
        return body;
    }

    public void setFriction(float f)
    {
        playerSensorFixture.setFriction(f);
        playerPhysicsFixture.setFriction(f);
    }

    public Vector2 getPosition()
    {
        return box.getPosition();
    }

    public Vector2 getVelocity()
    {
        return velocity;
    }

    Vector2 	velocity = new Vector2();

    public void update(float delta)
    {
        Vector2 vel = box.getLinearVelocity();
        velocity.y = vel.y;
        box.setLinearVelocity(velocity);
        if(isJump)
        {
            box.applyLinearImpulse(0, 8, box.getPosition().x,  box.getPosition().y, false);
            isJump = false;
        }

    }

    boolean isJump = false;

    public void jump()
    {
        isJump = true;
    }

    public void resetVelocity()
    {
        getVelocity().x =0;
        getVelocity().y =0;
    }

}
