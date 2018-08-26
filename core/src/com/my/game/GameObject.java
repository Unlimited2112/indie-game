/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author Alexs
 */
public class GameObject
{

    public float x = 0;
    public float y = 0;

    private Texture texture;
    private SpriteBatch spriteBatchHandle;

    public GameObject(String texture_path, SpriteBatch spriteBatchHandle, float posX, float posY)
    {
        this.spriteBatchHandle = spriteBatchHandle;
        texture = new Texture(texture_path);
        x = posX;
        y = posY;
    }

    public void updatePosition()
    {
        int speed = 5;

        x += GameInput.KeyForce.x * speed;
        y += GameInput.KeyForce.y * speed;

    }

    public void Draw()
    {
        spriteBatchHandle.draw(texture, x, y);
    }
}
