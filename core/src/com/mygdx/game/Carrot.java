package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Carrot extends Crop {
	
	private static Texture texture = new Texture(Gdx.files.internal("Carrot Progression Sprites.png"));
	private static final double growChance = 0.2;
	private static final int worth = 50;
	private static final int price = 8;
	
	public Carrot() {
		super(texture, growChance, worth, price);
	}
	
	public String toString() {
		return "carrot";
	}
	
	public Carrot copy() {
		return new Carrot();
	}

}
