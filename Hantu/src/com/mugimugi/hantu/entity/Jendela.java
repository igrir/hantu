package com.mugimugi.hantu.entity;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Jendela extends Furniture{
	public Jendela(TextureRegion textureRegion) {
		super(textureRegion);
	}
	
	public void setPosisiJendela(int i){
 		if(i==0){
 			setPosition(-720, 0);
 		}
 		else if(i==1){
 			setPosition(630-180, 0);
 			flip(true, false);
 		}
 		else if(i==2){
 			setPosition(-720, -360);
 		}
 		else{
 			setPosition(630-180, -360);
 			flip(true, false);
 		}
	}
}
