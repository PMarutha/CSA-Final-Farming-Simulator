package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class LandPlot {
	private Crop crop;
	private Texture texture;
	private int row, col;
	
	private static final int PLOT_SIZE = 32;
    private static final int GAP_SIZE = 50;
    private static final int GRID_SIZE = 6;
	
	public LandPlot(int r, int c) {
		this.crop = null;
		texture = new Texture(Gdx.files.internal("Minecraft-Dirt-Block 32x32.jpg"));
		row = r;
		col = c;
		
	}
	
	public void plantCrop(Crop seed) {
		crop = seed;
	}
	
	public Crop harvestCrop() {
		Crop temp = crop;
		crop = null;
		return temp;
	}
	
	public boolean isEmpty() {
		return crop == null;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public void update(float delta) {
		if(crop != null) {
			crop.update(delta);
		}
	}
	
	public boolean contains(float x, float y) {
		return (x >= 800 - 259 - 50*(col) && x <= 800 - 259 - 50*(col) + 32 && y >= 99+50*(row) && y <= 99+50*(row) + 32);
	}
	
	
	public void draw(Batch batch) {
		batch.draw(texture, 800 - 259 - 50*(col) , 99+50*(row), 32, 32); // aiden math
		if(crop != null) {
			crop.draw(batch, 800 - 259 - 50*(col) , 99+50*(row), 32, 32); // CHANGE THIS.
		}
	}
	

}
