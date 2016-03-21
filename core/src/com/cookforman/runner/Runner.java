package com.cookforman.runner;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cookforman.runner.model.AssetLoader;

public class Runner extends Game
{
    public AssetManager assets; //Менеджер ресурсов
    public SpriteBatch batch; //
    public BitmapFont font;

    @Override
    public void create()
    {
        assets = new AssetManager();
        batch = new SpriteBatch();
        font = new BitmapFont();

        setScreen(new AssetLoader(this));
    }

    @Override
    public void dispose()
    {
        super.dispose();

        assets.dispose();
        batch.dispose();
    }
}
