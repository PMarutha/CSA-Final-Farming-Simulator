
package com.mygdx.game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;



public class ShopScreen implements Screen {
	
	private final OrthographicCamera camera;
    private final FarmingSimulator game;
    private final Viewport viewport;

    ShapeRenderer shapeRender;
    Rectangle buyWheat, buyPotato, buyCarrot, farmButton;
    final float buttonY = -100;
    
    public ShopScreen(FarmingSimulator game) {
    	this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        viewport = new FitViewport(800, 480, camera);

        
        shapeRender = new ShapeRenderer();
        buyWheat = new Rectangle(100, 200, 182, 182);
        buyPotato = new Rectangle(500, 200, 182, 182);
        buyCarrot = new Rectangle(300, 180, 182, 182);
        
        farmButton = new Rectangle(60, 130, 64, 64);
    }


	
	@Override
	public void show() {
		// TODO Auto-generated method stub
	}
	@Override
	public void render(float delta) {
        game.batch.setProjectionMatrix(camera.combined);
        ScreenUtils.clear(0.83f, 0.71f, 0.51f, 1);
        camera.update();
        
        game.batch.begin();
        ((FarmScreen) game.getFarmScreen()).getBank().draw(game.batch, game.font, 370, 140);
        game.batch.draw(new Texture(Gdx.files.internal("Farm Button.png")), farmButton.x, farmButton.y, farmButton.height, farmButton.width);
        game.batch.draw(new Texture(Gdx.files.internal("Wheat.png")), buyWheat.x, buyWheat.y, buyWheat.height, buyWheat.width);
        game.batch.draw(new Texture(Gdx.files.internal("Carrot.png")), buyCarrot.x, buyCarrot.y, buyCarrot.height, buyCarrot.width);
        game.batch.draw(new Texture(Gdx.files.internal("Potato.png")), buyPotato.x, buyPotato.y, buyPotato.height, buyPotato.width);
        game.font.draw(game.batch, "$" + new Wheat().getPrice(), buyWheat.x + 96, buyWheat.y + 40);
        game.font.draw(game.batch, "$" + new Carrot().getPrice(), buyCarrot.x + 96, buyCarrot.y + 60);
        game.font.draw(game.batch, "$" + new Potato().getPrice(), buyPotato.x + 96, buyPotato.y + 40);
        
        game.batch.end();
        
        if(Gdx.input.justTouched()) {
			Vector3 touchPos = new Vector3();
		    touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
		    camera.unproject(touchPos);
		    
		    if(farmButton.contains(touchPos.x, touchPos.y)) {
				game.setScreen(game.getFarmScreen());
			}
		    
		    if(buyWheat.contains(touchPos.x, touchPos.y) && ((FarmScreen) game.getFarmScreen()).getBank().hasMoney(new Wheat().getPrice())) {
		    	((FarmScreen) game.getFarmScreen()).getInventory().addSeeds("wheat");
		    	((FarmScreen) game.getFarmScreen()).getBank().withdraw(new Wheat().getPrice());
		    }
		    
		    if(buyPotato.contains(touchPos.x, touchPos.y) && ((FarmScreen) game.getFarmScreen()).getBank().hasMoney(new Potato().getPrice())) {
		    	((FarmScreen) game.getFarmScreen()).getInventory().addSeeds("potato");
		    	((FarmScreen) game.getFarmScreen()).getBank().withdraw(new Potato().getPrice());
		    }
		    
		    if(buyCarrot.contains(touchPos.x, touchPos.y) && ((FarmScreen) game.getFarmScreen()).getBank().hasMoney(new Carrot().getPrice())) {
		    	((FarmScreen) game.getFarmScreen()).getInventory().addSeeds("carrot");
		    	((FarmScreen) game.getFarmScreen()).getBank().withdraw(new Carrot().getPrice());
		    }
        }
        
        
        
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);
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
	}

}
