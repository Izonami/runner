package com.cookforman.runner.view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.cookforman.runner.Runner;
import com.cookforman.runner.model.Boll;
import com.cookforman.runner.model.Player;
import com.cookforman.runner.screens.AbstractScreen;
import com.cookforman.runner.utils.Constants;

/**
 * Created by kuksin-mv on 15.03.2016.
 * Этот класс будет отрисовывать объекты на экране
 */
public class GameRenderer extends AbstractScreen
{
    private AbstractScreen gameWorld; //Даём доступ к игровому миру

    Player player,player2,player3;
    Boll boll;

    Box2DDebugRenderer renderer;

    private SpriteBatch batch; //Объявляем батч

    /**
     * Так как {@link com.cookforman.runner.screens.GameScreen} имеет доступ к {@link AbstractScreen} и {@link GameRenderer}
     * то он будет открывать доступ GameRenderer к GameWorld
     * принимая в качестве параметра GameWorld
     * @param gameWorld
     */
    public GameRenderer(final Runner app, final AbstractScreen gameWorld)
    {
        super(app);

        this.gameWorld = gameWorld;

        renderer = new Box2DDebugRenderer();

        buildStage();
    }

    /**
     * Очень важный мемент, так как отрисовка идет по слоям, то сначала нужно рисовать задники
     * потом уже объекты находящиеся на переднем плане
     * @param runTime
     */
    public void render(float runTime)
    {
        super.render(runTime);

        renderer.render(getWorld(), this.getCamera().combined);

        getWorld().step(1 / 60f, 4, 4);
    }

    @Override
    public World getWorld()
    {
        return gameWorld.getWorld();
    }

    public void buildStage()
    {
        //System.out.println("Build");
        player = new Player(getWorld(), 0, 0, 1, Constants.GAME_WIDTH, 0, BodyDef.BodyType.StaticBody);
        player2 = new Player(getWorld(), 1, 0, Constants.GAME_WIDTH, 0, 0, BodyDef.BodyType.StaticBody);
        player3 = new Player(getWorld(), 0, Constants.GAME_HEIGHT, 1, Constants.GAME_HEIGHT, 0, BodyDef.BodyType.StaticBody);
        boll = new Boll(getWorld(), 10, 10, 2, 1, BodyDef.BodyType.DynamicBody);

        addActor(boll);
        addActor(player);
        addActor(player2);
        addActor(player3);

        this.setDebugAll(true);
    }
}
