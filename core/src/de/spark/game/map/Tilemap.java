package de.spark.game.map;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Christian Bargmann <christian.bargmann@haw-hamburg.de>
 * @see de.spark.game.map
 * @since 15.10.2017 , 15:50:53
 *
 */
public class Tilemap {

	public final int CHUNK_DIMENSION = 50;
	public final int TILE_SIZE = 8;

	private Chunk chunkData;

	/**
	 * Constructor for new Tilemap.
	 */
	public Tilemap() {
		setupTiles();
		setupTileCodes();
		replaceBorderTiles();
	}

	/**
	 * 
	 */
	private void replaceBorderTiles() {

		// Arrays for mapping code to texture
		String[] a_grass_left = { "001001001", "001001001", "001001000", "000001001" };
		String[] a_grass_right = { "100100100", "100100000", "000100100" };
		String[] a_grass_r_end = { "100000000" };
		String[] a_grass_l_end = { "001000000" };
		String[] a_grass_top = { "000000111", "000000011", "000000110" };
		String[] a_grass_top_right = { "000000100" };
		String[] a_grass_top_left = { "000000001" };
		String[] a_cliff_bottom = { "011000000", "111000000", "110000000" };

		for (Tile tile : chunkData.getTiles()) {
			if (Arrays.asList(a_grass_left).contains(tile.getTileCode())) {
				tile.setTexture("right_grass_edge");
			} else if (Arrays.asList(a_grass_right).contains(tile.getTileCode())) {
				tile.setTexture("left_grass_edge");
			} else if (Arrays.asList(a_grass_r_end).contains(tile.getTileCode())) {
				tile.setTexture("left_upper_edge");
			} else if (Arrays.asList(a_grass_l_end).contains(tile.getTileCode())) {
				tile.setTexture("right_upper_edge");
			} else if (Arrays.asList(a_grass_top).contains(tile.getTileCode())) {
				tile.setTexture("top");
			} else if (Arrays.asList(a_grass_top_right).contains(tile.getTileCode())) {
				tile.setTexture("top_right");
			} else if (Arrays.asList(a_grass_top_left).contains(tile.getTileCode())) {
				tile.setTexture("top_left");
			} else if (Arrays.asList(a_cliff_bottom).contains(tile.getTileCode())) {
				tile.setTexture("cliff");
			}
		}
	}

	/**
	 * Returns Chunk Data
	 * 
	 * @return
	 */
	public Chunk getChunks() {
		return chunkData;
	}

	/**
	 * Sets tile codes needed for MapRenderer
	 */
	private void setupTileCodes() {
		chunkData.encodeTiles();

	}

	/**
	 * Initializes TileData of the world map. Tiles can be set up manually or
	 * generated by algorithm
	 */
	private void setupTiles() {
		chunkData = new Chunk(CHUNK_DIMENSION);

		Tile tile;

		for (int x = 0; x < CHUNK_DIMENSION; x++) {
			for (int y = 0; y < CHUNK_DIMENSION; y++) {
				tile = new Tile();
				tile.setTexture("water_0" + (new Random().nextInt((4 - 1) + 1) + 1));
				tile.setPassable(false);
				chunkData.setTileAtPosition(tile, x, y);
			}

			int row[] = { -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5 };
			int col[] = { 5, 4, 3, 2, 1, 0, -1, -2, -3, -4, -5 };

			for (int r : row) {
				for (int c : col) {
					tile = new Tile();
					tile.setTexture("grass_0" + (new Random().nextInt((4 - 1) + 1) + 1));
					tile.setPassable(true);
					chunkData.setTileAtPosition(tile, 16 + r, 16 + c);
				}
			}
		}

	}

}
