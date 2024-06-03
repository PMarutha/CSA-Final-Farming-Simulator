package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class FarmingSimulator extends Game {
	public SpriteBatch batch;
	BitmapFont font;
	Texture img;
	
	Screen myFarmScreen, myShopScreen, myMainScreen;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
		img = new Texture("badlogic.jpg");
		
		myFarmScreen = new FarmScreen(this);
		myShopScreen = new ShopScreen(this);
		myMainScreen = new MainScreen(this);
		
		this.setScreen(myMainScreen);
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
	
	public Screen getShopScreen() {
		return myShopScreen;
	}
	
	public Screen getFarmScreen() {
		return myFarmScreen;
	}
}
