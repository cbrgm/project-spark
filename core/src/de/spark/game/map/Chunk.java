package de.spark.game.map;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.ashley.core.Entity;

import de.spark.game.util.Util;

/**
 * @author Christian Bargmann <christian.bargmann@haw-hamburg.de>
 * @see de.spark.game.map
 * @since 15.10.2017 , 16:06:34
 *
 */
public class Chunk {

	private final int CHUNK_DIMENSION;
	private Tile[][] tileData;
	private List<Entity> entityData;

	/**
	 * Constructor for new NewChunk.
	 */
	public Chunk(int dimension) {
		CHUNK_DIMENSION = dimension;

		tileData = new Tile[CHUNK_DIMENSION][CHUNK_DIMENSION];
	}

	/**
	 * Gets the Tile at position in chunk using coordinates.
	 * 
	 * @param width
	 * @param height
	 * @return
	 */
	public Tile getTileAtPosition(int width, int height) {
		Util.throwIfNull(width, height);

		return tileData[width][height];
	}

	/**
	 * Sets the Tile at position in chunk using coordinates.
	 * 
	 * @param width
	 * @param height
	 */
	public void setTileAtPosition(Tile tile, int width, int height) {
		Util.throwIfNull(tile, width, height);

		tile.setCoordinates(width, height);
		tileData[width][height] = tile;

	}

	/**
	 * Returns a List containing all tiles within the chunk
	 * 
	 * @return
	 */
	public List<Tile> getTiles() {
		ArrayList<Tile> result = new ArrayList<Tile>();

		for (int x = 0; x < tileData.length; x++)
			for (int y = 0; y < tileData[x].length; y++)
				result.add(tileData[x][y]);

		return result;

	}

	/**
	 * Sets the tilecode for every active tile in Chunk
	 */
	public void encodeTiles() {
		for (int x = 0; x < tileData.length; x++) {
			for (int y = 0; y < tileData[x].length; y++) {

				if (this.getTileAtPosition(x, y) != null) {
					Tile tile = this.getTileAtPosition(x, y);

					int[] rows = { 1, 0, -1 };
					int[] cols = { -1, 0, 1 };

					for (int row : rows) {
						for (int col : cols) {
							tile.setTileCode(tile.getTileCode() + calculateTileCode(x + col, y + row));
						}
					}

				}
			}
		}
	}

	/**
	 * Adds an Entity to the chunk
	 * 
	 * @return
	 */
	public void addEntity(Entity entity) {
		Util.throwIfNull(entity);
		entityData.add(entity);
	}

	/**
	 * Removes an Entity from the chunk
	 * 
	 * @param entity
	 */
	public void removeEntity(Entity entity) {
		for (Entity e : entityData) {
			if (e.equals(entity))
				entityData.remove(entity);
		}
	}

	/**
	 * Private helper method for calculating tile code
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	private String calculateTileCode(int x, int y) {

		if (isInChunkRange(x, y)) {
			if (this.getTileAtPosition(x, y) != null) {
				Tile tile = this.getTileAtPosition(x, y);
				return tile.isPassable() ? "1" : "0";
			}
		}
		return "0";
	}

	private boolean isInChunkRange(int width, int height) {
		if (width < 0 || width >= CHUNK_DIMENSION || height < 0 || height >= CHUNK_DIMENSION)
			return false;
		return true;

	}

}
