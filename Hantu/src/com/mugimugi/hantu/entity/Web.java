package com.mugimugi.hantu.entity;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Web extends Furniture{
	public Web(TextureRegion textureRegion) {
		super(textureRegion);
	}
	
	public void setPosisiWeb1(){
		setPosition(-90, 360);
	}
	
	public void setPosisiWeb2(int i){
 		if(i==0){
 			rotate(90);
 			setPosition(-720-45, -180+15);
 		}
 		else if(i==1){
 			rotate(90);
 			setPosition(-720-45, 180+15);
 		}
 		else if(i==2){
 			rotate(270);
 			setPosition(630-45, -180+15);
 		}
 		else if(i==3){
 			rotate(270);
 			setPosition(630-45, 180+15);
 		}
 		else if(i==4){
 			setPosition(-630, 450-20);
 		}
 		else if(i==5){
 			setPosition(-360, 450-20);
 		}
 		else if(i==6){
 			setPosition(-90, 450-20);
 		}
 		else if(i==7){
 			setPosition(180, 450-20);
 		}
	}
	
	public void setPosisiWeb3(int i){
 		if(i==0){
 			rotate(270);
 			setPosition(-720, -540-100);
 		}
 		else{
 			setPosition(630, -540);
 		}
	}
}
