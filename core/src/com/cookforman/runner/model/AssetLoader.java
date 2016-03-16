package com.cookforman.runner.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import static com.badlogic.gdx.graphics.Texture.TextureFilter.Nearest;

/**
 * Created by kuksin-mv on 16.03.2016.
 */
public class AssetLoader
{
    public static Texture texture;
    public static TextureRegion bg, grass;

    public static Animation playerAnimation;
    public static TextureRegion idle, up, down;

    public static TextureRegion skullUp, skullDown, bar;

    public static void load()
    {
        //��������� ��������
        texture = new Texture(Gdx.files.internal("data/texture.png"));
        //����������� ������, ��� �� ��� ���������� �������� �� �����������
        texture.setFilter(Nearest, Nearest);

        //�������� �� ����� �������� ������� � ������ �����
        bg = new TextureRegion(texture, 0, 0, 136, 43); // ���������� � ������ �������� ���� ��������
        bg.flip(false, true);

        //�������� �������� ��� �����
        grass = new TextureRegion(texture, 0, 43, 143, 11);
        grass.flip(false, true);

        // ���� � ���������� ���������
        down = new TextureRegion(texture, 136, 0, 17, 12);
        down.flip(false, true);

        idle = new TextureRegion(texture, 153, 0, 17, 12);
        idle.flip(false, true);

        up = new TextureRegion(texture, 170, 0, 17, 12);
        up.flip(false, true);

        //������� ������ �� ������� ���������
        TextureRegion[] birds = { down, idle, up };
        playerAnimation = new Animation(0.06f, birds); //������ �������� ��� ������������ ������. ����� - ���� ������� �������
        // ���������� ����� ������������
        playerAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG); //LOOP_PINGPONG - down, idle, up, idle, down, ...

        skullUp = new TextureRegion(texture, 192, 0, 24, 14);
        skullDown = new TextureRegion(skullUp);
        skullDown.flip(false, true);

        bar = new TextureRegion(texture, 136, 16, 22, 3);
        bar.flip(false, true);
    }

    public static void dispose()
    {
        texture.dispose();
    }
}
