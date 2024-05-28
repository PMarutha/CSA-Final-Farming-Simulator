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
	protected Animation growthAnimation;
	
	protected int growthStage;
	protected final int harvestStage = 7;
	protected final double GROW_CHANCE;
	protected boolean readyToHarvest;
	
	protected final int WORTH;
	
	protected float elapsedTime = 0;
	protected final double STAGE_INTERVAL = 1.5;
	
	public Crop(Texture texture, double growChance, int worth) {
		this.texture = texture;
		growthStage = 0;
		GROW_CHANCE = growChance;
		WORTH = worth;
		readyToHarvest = false;
		
		costumes = new TextureRegion[harvestStage];
		
		TextureRegion[][] tmpFrames = TextureRegion.split(texture, 32, 32);
        System.arraycopy(tmpFrames[0], 0, costumes, 0, harvestStage + 1);
        
        growthAnimation = new Animation(1/3f, (Object[])tmpFrames);
	}
	
	public void update(float delta) {
		elapsedTime += Gdx.graphics.getDeltaTime();
		if(elapsedTime > STAGE_INTERVAL) {
			double dice = Math.random();
			if(dice > GROW_CHANCE) {
				nextCostume();
			}
		}
		
	}
	
	
	public void nextCostume() {
		growthStage++;		
	}
	
	public boolean readyToHarvest() {
		return growthStage == harvestStage;
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
	
	
	
	

}
