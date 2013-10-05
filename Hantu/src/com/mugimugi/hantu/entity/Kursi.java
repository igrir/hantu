package com.mugimugi.hantu.entity;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;

public class Kursi extends Furniture{
	public Kursi(TextureRegion textureRegion) {
		super(textureRegion);
	}
	
	public void setPosisiAcak(){
	int acak = MathUtils.random(3);
 		if(acak == 0){
 			setX(0);
 			setY(80);
 		}
 		else if(acak == 1){
 			setX(440);
 			setY(200);
 		}
 		else if(acak == 2){
 			setX(-160);
 			setY(-400);
 		}
 		else{
 			setX(-640);
 			setY(80);
 		}
	}
}
