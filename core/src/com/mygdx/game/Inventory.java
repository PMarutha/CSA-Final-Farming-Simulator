package com.mygdx.game;

import java.util.ArrayList;;

public class Inventory {
	private Crop[] slots;
	private int[] quantities;
	private int activeSlot;
	
	public Inventory() {
		activeSlot = 0;
		Crop[] slots = {null, new Wheat(), new Carrot()};
		int[] quantities = {0, 0, 0};

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
	
	public void addSeeds(int index) {
		
	}
	

}
