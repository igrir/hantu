//tutuyulan

package com.mugimugi.hantu.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;

public class Relic extends Sprite {
	
	private boolean isFound;
	
	public Relic(TextureRegion textureRegion) {
		super(textureRegion);
		setOrigin(getWidth()/2, getHeight()/2);
	}
	
	public boolean getIsFound() {
		return isFound;
	}

	public void setIsFound(boolean isFound) {
		this.isFound = isFound;
	}
	
	public void setPosisiAcak(int i){
		if(i == 0){
			int acak = MathUtils.random(2);
	 		if(acak == 0){
	 			setX(-320);
	 			setY(40);
	 		}
	 		else if(acak == 1){
	 			setX(-480);
	 			setY(-280);
	 		}
	 		else{
	 			setX(-640);
	 			setY(-280);
	 		}
		}
		else if(i == 1){
			int acak = MathUtils.random(2);
	 		if(acak == 0){
	 			setX(0);
	 			setY(200);
	 		}
	 		else if(acak == 1){
	 			setX(-160);
	 			setY(-280);
	 		}
	 		else{
	 			setX(240);
	 			setY(-500);
	 		}
		}
		else{
			int acak = MathUtils.random(2);
	 		if(acak == 0){
	 			setX(320);
	 			setY(40);
	 		}
	 		else if(acak == 1){
	 			setX(480);
	 			setY(-280);
	 		}
	 		else{
	 			setX(640);
	 			setY(-440);
	 		}
		}
	}
}
