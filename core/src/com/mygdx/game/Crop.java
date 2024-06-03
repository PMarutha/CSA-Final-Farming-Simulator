package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.TimeUtils;

public abstract class Crop {
	protected Texture texture;
	protected TextureRegion costumes[];
	
	protected Animation<TextureRegion> animation;
	
	protected int growthStage;
	protected int maxIndex;
	protected final int harvestStage = 5;
	protected final double GROW_CHANCE;
	protected boolean readyToHarvest;
	
	protected final int WORTH;
	
	protected float lastUpdateTime = TimeUtils.nanoTime();
	protected long STAGE_INTERVAL = 2000000000;
	
	public Crop(Texture texture, double growChance, int worth) {
		this.texture = texture;
		growthStage = 0;
		GROW_CHANCE = growChance;
		WORTH = worth;
		readyToHarvest = false;
		
		costumes = new TextureRegion[harvestStage];
		
		TextureRegion[][] tmpFrames = TextureRegion.split(texture, 32, 32);
        System.arraycopy(tmpFrames[0], 0, costumes, 0, harvestStage);
        
	}
	
	public void update(float delta) {
		if(TimeUtils.nanoTime() - lastUpdateTime > STAGE_INTERVAL) {
			double dice = Math.random();
			if(dice < GROW_CHANCE) {
				nextCostume();
			}
			lastUpdateTime = TimeUtils.nanoTime();
		}
	}
	
	
	public void nextCostume() {
		growthStage++;	
		if (growthStage > harvestStage - 1) {
			growthStage = harvestStage - 1;
		}
	}
	
	public boolean readyToHarvest() {
		return growthStage >= harvestStage - 1;
	}
	
	public TextureRegion getTexture() {
        return costumes[growthStage];
    }
	
	public int getGrowthStage() {
		return growthStage;
	}
	
	public int getWorth() {
		return WORTH;
	}
	
	public void draw(Batch batch, float x, float y, float width, float height) {
        batch.draw(getTexture(), x, y, width, height);
    }

	protected abstract Crop copy();
	
	
	
	

}
