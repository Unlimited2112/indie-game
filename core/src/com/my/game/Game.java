package com.my.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.sun.javafx.font.FontConstants;

public class Game extends ApplicationAdapter
{

    SpriteBatch batch;
    Texture img;
    GameObject gameObject;

    TiledMap tiledMap;
    OrthographicCamera orthographicCamera;
    TiledMapRenderer tiledMapRenderer;

    @Override
    public void create()
    {
        batch = new SpriteBatch();

        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        orthographicCamera = new OrthographicCamera();
        orthographicCamera.setToOrtho(false, width, height);
        orthographicCamera.update();
        tiledMap = new TmxMapLoader().load("testlvl.tmx");

        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);

        TextManager.SetSpriteBatch(batch);
        gameObject = new GameObject("badlogic.jpg", batch, 0, 0);

    }

    @Override
    public void render()
    {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        
        GameInput.Update();
        gameObject.updatePosition();
        orthographicCamera.position.set(gameObject.x, gameObject.y, 0);
        orthographicCamera.update();
        tiledMapRenderer.setView(orthographicCamera);
        tiledMapRenderer.render();

        batch.begin();
        batch.setProjectionMatrix(orthographicCamera.combined);

        gameObject.Draw();
        TextManager.Draw("X: " + gameObject.x + " Y: " + gameObject.y, orthographicCamera);
        batch.end();
    }

    @Override
    public void dispose()
    {
        batch.dispose();
        img.dispose();
    }
}
