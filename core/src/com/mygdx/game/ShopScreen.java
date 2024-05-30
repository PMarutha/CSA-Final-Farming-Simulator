/*
package com.mygdx.game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class ShopScreen implements Screen {
	private SpriteBatch batch;
	private Texture carrotSeedTexture;
	private Texture potatoSeedTexture;
	private Texture wheatSeedTexture;
	private int selectedItem;
	
	public void create() {
		batch = new SpriteBatch();
		carrotSeedTexture = new Texture("carrotseed.png");
		potatoSeedTexture = new Texture("potatoseed.png");
		wheatSeedTexture = new Texture("wheatseed.png");
		selectedItem = 0;
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
	}
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		handleInput();
		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		batch.draw(carrotSeedTexture, 100, 200);
		batch.draw(potatoSeedTexture, 300, 200);
		batch.draw(wheatSeedTexture, 500, 200);
      
       switch (selectedItem)
       {
       	case 1:
       		batch.draw(carrotSeedTexture, 100, 200);
       		break;
       	case 2:
       		batch.draw(potatoSeedTexture, 300, 200);
       	case 3:
       		batch.draw(wheatSeedTexture, 500, 200);
       }
       batch.end();
	}
	
	private void handleInput() {
       // Check for number key presses
       if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)) {
           selectedItem = 1;
           System.out.println("Carrot selected!");
           // TODO: Add your logic for selecting the carrot
       } else if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)) {
           selectedItem = 2;
           System.out.println("Potato selected!");
           // TODO: Add your logic for selecting the potato
       } else if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_3)) {
           selectedItem = 3;
           System.out.println("Wheat selected!");
           // TODO: Add your logic for selecting the wheat
       }
   }
	
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
	}
	@Override
	public void pause() {
		// TODO Auto-generated method stub
	}
	@Override
	public void resume() {
		// TODO Auto-generated method stub
	}
	@Override
	public void hide() {
		// TODO Auto-generated method stub
	}
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		batch.dispose();
		carrotSeedTexture.dispose();
		potatoSeedTexture.dispose();
		wheatSeedTexture.dispose();
	}
}

*/
