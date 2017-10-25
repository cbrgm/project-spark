package de.spark.game;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
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

	OrthographicCamera camera;
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

		setupCamera();
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

	private void setupCamera() {
		// CAMERA
		int displayW = Gdx.graphics.getWidth();
		int displayH = Gdx.graphics.getHeight();

		// For 800x600 = 266*200
		int h = (int) (displayH / Math.floor(displayH / 160));
		int w = (int) (displayW / (displayH / (displayH / Math.floor(displayH / 160))));

		camera = new OrthographicCamera(w, h);
		camera.zoom = .6f;
	}

	private void setupEngine() {
		engine = new Engine();
		RenderSystem renderSystem = new RenderSystem(batch, camera, assetManager);
		MovementSystem movementSystem = new MovementSystem();
		InputSystem inputSystem = new InputSystem(camera);

		engine.addSystem(renderSystem);
		engine.addSystem(movementSystem);
		engine.addSystem(inputSystem);
		engine.addEntity(new Hero());
	}

}
