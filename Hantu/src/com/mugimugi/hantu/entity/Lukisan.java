package com.mugimugi.hantu.entity;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Lukisan extends Furniture{
	public Lukisan(TextureRegion textureRegion) {
		super(textureRegion);
	}
	
	public void setPosisiAcak(int i){
		if(i==0){
 			setPosition(-630+40, 360+15);
 		}
 		else if(i==1){
 			setPosition(-360+40, 360+15);
 		}
 		else if(i==2){
 			setPosition(-90+40, 360+15);
 		}
 		else if(i==3){
 			setPosition(180+40, 360+15);
 		}
 		else{
 			setPosition(450+40, 360+15);
 		}
	}
}
