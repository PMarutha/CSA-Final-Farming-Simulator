package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Potato extends Crop {
	
	private static Texture texture = new Texture(Gdx.files.internal("Growth.png"));
	private static final double growChance = 0.5;
	private static final int worth = 200;

	public Potato() {
		super(texture, growChance, worth);
		
	}
	
	public String toString() {
		return "potato";
	}

}
