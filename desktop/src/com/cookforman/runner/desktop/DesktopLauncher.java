package com.cookforman.runner.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.cookforman.runner.Runner;

public class DesktopLauncher
{
	public static void main (String[] arg)
	{
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Runner";
        config.width = 272;
        config.height = 408;
		new LwjglApplication(new Runner(), config);
	}
}
