package com.cookforman.runner.controllers;

import com.badlogic.gdx.InputProcessor;
import com.cookforman.runner.model.Player;

/**
 * Created by kuksin-mv on 16.03.2016.
 */
public class InputHandler implements InputProcessor
{
    private Player player;
    private GameWorld gameWorld;

    public InputHandler(GameWorld gameWorld)
    {
        this.gameWorld = gameWorld;
        player = gameWorld.getPlayer();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button)
    {
        if (gameWorld.isReady())
        {
            gameWorld.start();
        }
        player.onClick();

        return true; // �������� ��� �� ���������� �������
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
