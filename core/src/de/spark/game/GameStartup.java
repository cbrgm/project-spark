package de.spark.game;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import de.spark.game.assets.CleverAssetManager;
import de.spark.game.entity.Hero;
import de.spark.game.entity.system.InputSystem;
import de.spark.game.entity.system.MovementSystem;
import de.spark.game.entity.system.RenderSystem;
import de.spark.game.map.MapRenderer;
import de.spark.game.map.Tilemap;

/**
 * @author Christian Bargmann <christian.bargmann@haw-hamburg.de>
 * @see de.spark.game
 * @since 24.10.2017 , 23:38:02
 *
 */
public class GameStartup extends Game {

	CleverAssetManager assetManager;
	Engine engine;
	SpriteBatch batch;
	Tilemap map;
	MapRenderer mapRenderer;

	/**
	 * Overriding method create defined in ApplicationListener. For further details
	 * please see
	 * 
	 * @see com.badlogic.gdx.ApplicationListener#create()
	 */
	@Override
	public void create() {

		assetManager = new CleverAssetManager();
		batch = new SpriteBatch();

		mapRenderer = new MapRenderer(assetManager, batch);
		map = new Tilemap();

		setupEngine();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);

		batch.begin();
		mapRenderer.render(map);
		engine.update(Gdx.graphics.getDeltaTime());
		batch.end();

	}

	private void setupEngine() {
		engine = new Engine();
		RenderSystem renderSystem = new RenderSystem(batch, assetManager);
		MovementSystem movementSystem = new MovementSystem();
		InputSystem inputSystem = new InputSystem();

		engine.addSystem(renderSystem);
		engine.addSystem(movementSystem);
		engine.addSystem(inputSystem);
		engine.addEntity(new Hero());
	}

}
