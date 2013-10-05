package com.mugimugi.hantu.entity;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Cermin extends Furniture{
	public Cermin(TextureRegion textureRegion) {
		super(textureRegion);
	}
	
	public void setPosisiAcak(int i){
		if(i==0){
 			setPosition(-630+30, 360-25);
 		}
 		else if(i==1){
 			setPosition(-360+30, 360-25);
 		}
 		else if(i==2){
 			setPosition(-90+30, 360-25);
 		}
 		else if(i==3){
 			setPosition(180+30, 360-25);
 		}
 		else{
 			setPosition(450+30, 360-25);
 		}
	}
}
