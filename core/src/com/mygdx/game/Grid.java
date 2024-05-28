package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Batch;

public class Grid {
	private LandPlot[][] land;
	private final int LAND_ROWS = 6;
	private final int LAND_COLS = 6;
	
	public Grid() {
		land = new LandPlot[LAND_ROWS][LAND_COLS];
		for (int i = 0; i < LAND_ROWS; i++) {
            for (int j = 0; j < LAND_COLS; j++) {
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
	
	
	

}
