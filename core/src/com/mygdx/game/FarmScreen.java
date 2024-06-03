package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
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
	Bank bank;
	
	Rectangle shopButton;
	
	
	
	
	
	
	public FarmScreen(final FarmingSimulator game) {
		this.game = game;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		
		viewport = new FitViewport(800, 480, camera);
		
		myGrid = new Grid(6,6);
		inventory = new Inventory();
		bank = new Bank();
		
		shopButton = new Rectangle();
		shopButton.x = 140;
		shopButton.y = 170;
		shopButton.height = 64;
		shopButton.width = 64;
		
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
		inventory.draw(game.batch, game.font, 335, -50, 192, 192); 
		bank.draw(game.batch, game.font, 100, 200);
		game.batch.draw(new Texture(Gdx.files.internal("Shop.png")), shopButton.x, shopButton.y, shopButton.height, shopButton.width);
		game.batch.end();
		
		if(Gdx.input.justTouched()) {
			Vector3 touchPos = new Vector3();
		    touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
		    camera.unproject(touchPos);
		    
		    
		    // PLANTING SEEDS
			for(LandPlot[] landRow : myGrid.getGrid()) {
				for(LandPlot plot : landRow) {
					if(plot.contains(touchPos.x, touchPos.y)) { // new
						System.out.println("Row: " + plot.getRow() + " Col: " + plot.getCol());
						
						if(plot.isEmpty() && inventory.hasSeeds()) {
							plot.plantCrop(inventory.getActiveItem().copy());
							inventory.removeSeeds(); // new
						}
						
						if(!plot.isEmpty() && plot.getCrop().readyToHarvest() && inventory.getActiveItem() == null) {
							bank.deposit(plot.getCrop().getWorth());
							plot.harvestCrop();
						}
					}
				}
			}
			
			
			// GOING TO SHOP
			if(shopButton.contains(touchPos.x, touchPos.y)) {
				System.out.println("what the hsjfdkl");
				game.setScreen(game.getShopScreen());
			}
		}
		
		inventory.update();
		
		
		 
		
		
	}
	
	public Inventory getInventory() {
		return inventory;
	}
	
	public Bank getBank() {
		return bank;
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
