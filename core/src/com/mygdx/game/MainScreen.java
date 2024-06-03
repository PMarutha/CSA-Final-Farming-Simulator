package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MainScreen implements Screen {
	
	final FarmingSimulator game;
	
	OrthographicCamera camera;
	Viewport viewport;
	
	Rectangle startButton, logo;
	
	

	public MainScreen(final FarmingSimulator game) {
		this.game = game;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		
		viewport = new FitViewport(800, 480, camera);
		
		logo = new Rectangle(250, 150, 300, 300);
		startButton = new Rectangle(350, 80, 96, 96);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(0.29f, 0.70f, 0.4f, 1);
		camera.update();
		game.batch.setProjectionMatrix(camera.combined);
		
		game.batch.begin();
		game.batch.draw(new Texture(Gdx.files.internal("Start Button.png")), startButton.x, startButton.y, startButton.height, startButton.width);
		game.batch.draw(new Texture(Gdx.files.internal("Untitled design.png")), logo.x, logo.y, logo.height, logo.width);
		
		game.font.draw(game.batch, "Welcome to the Farming Simulator!", 100, 300);
		game.font.draw(game.batch, "Navigate between harvesting or planting seeds in the hotbar using left/right arrows keys.", 100, 280);
		game.font.draw(game.batch, "Click on a plot to plant or harvest.", 100, 240);
		game.font.draw(game.batch, "Plant your starter seeds in any plot, and harvest when ready.", 100, 220);
		game.font.draw(game.batch, "Go to the shop to purchase more seeds and continue farming!", 100, 200);
		game.batch.end();
		
		if(Gdx.input.justTouched()) {
			Vector3 touchPos = new Vector3();
		    touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
		    camera.unproject(touchPos);
		    
		    if(startButton.contains(touchPos.x, touchPos.y)) {
		    	game.setScreen(game.getFarmScreen());
		    }
		}
		

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
