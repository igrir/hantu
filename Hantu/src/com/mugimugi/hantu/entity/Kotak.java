package com.mugimugi.hantu.entity;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;

public class Kotak extends Furniture{
	public Kotak(TextureRegion textureRegion) {
		super(textureRegion);
	}
	
	public void setPosisiAcak(int i){
		if(i == 0){
			int acak = MathUtils.random(1);
			
	 		if(acak == 0){
	 			setX(-320);
	 			setY(-80);
	 		}
	 		else{
	 			setX(160);
	 			setY(-80);
	 		}
		}
		else{
			int acak = MathUtils.random(1);
			
	 		if(acak == 0){
	 			setX(-640);
	 			setY(240);
	 		}
	 		else{
	 			setX(640);
	 			setY(80);
	 		}
		}
	}
}
