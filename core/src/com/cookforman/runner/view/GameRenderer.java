package com.cookforman.runner.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.cookforman.runner.Runner;
import com.cookforman.runner.controllers.GameWorld;
import com.cookforman.runner.controllers.ScrollHandler;
import com.cookforman.runner.model.Player;
import com.cookforman.runner.model.background.Grass;
import com.cookforman.runner.model.background.Pipe;
import com.cookforman.runner.utils.Constants;

import static com.badlogic.gdx.graphics.Texture.TextureFilter.Nearest;

/**
 * Created by kuksin-mv on 15.03.2016.
 * Этот класс будет отрисовывать объекты на экране
 */
public class GameRenderer
{
    private GameWorld gameWorld; //Даём доступ к игровому миру
    private final Runner app;
    private Player player;

    private ScrollHandler scroller;
    private Grass frontGrass, backGrass;
    private Pipe pipe1, pipe2, pipe3;

    private static Texture texture;
    private static TextureRegion bg, grass;
    private static Animation playerAnimation;
    private static TextureRegion playerIdle, playerUp, playerDown;
    private static TextureRegion skullUp, skullDown, bar;

    private OrthographicCamera camera; //Объявляем камеру

    private SpriteBatch batch; //Объявляем батч
    private ShapeRenderer shapeRenderer;

    private int midPointY;
    private int gameHeight;

    /**
     * Так как {@link com.cookforman.runner.screens.GameScreen} имеет доступ к {@link GameWorld} и {@link GameRenderer}
     * то он будет открывать доступ GameRenderer к GameWorld
     * принимая в качестве параметра GameWorld
     * @param gameWorld
     */
    public GameRenderer(final GameWorld gameWorld, final Runner app, int gameHeight, int midPointY)
    {
        this.gameWorld = gameWorld;
        this.app = app;
        this.gameHeight = gameHeight;
        this.midPointY = midPointY;

        camera = new OrthographicCamera();
        camera.setToOrtho(true, 136, 204);

        batch = new SpriteBatch();
        batch.setProjectionMatrix(camera.combined); //Привязывает batch к камере
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);

        initGameObjects();
        initAssets();
    }

    private void initGameObjects()
    {
        player = gameWorld.getPlayer();
        scroller = gameWorld.getScroller();
        frontGrass = scroller.getFrontGrass();
        backGrass = scroller.getBackGrass();
        pipe1 = scroller.getPipe1();
        pipe2 = scroller.getPipe2();
        pipe3 = scroller.getPipe3();
    }

    private void initAssets()
    {
        texture = app.assets.get(Constants.TEXTURE_PATH, Texture.class);
        texture.setFilter(Nearest, Nearest);
        bg = new TextureRegion(texture, 0, 0, 136, 43);
        bg.flip(false, true);
        grass = new TextureRegion(texture, 0, 43, 143, 11);
        playerIdle = new TextureRegion(texture, 153, 0, 17, 12);
        playerIdle.flip(false, true);
        playerDown = new TextureRegion(texture, 136, 0, 17, 12);
        playerDown.flip(false, true);
        playerUp = new TextureRegion(texture, 170, 0, 17, 12);
        playerUp.flip(false, true);
        skullUp = new TextureRegion(texture, 192, 0, 24, 14);
        skullDown = new TextureRegion(skullUp);
        skullDown.flip(false, true);
        bar = new TextureRegion(texture, 136, 16, 22, 3);

        TextureRegion[] birds = { playerDown, playerIdle, playerUp };
        playerAnimation = new Animation(0.06f, birds);
        playerAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
    }

    /**
     * Очень важный мемент, так как отрисовка идет по слоям, то сначала нужно рисовать задники
     * потом уже объекты находящиеся на переднем плане
     * @param runTime
     */
    public void render(float runTime)
    {
        // Без этого объекты будут как бы размазываться по экрану.
        // По сути он обновляет экран и рисует объект заного, что бы он не оставлял "след"
        Gdx.gl.glClearColor(255.0f, 255.0f, 255.0f, 1); // На что конкретно это влияет я пока что не понял, ну кроме цвета бекграунда
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Стартуем ShapeRenderer
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        // Отрисуем Background цвет
        shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
        shapeRenderer.rect(0, 0, 136, midPointY + 66);

        // Отрисуем Dirt
        shapeRenderer.setColor(147 / 255.0f, 80 / 255.0f, 27 / 255.0f, 1);
        shapeRenderer.rect(0, midPointY + 77, 136, 52);

        // Заканчиваем ShapeRenderer
        shapeRenderer.end();

        // Стартуем SpriteBatch
        batch.begin();
        // Отменим прозрачность
        // Это хорошо для производительности, когда отрисовываем картинки без прозрачности
        batch.disableBlending();

        batch.draw(bg, 0, midPointY + 23, 136, 43);
        drawGrass();
        drawPipes();

        // Птичке нужна прозрачность, поэтому включаем ее
        batch.enableBlending();

        drawSkulls();

        // Отрисуем птичку на ее координатах. Получим Animation объект из AssetLoader
        // Передадим runTime переменную чтобы получить текущий кадр.
        if (player.shouldntFlap())
        {
            batch.draw(playerIdle, player.getX(), player.getY(),
                    player.getWidth() / 2.0f, player.getHeight() / 2.0f,
                    player.getWidth(), player.getHeight(), 1, 1, player.getRotation());

        }
        else
        {
            batch.draw(playerAnimation.getKeyFrame(runTime), player.getX(),
                    player.getY(), player.getWidth() / 2.0f,
                    player.getHeight() / 2.0f, player.getWidth(), player.getHeight(),
                    1, 1, player.getRotation());
        }

        // Заканчиваем SpriteBatch
        batch.end();

        testCollision();
    }

    private void testCollision()
    {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.circle(player.getBoundingCircle().x, player.getBoundingCircle().y, player.getBoundingCircle().radius);
        /*
         * Извините за беспорядок ниже. Временный код для теста границ
         * прямоугольников.
         */
        // Верхний блок для труб 1, 2 и 3
        shapeRenderer.rect(pipe1.getBarUp().x, pipe1.getBarUp().y,
                pipe1.getBarUp().width, pipe1.getBarUp().height);
        shapeRenderer.rect(pipe2.getBarUp().x, pipe2.getBarUp().y,
                pipe2.getBarUp().width, pipe2.getBarUp().height);
        shapeRenderer.rect(pipe3.getBarUp().x, pipe3.getBarUp().y,
                pipe3.getBarUp().width, pipe3.getBarUp().height);

        // Нижний блок для труб 1, 2 и 3
        shapeRenderer.rect(pipe1.getBarDown().x, pipe1.getBarDown().y,
                pipe1.getBarDown().width, pipe1.getBarDown().height);
        shapeRenderer.rect(pipe2.getBarDown().x, pipe2.getBarDown().y,
                pipe2.getBarDown().width, pipe2.getBarDown().height);
        shapeRenderer.rect(pipe3.getBarDown().x, pipe3.getBarDown().y,
                pipe3.getBarDown().width, pipe3.getBarDown().height);

        // Черепа для верхних труб 1, 2 и 3
        shapeRenderer.rect(pipe1.getSkullUp().x, pipe1.getSkullUp().y,
                pipe1.getSkullUp().width, pipe1.getSkullUp().height);
        shapeRenderer.rect(pipe2.getSkullUp().x, pipe2.getSkullUp().y,
                pipe2.getSkullUp().width, pipe2.getSkullUp().height);
        shapeRenderer.rect(pipe3.getSkullUp().x, pipe3.getSkullUp().y,
                pipe3.getSkullUp().width, pipe3.getSkullUp().height);

        // Черепа для нижних труб 1, 2 and 3
        shapeRenderer.rect(pipe1.getSkullDown().x, pipe1.getSkullDown().y,
                pipe1.getSkullDown().width, pipe1.getSkullDown().height);
        shapeRenderer.rect(pipe2.getSkullDown().x, pipe2.getSkullDown().y,
                pipe2.getSkullDown().width, pipe2.getSkullDown().height);
        shapeRenderer.rect(pipe3.getSkullDown().x, pipe3.getSkullDown().y,
                pipe3.getSkullDown().width, pipe3.getSkullDown().height);
        shapeRenderer.end();
    }

    private void drawGrass()
    {
        // отрисуем траву
        batch.draw(grass, frontGrass.getX(), frontGrass.getY(), frontGrass.getWidth(), frontGrass.getHeight());
        batch.draw(grass, backGrass.getX(), backGrass.getY(), backGrass.getWidth(), backGrass.getHeight());
    }

    private void drawSkulls()
    {
        // Временный код, извините за кашу :)
        // Мы это починим, как только закончим с Pipe классом.
        batch.draw(skullUp, pipe1.getX() - 1,
                pipe1.getY() + pipe1.getHeight() - 14, 24, 14);
        batch.draw(skullDown, pipe1.getX() - 1,
                pipe1.getY() + pipe1.getHeight() + 45, 24, 14);

        batch.draw(skullUp, pipe2.getX() - 1,
                pipe2.getY() + pipe2.getHeight() - 14, 24, 14);
        batch.draw(skullDown, pipe2.getX() - 1,
                pipe2.getY() + pipe2.getHeight() + 45, 24, 14);

        batch.draw(skullUp, pipe3.getX() - 1,
                pipe3.getY() + pipe3.getHeight() - 14, 24, 14);
        batch.draw(skullDown, pipe3.getX() - 1,
                pipe3.getY() + pipe3.getHeight() + 45, 24, 14);
    }

    private void drawPipes()
    {
        // Временный код, извините за кашу :)
        // Мы это починим, как только закончим с Pipe классом.
        batch.draw(bar, pipe1.getX(), pipe1.getY(), pipe1.getWidth(), pipe1.getHeight());
        batch.draw(bar, pipe1.getX(), pipe1.getY() + pipe1.getHeight() + 45, pipe1.getWidth(), midPointY + 66 - (pipe1.getHeight() + 45));

        batch.draw(bar, pipe2.getX(), pipe2.getY(), pipe2.getWidth(), pipe2.getHeight());
        batch.draw(bar, pipe2.getX(), pipe2.getY() + pipe2.getHeight() + 45, pipe2.getWidth(), midPointY + 66 - (pipe2.getHeight() + 45));

        batch.draw(bar, pipe3.getX(), pipe3.getY(), pipe3.getWidth(), pipe3.getHeight());
        batch.draw(bar, pipe3.getX(), pipe3.getY() + pipe3.getHeight() + 45, pipe3.getWidth(), midPointY + 66 - (pipe3.getHeight() + 45));
    }
}
