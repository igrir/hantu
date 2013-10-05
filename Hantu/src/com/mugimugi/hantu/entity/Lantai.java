package com.mugimugi.hantu.entity;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Lantai extends Furniture{
	public Lantai(TextureRegion textureRegion) {
		super(textureRegion);
	}
	public void setPosisiLantai(int i, int j){
		setX(-getWidth()*(8-(i+1)));
		setY(getWidth()*(4-(j+1)));
	}
}
