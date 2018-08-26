/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 *
 * @author Alexs
 */
public class TextManager
{
    private static BitmapFont bitmapFont = new BitmapFont();
    private static SpriteBatch spriteBatchHandle;
    
    public static void SetSpriteBatch(SpriteBatch batch)
    {
        spriteBatchHandle = batch;
    }
    public static void Draw(CharSequence msg, OrthographicCamera orthographicCamera)
    {
        Vector3 position = new Vector3(10,20,0);
        orthographicCamera.unproject(position);
        bitmapFont.draw(spriteBatchHandle, msg, position.x,position.y);
    }
}
