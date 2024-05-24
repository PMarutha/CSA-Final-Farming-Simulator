package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Carrot extends Crop {
	
	private static Texture texture = new Texture(Gdx.files.internal("Carrot.png"));
	private static final double growChance = 0.7;
	private static final int worth = 300;
	
	public Carrot() {
		super(texture, growChance, worth);
	}
	
	public String toString() {
		return "carrot";
	}

}
