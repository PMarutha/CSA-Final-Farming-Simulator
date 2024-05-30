package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Batch;

public class Grid {
	private LandPlot[][] land;
	private int landRows = 6;
	private int landCols = 6;
	
	public Grid(int lR, int lC) {
		landRows = lR;
		landCols = lC;
		land = new LandPlot[landRows][landCols];
		for (int i = 0; i < landRows; i++) {
            for (int j = 0; j < landCols; j++) {
                land[i][j] = new LandPlot(i, j);
            }
        }
		
	}
	
	public void draw(Batch batch) {
		for(LandPlot[] plotRow : land) {
			for(LandPlot plot : plotRow) {
				plot.draw(batch);
			}
			
		}
	}
	
	public void update(float delta) {
		for(LandPlot[] plotRow : land) {
			for(LandPlot plot : plotRow) {
				plot.update(delta);
			}
		}
	}
	
	public int getRows() {
		return landRows;
	}
	
	public int getCols() {
		return landCols;
	}
	
	
	

}
