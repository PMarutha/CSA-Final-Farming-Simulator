package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class FarmScreen implements Screen {
	
	final FarmingSimulator game;
	
	OrthographicCamera camera;
	Viewport viewport;
	
	Grid myGrid;
	Inventory inventory;
	
	
	
	
	
	
	public FarmScreen(final FarmingSimulator game) {
		this.game = game;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		
		viewport = new FitViewport(800, 480, camera);
		
		myGrid = new Grid(6,6);
		inventory = new Inventory();
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
		
		myGrid.update(delta);
		
		game.batch.begin();
		myGrid.draw(game.batch);
		inventory.draw(game.batch, game.font, 335, -50, 192, 192); // FIX
		game.batch.end();
		
		if(Gdx.input.justTouched()) {
			Vector3 touchPos = new Vector3();
		    touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
		    camera.unproject(touchPos);
		    
			for(LandPlot[] landRow : myGrid.getGrid()) {
				for(LandPlot plot : landRow) {
					if(plot.contains(touchPos.x, touchPos.y) && plot.isEmpty() && inventory.hasSeeds()) { // new
						System.out.println("Row: " + plot.getRow() + " Col: " + plot.getCol());
						plot.plantCrop(inventory.getActiveItem().copy());
						inventory.removeSeeds(); // new
					}
				}
			}
		}
		
		inventory.update();
		 
		
		
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);
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
