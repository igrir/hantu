//player

package com.mugimugi.hantu.entity;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Player extends Character{		
	public Player(TextureRegion textureRegion) {
		super(textureRegion);
		setAtk(0.35f);
		setSpeed(50);
		setHealth(100);
	}
}
