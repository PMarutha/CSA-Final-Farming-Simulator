package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Wheat extends Crop {

	private static Texture texture = new Texture(Gdx.files.internal("Growth.png"));
	private static final double growChance = 0.2;
	private static final int worth = 100;

	public Wheat() {
		super(texture , growChance, worth);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "wheat";
	}
	
	public Wheat copy() {
		return new Wheat();
	}
	
	

}
