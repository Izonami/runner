package com.cookforman.runner.controllers;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.cookforman.runner.model.Player;

/**
 * Created by kuksin-mv on 15.03.2016.
 * Предполагается что тут будет вся логика касающаяся обновления объектов
 */
public class GameWorld
{
    private Player player;
    private ScrollHandler scroller;

    private Rectangle ground;

    public enum GameState {READY, RUNNING, GAMEOVER}

    private GameState currentState;

    public GameWorld(int midPointY)
    {
        currentState = GameState.READY;
        player = new Player(33, midPointY - 5, 17, 12);
        scroller = new ScrollHandler(midPointY + 66);

        ground = new Rectangle(0, midPointY + 66, 136, 11);
    }

    /**
     * Принимает дельту для совершения фреймозависимых вычислений
     * @param delta
     */
    public void update(float delta)
    {

        switch (currentState)
        {
            case READY:
                updateReady(delta);
                break;

            case RUNNING:
            default:
                updateRunning(delta);
                break;
        }
    }

    private void updateReady(float delta)
    {
        // Пока что ничего не делаем
    }

    private void updateRunning(float delta)
    {
        player.update(delta);
        scroller.update(delta);

        if(scroller.collides(player))
        {
            scroller.stop();
        }

        if (Intersector.overlaps(player.getBoundingCircle(), ground) || scroller.collides(player))
        {
            currentState = GameState.GAMEOVER;
            scroller.stop();
            player.die();
            player.isGround();
        }
    }

    public boolean isReady()
    {
        return currentState == GameState.READY;
    }

    public void start()
    {
        currentState = GameState.RUNNING;
    }

    public boolean isGameOver()
    {
        return currentState == GameState.GAMEOVER;
    }

    public Player getPlayer()
    {
        return player;
    }

    public ScrollHandler getScroller()
    {
        return scroller;
    }
}
