package com.cookforman.runner.model;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by kuksin-mv on 23.03.2016.
 */
public class Background extends GameObject
{

    public Background(World world)
    {
        super(world);
        setBounds(0, 0, 50, 50);

        ChainShape shape = new ChainShape();
        shape.createChain(
                new Vector2[]
                        {
                                new Vector2(0, 60),
                                new Vector2(0,0),
                                new Vector2(60, 0),
                                new Vector2(60, 60),
                                new Vector2(0,60)
        });

        createBody(shape, BodyDef.BodyType.StaticBody);
    }
}
