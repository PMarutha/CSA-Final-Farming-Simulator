package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class LandPlot {
	private Crop crop;
	private Texture texture;
	private int row, col;
	
	public LandPlot(int r, int c) {
		this.crop = null;
		texture = new Texture(Gdx.files.internal("PLACEHOLDER"));
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
	
	
	public void draw(Batch batch) {
		batch.draw(texture, row, col, 32, 32); // CHANGE??????????
		if(crop != null) {
			crop.draw(batch, row, col, 32 * 0.4f, 32 * 0.4f); // AND THIS.
		}
	}
	

}
