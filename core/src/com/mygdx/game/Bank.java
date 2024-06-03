package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class Bank {
	
	private int balance;

	public Bank() {
		balance = 0;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void deposit(int money) {
		balance += money;
	}
	
	public void withdraw(int money) {
		balance -= money;
	}
	
	public void draw(Batch batch, BitmapFont font, float x, float y) {
		font.draw(batch, "Bank: " + String.valueOf(balance), x, y);
	}

}
