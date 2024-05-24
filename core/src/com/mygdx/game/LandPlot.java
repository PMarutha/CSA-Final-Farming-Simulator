package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class LandPlot {
	private Crop crop;
	private Texture texture;
	
	public LandPlot() {
		this.crop = null;
		texture = new Texture(Gdx.files.internal("PLACEHOLDER"));
	}
	
	public void plantCrop(Crop seed) {
		crop = seed;
	}
	
	public Crop harvestCrop() {
		Crop temp = crop;
		crop = null;
		return temp;
	}
	
	public boolean isOccupied() {
		return crop == null;
	}

}
