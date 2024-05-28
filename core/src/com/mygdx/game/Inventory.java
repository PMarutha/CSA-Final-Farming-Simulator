package com.mygdx.game;

import java.util.ArrayList;;

public class Inventory {
	private ArrayList<String> slots;
	private int activeSlot;
	
	public Inventory() {
		activeSlot = 0;
		slots = new ArrayList<String>();
		slots.add(null);
		slots.add("wheat");
		slots.add("potato");
		slots.add("carrot");
	}
	
	public int nextSlot() {
		return activeSlot = (activeSlot + 1) % slots.size();
	}
	
	public int previousSlot() {
		return activeSlot = (activeSlot - 1 + slots.size()) % slots.size();
	}
	

}
