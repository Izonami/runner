package com.cookforman.runner;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cookforman.runner.screens.ScreenEnum;
import com.cookforman.runner.screens.ScreenManager;

public class Runner extends Game
{
    public AssetManager assets; //�������� ��������
    public SpriteBatch batch; //�������� ���������
    public BitmapFont font; //�������� �������

    @Override
    public void create()
    {
        assets = new AssetManager();
        batch = new SpriteBatch();
        font = new BitmapFont();

        //���������� �������� �������
        ScreenManager.getInstanse().init(this);
        ScreenManager.getInstanse().showScreen(this, ScreenEnum.LOAD);
    }

    @Override
    public void dispose()
    {
        super.dispose();

        assets.dispose();
        batch.dispose();
    }
}
