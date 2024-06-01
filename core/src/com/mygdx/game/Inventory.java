package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;;

public class Inventory {
	private Crop[] slots;
	private int[] quantities;
	private int activeSlot;
	private Texture texture;
	private TextureRegion costumes[];
	
	public Inventory() {
		texture = new Texture(Gdx.files.internal("Inventory.png"));
		activeSlot = 0;
		Crop[] slots = {null, new Carrot(), new Wheat(), new Potato()};
		int[] quantities = {0, 0, 1, 0};

	}
	
	public void nextSlot() {
		activeSlot = (activeSlot + 1) % slots.length;
	}
	
	public void previousSlot() {
		activeSlot = (activeSlot - 1 + slots.length) % slots.length;
	}
	
	public Crop getActiveItem() {
		return slots[activeSlot];
	}
	
	public TextureRegion getTexture() {
		return costumes[activeSlot];
	}
	
	public void draw(Batch batch, float x, float y, float width, float height) {
        batch.draw(getTexture(), x, y, width, height);
    }
	
	public void addSeeds() {
		
	}
	
	public void removeSeeds() {
		quantities[activeSlot] -= 1;
	}

}
