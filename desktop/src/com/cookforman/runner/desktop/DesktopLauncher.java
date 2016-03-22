package com.cookforman.runner.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.cookforman.runner.Runner;
import com.cookforman.runner.utils.Constants;

public class DesktopLauncher
{
	public static void main (String[] arg)
	{
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Runner";
        config.width = Constants.GAME_WIDTH;
        config.height = Constants.GAME_HEIGHT;
		new LwjglApplication(new Runner(), config);
	}
}
