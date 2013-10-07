//tutuyulan

package com.mugimugi.hantu.entity;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Kunti extends Character {
	private int stabbed;
	private float muncul;
	
	public Kunti(TextureRegion textureRegion) {
		super(textureRegion);
		setAtk(1.5f);
		setSpeed(60);
		setHealth(200);
		setMuncul(120);
	}
	
	public int getStabbed(){
		return stabbed;
	}
	public void setStabbed(int stabbed){
		this.stabbed = stabbed;
	}
	public float getMuncul(){
		return muncul;
	}
	public void setMuncul(float muncul){
		this.muncul = muncul;
	}
	
}
