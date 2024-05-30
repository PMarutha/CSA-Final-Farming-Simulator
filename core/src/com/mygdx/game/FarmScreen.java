package com.mygdx.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;

public class FarmScreen implements Screen {
	
	final FarmingSimulator game;
	
	OrthographicCamera camera;
	
	
	
	public FarmScreen(final FarmingSimulator game) {
		this.game = game;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
	}
	
	Grid myGrid = new Grid(6, 6);
	
	

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		//ScreenUtils.clear(0f, 0f, 0f, 1);
		ScreenUtils.clear(0.29f, 0.70f, 0.4f, 1);
		camera.update();
		game.batch.setProjectionMatrix(camera.combined);
		
		myGrid.update(delta);
		
		game.batch.begin();
		myGrid.draw(game.batch);
		game.batch.end();

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
