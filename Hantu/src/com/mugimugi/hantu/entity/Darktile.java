package com.mugimugi.hantu.entity;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Darktile extends Furniture{
	public Darktile(TextureRegion textureRegion) {
		super(textureRegion);
	}
	public void setPosisiLantai(int i, int j){
		setY(getWidth()*(3-j));
		if(i==0){
			setX(-720);
		}
		else{
			setX(630);
		}
	}
}
