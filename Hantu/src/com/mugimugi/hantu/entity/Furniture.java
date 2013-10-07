package com.mugimugi.hantu.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Furniture extends Sprite{
	private Rectangle rec;
	private boolean isDestroyed;
	
	public Furniture(TextureRegion textureRegion) {
		super(textureRegion);
		setOrigin(getWidth()/2, getHeight()/2);
		rec = new Rectangle();
		isDestroyed = false;
	}
	
	public boolean getIsDestroyed(){
		return isDestroyed;
	}
	
	public void setIsDestroyed(boolean isDestroyed){
		this.isDestroyed = isDestroyed;
	}
	
	public void setRectangle(float x, float y, float width, float height){
		rec.set(x, y, width, height);
	}
	
	public Rectangle getRectangle(){
		return this.rec;
	}
	
	public void remove(){
		setPosition(0,0);
		setSize(0,0);
		setRectangle(0,0,0,0);
	}
}
