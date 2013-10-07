//tutuyulan

package com.mugimugi.hantu.entity;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;

public class Tuyul extends Character{
	private int trayek;
	
	public Tuyul(TextureRegion textureRegion) {
		super(textureRegion);
		float hp = MathUtils.random(50, 100);
 		setHealth(hp);
	}
	
	public void setTrayek(int trayek){
		this.trayek = trayek;
	}
	
	public int getTrayek(){
		return trayek;
	}
	
	public void setPosisiAcak(){
		int acak = MathUtils.random(6);
		
 		if(acak == 0){
 			setX(-640);
 			setY(300);
 		}
 		else if(acak == 1){
 			setX(-160);
 			setY(-80);
 		}
 		else if(acak == 2){
 			setX(160);
 			setY(300);
 		}
 		else if(acak == 3){
 			setX(320);
 			setY(300);
 		}
 		else if(acak == 4){
 			setX(640);
 			setY(-500);
 		}
 		else if(acak == 5){
 			setX(160);
 			setY(-340);
 		}
 		else{
 			setX(-320);
 			setY(-500);
 		}
 		
 		trayek = acak;
 		
 		float velo = MathUtils.random(40, 60);
 		float serang = MathUtils.random(0.4f, 0.5f);
 		
 		setSpeed(velo);
 		setAtk(serang);
	}
	
	public void respawnTuyul(){
		if(MathUtils.random(1) == 0){
			setIsKilled(false);
			float hp = MathUtils.random(50, 100);
	 		setHealth(hp);
			setPosisiAcak();
			setSize(90f, 90f);
			setRectangle(getX(), getY(), getWidth(), getHeight());
		}
	}
}
