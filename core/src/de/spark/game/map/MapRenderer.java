package de.spark.game.map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import de.spark.game.assets.CleverAssetManager;

/**
 * @author Christian Bargmann <christian.bargmann@haw-hamburg.de>
 * @see de.spark.game.map
 * @since 16.10.2017 , 02:17:52
 *
 */
public class MapRenderer {

	private CleverAssetManager assetManager;
	private SpriteBatch batch;

	public MapRenderer(CleverAssetManager assetManager, SpriteBatch batch) {
		this.assetManager = assetManager;
		this.batch = batch;
	}

	public void render(Tilemap map) {
		for (Tile tile : map.getChunks().getTiles())
			for (String texture : tile.getTexture()) {
				batch.draw(assetManager.getTexture(texture), tile.getCoordinates().x * map.TILE_SIZE,
						tile.getCoordinates().y * map.TILE_SIZE, map.TILE_SIZE, map.TILE_SIZE);
			}
	}
}
