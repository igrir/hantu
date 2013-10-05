package com.mugimugi.hantu.entity;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;

public class Lemari extends Furniture{
	public Lemari(TextureRegion textureRegion) {
		super(textureRegion);
	}
	
	public void setPosisiAcak(){

		int acak = MathUtils.random(2);
 		if(acak == 0){
 			setX(0);
 			setY(-400);
 		}
 		else if(acak == 1){
 			setX(540);
 			setY(-80);
 		}
 		else{
 			setX(-640);
 			setY(-240);
 		}
	}
}
