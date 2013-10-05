package com.mugimugi.hantu.entity;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Wall extends Furniture{
	public Wall(TextureRegion textureRegion) {
		super(textureRegion);
	}
	
	public void setPosisiWall(int i){
		setPosition(-675+(getWidth()*i), 350);
	}
}
