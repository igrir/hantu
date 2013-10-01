//ini komentar

package com.mugimugi.hantu;


import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mugimugi.hantu.entity.Player;

public class Game implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Player player;

	//sprite sheet besar. disini ditampung texture keseluruhan
	private TextureAtlas textureAtlas;
	private TextureRegion playerTextureRegion;
	
	@Override
	public void create() {		
		
		//ukuran dari kamera
		float w = 480;
		float h = 320;
		
		camera = new OrthographicCamera(w, h);	//kamera
		batch = new SpriteBatch();
		
		textureAtlas = new TextureAtlas("data/tile.txt");
		
		//membuat gambar player
		playerTextureRegion = textureAtlas.findRegion("tile");	//ini dummy. Nanti diganti jadi orang
		
		//membuat sprite player
		player = new Player(playerTextureRegion);
		player.setSize(30f, 30f);
		player.setOrigin(player.getWidth()/2, player.getHeight()/2);
		player.setPosition(0f, 0f); //posisikan di tengah kamera
		
		
	}

	@Override
	public void dispose() {
		batch.dispose();
		
		textureAtlas.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		
		//Gambar setiap sprite
		player.draw(batch);
		
		
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
