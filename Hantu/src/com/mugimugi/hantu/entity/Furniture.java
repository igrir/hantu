package com.mugimugi.hantu.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Furniture extends Sprite{
	public Furniture(TextureRegion textureRegion) {
		super(textureRegion);
		setOrigin(getWidth()/2, getHeight()/2);
	}
}
