//player

package com.mugimugi.hantu.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Player extends Sprite {
	
	private int speed;
	private int stress;
	private int atk;
	
	public Player(TextureRegion textureRegion) {
		super(textureRegion);
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getStress() {
		return stress;
	}

	public void setStress(int stress) {
		this.stress = stress;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}
}
