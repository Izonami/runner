package com.cookforman.runner.model;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Izonami on 21.03.2016.
 */
public abstract class GameObject extends Actor
{
    protected Sprite sprite;
    protected Body body;

    private World world;

    public GameObject(World world)
    {
        this.world = world;
    }

    public GameObject(Body body)
    {
        this.body = body;
    }

    protected void createBody(Shape shape, BodyType type)
    {
        //���������� ��� ����, �������� ��� ������ � ������� ����
        BodyDef bDef = new BodyDef();
        bDef.position.set(getX(), getY());
        /**
         * BodyType - ��� ����.
         * static(�����, ���) - ������� �����, ������� ��������, ������������� ������ ���������� (��� ����������� �� ����������� � ������� ����)
         * kinematic - ������� �����, �� ������� ��������, ����� ���� �������
         * dynamic - ������������� �����, �� ������� ��������, ����� ���� �������
         */
        bDef.type = type;

        body = world.createBody(bDef);

        FixtureDef fDef = new FixtureDef();
        fDef.shape = shape;
        fDef.restitution = 0;
        fDef.friction = 1;
        fDef.density = 5;

        body.createFixture(fDef);
    }
}
