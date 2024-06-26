package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;;

public class Inventory {
	private Crop[] slots;
	private int[] quantities;
	private int activeSlot;
	
	private Texture texture;
	private TextureRegion costumes[];
	
	private boolean nextSlotPressed, previousSlotPressed;
	
	public Inventory() {
		texture = new Texture(Gdx.files.internal("Inventory (1).png"));
		activeSlot = 0;
		
		costumes = new TextureRegion[4];
		
		TextureRegion[][] tmpFrames = TextureRegion.split(texture, 96, 96);
        System.arraycopy(tmpFrames[0], 0, costumes, 0, 4);
		
		this.slots = new Crop[]{null, new Carrot(), new Wheat(), new Potato()};
		this.quantities = new int[]{0, 0, 1, 0};
		
		nextSlotPressed = false;
        previousSlotPressed = false;

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
	
	public int getActiveSlot() {
		return activeSlot;
	}
	
	public boolean hasSeeds() {
		return quantities[activeSlot] > 0;
	}
	
	public TextureRegion getTexture() {
		return costumes[activeSlot];
	}
	
	public void draw(Batch batch, BitmapFont font, float x, float y, float width, float height) {
		TextureRegion textureRegion = getTexture();
		if (textureRegion != null) {
            batch.draw(textureRegion, x, y, width, height);
        }
		font.draw(batch, String.valueOf(quantities[1]), x + 48 + 30, y + 100);
		font.draw(batch, String.valueOf(quantities[2]), x + 48*2 + 30, y + 100);
		font.draw(batch, String.valueOf(quantities[3]), x + 48*3 + 30, y + 100);
    }
	
	public void addSeeds(String crop) {
		switch(crop) {
			case "wheat":
				quantities[2]++;
				break;
			case "potato":
				quantities[3]++;
				break;
			case "carrot":
				quantities[1]++;
				break;
		}
		
	}
	
	public void removeSeeds() {
		quantities[activeSlot] -= 1;
	}
	
	public void update() {
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && !nextSlotPressed) {
            nextSlot();
            nextSlotPressed = true;
        }
        if (!Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            nextSlotPressed = false;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && !previousSlotPressed) {
            previousSlot();
            previousSlotPressed = true;
        }
        if (!Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            previousSlotPressed = false;
        }
	}

}
