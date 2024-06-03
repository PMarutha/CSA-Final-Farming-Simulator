package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Potato extends Crop {
	
	private static Texture texture = new Texture(Gdx.files.internal("Potato Progression Sprites.png"));
	private static final double growChance = 0.67;
	private static final int worth = 20;
	private static final int price = 5;

	public Potato() {
		super(texture, growChance, worth, price);
		
	}
	
	public String toString() {
		return "potato";
	}
	
	public Potato copy() {
		return new Potato();
	}

}
