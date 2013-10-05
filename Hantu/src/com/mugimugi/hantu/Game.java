//ini komentar

package com.mugimugi.hantu;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Timer;
import com.mugimugi.hantu.entity.Cermin;
import com.mugimugi.hantu.entity.Darktile;
import com.mugimugi.hantu.entity.Door;
import com.mugimugi.hantu.entity.Jendela;
import com.mugimugi.hantu.entity.Karpet;
import com.mugimugi.hantu.entity.Kotak;
import com.mugimugi.hantu.entity.Kunti;
import com.mugimugi.hantu.entity.Kursi;
import com.mugimugi.hantu.entity.Lantai;
import com.mugimugi.hantu.entity.Lemari;
import com.mugimugi.hantu.entity.Lukisan;
import com.mugimugi.hantu.entity.Player;
import com.mugimugi.hantu.entity.Relic;
import com.mugimugi.hantu.entity.Sidepillar;
import com.mugimugi.hantu.entity.Tuyul;
import com.mugimugi.hantu.entity.Wall;
import com.mugimugi.hantu.entity.Web;

public class Game implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Player player;
	private Kunti kunti;
	private Cermin cermin;
	private Karpet karpet;
	private Kursi kursi;
	private Lemari lemari;
	private Lukisan lukisan;
	private Door door;
	public ArrayList<Darktile> darktileList = new ArrayList<Darktile>();
	public ArrayList<Sidepillar> pillarList = new ArrayList<Sidepillar>();
	public ArrayList<Wall> wallList = new ArrayList<Wall>();
	public ArrayList<Jendela> jendelaList = new ArrayList<Jendela>();
	public ArrayList<Web> webList = new ArrayList<Web>();
	public ArrayList<Lantai> lantaiList = new ArrayList<Lantai>();
	public ArrayList<Kotak> kotakList = new ArrayList<Kotak>();
	public ArrayList<Tuyul> tuyulList = new ArrayList<Tuyul>();
	public ArrayList<Relic> relicList = new ArrayList<Relic>();
		
	//Ukuran world
	private float w = 1440;
	private float h = 1080;
	private float time = 0;
	
	//sprite sheet besar. disini ditampung texture keseluruhan
	private TextureAtlas doorTextureAtlas, webTextureAtlas, darktileTextureAtlas, pillarTextureAtlas, wallTextureAtlas, lantaiTextureAtlas, playerTextureAtlas, kuntiTextureAtlas, tuyulTextureAtlas, relicTextureAtlas, cerminTextureAtlas, jendelaTextureAtlas, karpetTextureAtlas, kotakTextureAtlas, kursiTextureAtlas, lemariTextureAtlas, lukisanTextureAtlas;
	private TextureRegion doorTextureRegion, darktileTextureRegion, pillarTextureRegion, wallTextureRegion, playerTextureRegion, tuyulTextureRegion, lemariTextureRegion;
	private TextureRegion[] lantaiTextureRegion, kuntiTextureRegion, kotakTextureRegion, relicTextureRegion, karpetTextureRegion, kursiTextureRegion, cerminTextureRegion, lukisanTextureRegion, webTextureRegion, jendelaTextureRegion;
	
	@Override
	public void create() {		
		
		//camera
		camera = new OrthographicCamera(w, h);
		batch = new SpriteBatch();
		
		//kombinasi
		int kombinasi[];
		kombinasi = new int[5];
		kombinasi[0] = MathUtils.random(4);
		for(int i=1;i<5;i++){
			int j=0;
			int temp = MathUtils.random(4);
			while(j<i){
				if(kombinasi[j]==temp){
					temp++;
					if(temp>4){
						temp=0;
					}
					j=0;
				}
				else{
					j++;
				}	
			}
			kombinasi[i]=temp;
		}
		
		lantaiTextureAtlas = new TextureAtlas("data/tileori.txt");
		lantaiTextureRegion = new TextureRegion[2];
		lantaiTextureRegion[0] = lantaiTextureAtlas.findRegion("tileori");
		lantaiTextureRegion[1] = lantaiTextureAtlas.findRegion("emptytiles");
		
		for(int j=0;j<10;j++){
			for(int i=0;i<14;i++) {
	            Lantai lantai = new Lantai(lantaiTextureRegion[0]);
	            lantai.setSize(90f, 90f);
	            lantai.setPosisiLantai(i, j);
	            lantaiList.add(lantai);
			}
        }
		
		darktileTextureAtlas = new TextureAtlas("data/darktile.txt");
		darktileTextureRegion = darktileTextureAtlas.findRegion("darktile");
		for(int i=0;i<2;i++){
			for(int j=0;j<10;j++){
				Darktile darktile = new Darktile(darktileTextureRegion);
				darktile.setSize(90f, 90f);
				darktile.setPosisiLantai(i, j);
				darktileList.add(darktile);
			}
		}
		
		wallTextureAtlas = new TextureAtlas("data/wall.txt");
		wallTextureRegion = wallTextureAtlas.findRegion("wall");
		for(int i=0;i<5;i++) {
            Wall wall = new Wall(wallTextureRegion);
            wall.setSize(270f, 200f);
            wall.setPosisiWall(i);
            wallList.add(wall);
		}
		
		pillarTextureAtlas = new TextureAtlas("data/sidepillar.txt");
		pillarTextureRegion = pillarTextureAtlas.findRegion("sidepillar");
		for(int i=0;i<2;i++){
			Sidepillar pillar = new Sidepillar(pillarTextureRegion);
			pillar.setSize(75f, 200f);
			if(i==0){
				pillar.setPosition(-720, 350);
			}
			else{
				pillar.setPosition(645, 350);
			}
			pillarList.add(pillar);
		}
		
		webTextureAtlas = new TextureAtlas("data/web.txt");
		webTextureRegion = new TextureRegion[3];
		webTextureRegion[0] = webTextureAtlas.findRegion("web1");
		webTextureRegion[1] = webTextureAtlas.findRegion("web2");
		webTextureRegion[2] = webTextureAtlas.findRegion("web3");
		
		for(int i=0;i<1;i++){
			Web web = new Web(webTextureRegion[0]);
			web.setSize(180f, 180f);
			web.setPosisiWeb1();
			webList.add(web);
		}
		
		for(int i=0;i<8;i++){
			int acak = MathUtils.random(1);
			if(acak==1){
				Web web = new Web(webTextureRegion[1]);
				web.setSize(180f, 90f);
				web.setPosisiWeb2(i);
				webList.add(web);
			}
		}
		
		for(int i=0;i<2;i++){
			Web web = new Web(webTextureRegion[2]);
			web.setSize(90f, 90f);
			web.setPosisiWeb3(i);
			webList.add(web);
		}
		
		jendelaTextureAtlas = new TextureAtlas("data/jendela.txt");
		jendelaTextureRegion = new TextureRegion[3];
		jendelaTextureRegion[0] = jendelaTextureAtlas.findRegion("window1");
		jendelaTextureRegion[1] = jendelaTextureAtlas.findRegion("window2");
		jendelaTextureRegion[2] = jendelaTextureAtlas.findRegion("window3");
		
		for(int i=0;i<4;i++){
			Jendela jendela = new Jendela(jendelaTextureRegion[0]);
			jendela.setSize(270f, 200f);
			jendela.setPosisiJendela(i);
			jendelaList.add(jendela);
		}
		
		playerTextureAtlas = new TextureAtlas("data/tile.txt");
		//membuat gambar player
		playerTextureRegion = playerTextureAtlas.findRegion("tile");	//ini dummy. Nanti diganti jadi orang
		
		//membuat sprite player
		player = new Player(playerTextureRegion);
		player.setSize(45f, 45f);
		player.setPosition(0-player.getWidth(), 0-player.getWidth()); //posisikan di tengah kamera
		
		kuntiTextureAtlas = new TextureAtlas("data/kunti.txt");
		kuntiTextureRegion = new TextureRegion[8];
		kuntiTextureRegion[0] = kuntiTextureAtlas.findRegion("kuntiback");
		kuntiTextureRegion[1] = kuntiTextureAtlas.findRegion("kuntifront");
		kuntiTextureRegion[2] = kuntiTextureAtlas.findRegion("kuntileft");
		kuntiTextureRegion[3] = kuntiTextureAtlas.findRegion("kuntiright");
		kuntiTextureRegion[4] = kuntiTextureAtlas.findRegion("angryback");
		kuntiTextureRegion[5] = kuntiTextureAtlas.findRegion("angryfront");
		kuntiTextureRegion[6] = kuntiTextureAtlas.findRegion("angryleft");
		kuntiTextureRegion[7] = kuntiTextureAtlas.findRegion("angryright");
		
		kunti = new Kunti(kuntiTextureRegion[1]);
		kunti.setSize(90f, 120f);
		kunti.setPosition(0, 0);
		
		tuyulTextureAtlas = new TextureAtlas("data/tuyul.txt");
		//membuat gambar tuyul
		tuyulTextureRegion = tuyulTextureAtlas.findRegion("pocong 10"); //dummy juga, buat tuyul
		
		//membuat sprite tuyul dan posisinya
		for(int i=0;i<3;i++) {
            Tuyul tuyul = new Tuyul(kuntiTextureRegion[5]);
            tuyul.setSize(90f, 90f);
            tuyul.setPosisiAcak();
            tuyulList.add(tuyul);
        }
		
		relicTextureAtlas = new TextureAtlas("data/Keris.txt");
		relicTextureRegion = new TextureRegion[2];
		relicTextureRegion[0] = relicTextureAtlas.findRegion("relic");
		relicTextureRegion[1] = relicTextureAtlas.findRegion("relic2");
		for(int i=0;i<3;i++){
			Relic relic = new Relic(relicTextureRegion[0]);
			relic.setSize(50f, 50f);
			relic.setPosisiAcak(i);
			relicList.add(relic);
			//System.out.println(relic.getX() +" "+ relic.getY());
		}
		
		jendelaTextureAtlas = new TextureAtlas("data/jendela.txt");
		jendelaTextureRegion = new TextureRegion[3];
		jendelaTextureRegion[0] = jendelaTextureAtlas.findRegion("window1");
		jendelaTextureRegion[1] = jendelaTextureAtlas.findRegion("window2");
		jendelaTextureRegion[2] = jendelaTextureAtlas.findRegion("window3");
		
		for(int i=0;i<4;i++){
			Jendela jendela = new Jendela(jendelaTextureRegion[0]);
			jendela.setSize(270f, 200f);
			jendela.setPosisiJendela(i);
			jendelaList.add(jendela);
		}
		
		cerminTextureAtlas = new TextureAtlas("data/cermin.txt");
		cerminTextureRegion = new TextureRegion[2];
		cerminTextureRegion[0] = cerminTextureAtlas.findRegion("miror1");
		cerminTextureRegion[1] = cerminTextureAtlas.findRegion("miror2");
		
		cermin = new Cermin(cerminTextureRegion[0]);
		cermin.setSize(110f, 150f);
 		cermin.setPosisiAcak(kombinasi[1]);
 		
		karpetTextureAtlas = new TextureAtlas("data/karpet.txt");
		karpetTextureRegion = new TextureRegion[2];
		karpetTextureRegion[0] = karpetTextureAtlas.findRegion("carpet1");
		karpetTextureRegion[1] = karpetTextureAtlas.findRegion("carpet2");
		
		karpet = new Karpet(karpetTextureRegion[1]);
		karpet.setSize(200f, 150f);
		karpet.setPosisiAcak();
		
		kursiTextureAtlas = new TextureAtlas("data/kursi.txt");
		kursiTextureRegion = new TextureRegion[4];
		kursiTextureRegion[0] = kursiTextureAtlas.findRegion("chair1");
		kursiTextureRegion[1] = kursiTextureAtlas.findRegion("chair2");
		kursiTextureRegion[2] = kursiTextureAtlas.findRegion("chair3");
		kursiTextureRegion[3] = kursiTextureAtlas.findRegion("chair4");
		
		kursi = new Kursi(kursiTextureRegion[2]);
		kursi.setSize(140f, 120f);
		kursi.setPosisiAcak();
		
		doorTextureAtlas = new TextureAtlas("data/door.txt");
		doorTextureRegion = doorTextureAtlas.findRegion("door");
		
		door = new Door(doorTextureRegion);
		door.setSize(170f, 180f);
		door.setPosisiAcak(kombinasi[0]);
		
		lemariTextureAtlas = new TextureAtlas("data/lemari.txt");
		lemariTextureRegion = lemariTextureAtlas.findRegion("cupboard");
		
		lemari = new Lemari(lemariTextureRegion);
		lemari.setSize(120f, 150f);
		lemari.setPosisiAcak();
		
		lukisanTextureAtlas = new TextureAtlas("data/lukisan.txt");
		lukisanTextureRegion = new TextureRegion[3];
		lukisanTextureRegion[0] = lukisanTextureAtlas.findRegion("pic1");
		lukisanTextureRegion[1] = lukisanTextureAtlas.findRegion("pic2");
		lukisanTextureRegion[2] = lukisanTextureAtlas.findRegion("pic3");
		
		lukisan = new Lukisan(lukisanTextureRegion[2]);
		lukisan.setSize(100f, 150f);
		lukisan.setPosisiAcak(kombinasi[2]);
 		
		kotakTextureAtlas = new TextureAtlas("data/kotak.txt");
		kotakTextureRegion = new TextureRegion[2];
		kotakTextureRegion[0] = kotakTextureAtlas.findRegion("box1");
		kotakTextureRegion[1] = kotakTextureAtlas.findRegion("box2");
		
		for(int i=0;i<2;i++){
			Kotak kotak = new Kotak(kotakTextureRegion[1]);
			kotak.setSize(80f, 70f);
			kotak.setPosisiAcak(i);
			kotakList.add(kotak);
		}
	}

	@Override
	public void dispose() {
		batch.dispose();
		//dispose sprite
		playerTextureAtlas.dispose();
		tuyulTextureAtlas.dispose();
		relicTextureAtlas.dispose();
		kuntiTextureAtlas.dispose();
		cerminTextureAtlas.dispose();
		jendelaTextureAtlas.dispose();
		karpetTextureAtlas.dispose();
		kotakTextureAtlas.dispose();
		kursiTextureAtlas.dispose();
		lemariTextureAtlas.dispose();
		lukisanTextureAtlas.dispose();
		lantaiTextureAtlas.dispose();
		wallTextureAtlas.dispose();
		pillarTextureAtlas.dispose();
		darktileTextureAtlas.dispose();
		webTextureAtlas.dispose();
		doorTextureAtlas.dispose();
	}
	
	public void updatePosisi(){
		//update posisi
		for (Tuyul tuyul : tuyulList) { //iterate through arraylist
			tuyul.setPosition(tuyul.getX(), tuyul.getY());
			
			int status = 0;
			
	 		if(tuyul.getTrayek() == 0){
	 			tuyul.setX(tuyul.getX() + tuyul.getSpeed()*Gdx.graphics.getDeltaTime());
	 			if(tuyul.getX() > -320){
	 				status = 1;
	 			}
	 		}
	 		else if(tuyul.getTrayek() == 1){
	 			tuyul.setY(tuyul.getY() + tuyul.getSpeed()*Gdx.graphics.getDeltaTime());
	 			if(tuyul.getY() > 300){
	 				status = 1;
	 			}
	 		}
	 		else if(tuyul.getTrayek() == 2){
	 			tuyul.setY(tuyul.getY() - tuyul.getSpeed()*Gdx.graphics.getDeltaTime());
	 			if(tuyul.getY() < -20){
	 				status = 1;
	 			}
	 			
	 		}
	 		else if(tuyul.getTrayek() == 3){
	 			tuyul.setX(tuyul.getX() + tuyul.getSpeed()*Gdx.graphics.getDeltaTime());
	 			tuyul.setY(tuyul.getY() - tuyul.getSpeed()*Gdx.graphics.getDeltaTime());
	 			if(tuyul.getX() > 640 || tuyul.getY() < 140){
	 				status = 1;
	 			}
	 		}
	 		else if(tuyul.getTrayek() == 4){
	 			tuyul.setX(tuyul.getX() - tuyul.getSpeed()*Gdx.graphics.getDeltaTime());
	 			tuyul.setY(tuyul.getY() + tuyul.getSpeed()*Gdx.graphics.getDeltaTime());
	 			if(tuyul.getX() < 320 || tuyul.getY() > -340){
	 				status = 1;
	 			}
	 		}
	 		else if(tuyul.getTrayek() == 5){
	 			tuyul.setX(tuyul.getX() - tuyul.getSpeed()*Gdx.graphics.getDeltaTime());
	 			if(tuyul.getX() < -160){
	 				status = 1;
	 			}
	 		}
	 		else{
	 			tuyul.setX(tuyul.getX() - tuyul.getSpeed()*Gdx.graphics.getDeltaTime());
	 			if(tuyul.getX() < -640){
	 				status = 1;
	 			}
	 		}
	 		
	 		if(status == 1){
	 			tuyul.setPosisiAcak();
	 		}
		}
		if(time >= 120){
			kunti.setPosition(kunti.getX(), kunti.getY());
			kunti.setX(kunti.getX() - 100*Gdx.graphics.getDeltaTime());
			
			if(kunti.getX() < (-w/2)+(kunti.getWidth()/2)){
				kunti.setX((w/2)-(kunti.getWidth()/2));
			}
		}
	}
	
	@Override
	public void render() {		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		updatePosisi();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		
		//Gambar setiap sprite
		for(Lantai lantai : lantaiList){
			lantai.draw(batch);
		}
		for(Darktile darktile : darktileList){
			darktile.draw(batch);
		}
		for(Wall wall : wallList){
			wall.draw(batch);
		}
		for(Sidepillar pillar : pillarList){
			pillar.draw(batch);
		}
		door.draw(batch);
		for(Jendela jendela : jendelaList){
			jendela.draw(batch);
		}
		karpet.draw(batch);
		cermin.draw(batch);
		lukisan.draw(batch);
		for(Kotak kotak : kotakList){
			kotak.draw(batch);
		}
		for(Relic relic : relicList){
			relic.draw(batch);
		}
		for(Tuyul tuyul : tuyulList) {
			Color c = tuyul.getColor();
            tuyul.setColor(c.r, c.g, c.b, .5f);
			tuyul.draw(batch);
		}
		kursi.draw(batch);
		lemari.draw(batch);
		if(time >= 120){
			kunti.draw(batch);
		}
		else{
			time += Gdx.app.getGraphics().getDeltaTime();
		}
		player.draw(batch);
		for(Web web : webList){
			web.draw(batch);
		}
		
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
