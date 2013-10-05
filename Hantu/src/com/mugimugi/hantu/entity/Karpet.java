package com.mugimugi.hantu.entity;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;

public class Karpet extends Furniture{
	public Karpet(TextureRegion textureRegion) {
		super(textureRegion);
	}
	
	public void setPosisiAcak(){
		int acak = MathUtils.random(2);
 		
		if(acak == 0){
 			setX(-480);
 			setY(40);
 		}
 		else if(acak == 1){
 			setX(480);
 			setY(-120);
 		}
 		else{
 			setX(-480);
 			setY(-500);
 		}
	}
}
