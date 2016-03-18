package com.cookforman.runner.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.cookforman.runner.Runner;
import com.cookforman.runner.screens.AbstractScreen;
import com.cookforman.runner.screens.GameScreen;

import static com.cookforman.runner.utils.Constants.TEXTURE_PATH;

/**
 * Created by kuksin-mv on 16.03.2016.
 */
public class AssetLoader extends AbstractScreen
{
    private float progress;

    public AssetLoader(Runner app)
    {
        super(app);

        progress = 0f;
    }

    @Override
    public void show()
    {
        super.show();

        load();
    }

    @Override
    public void render(float delta)
    {
        super.render(delta);

        progress = Interpolation.linear.apply(progress, app.assets.getProgress(), .1f);

        if (app.assets.update() && progress >= app.assets.getProgress() - .001f)
        {
            app.setScreen(new GameScreen(app));
        }

        app.batch.begin();
        app.font.draw(app.batch, "Loading: " + Integer.toString((int)(progress * 100)) + "%", 10, 35);
        app.batch.end();
    }

    private void load()
    {
        app.assets.load(TEXTURE_PATH, Texture.class); //Загружаем текстуру
    }

}
