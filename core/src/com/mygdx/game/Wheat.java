package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Wheat extends Crop {

	private static Texture texture = new Texture(Gdx.files.internal("Wheat.png"));
	private static final double growChance = 0.2;

	public Wheat() {
		super(texture , growChance);
		// TODO Auto-generated constructor stub
	}

}
