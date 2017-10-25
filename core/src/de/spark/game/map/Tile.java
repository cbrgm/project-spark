package de.spark.game.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

/**
 * @author Christian Bargmann <christian.bargmann@haw-hamburg.de>
 * @see de.spark.game.map
 * @since 16.10.2017 , 00:16:57
 *
 */
public class Tile {

	private String tileCode;
	private List<String> texture;

	private Vector2 coordinates;

	private boolean isPassable;

	/**
	 * Constructor for new Tile.
	 */
	public Tile() {

		texture = new ArrayList<String>();
		tileCode = "";
		isPassable = true;
	}

	/**
	 * Get-Method for coordinates. Returns value of coordinates to the client.
	 *
	 * @return the coordinates
	 */
	public Vector2 getCoordinates() {
		return coordinates;
	}

	/**
	 * Get-Method for texture. Returns value of texture to the client.
	 *
	 * @return the texture
	 */
	public List<String> getTexture() {
		return texture;
	}

	/**
	 * Get-Method for tileCode. Returns value of tileCode to the client.
	 *
	 * @return the tileCode
	 */
	public String getTileCode() {
		return tileCode;
	}

	/**
	 * Get-Method for isPassable. Returns value of isPassable to the client.
	 *
	 * @return the isPassable
	 */
	public boolean isPassable() {
		return isPassable;
	}

	/**
	 * Set-Method for coordinates. Returns value of coordinates to the client.
	 *
	 * @param coordinates
	 *            the coordinates to set
	 */
	public void setCoordinates(float x, float y) {
		assert coordinates != null : "Pre-Condition failed, coordinates != null!";
		Vector2 v2 = new Vector2(x, y);

		this.coordinates = v2;
	}

	/**
	 * Set-Method for coordinates. Returns value of coordinates to the client.
	 *
	 * @param coordinates
	 *            the coordinates to set
	 */
	public void setCoordinates(Vector2 coordinates) {
		assert coordinates != null : "Pre-Condition failed, coordinates != null!";

		this.coordinates = coordinates;
	}

	/**
	 * Set-Method for isPassable. Returns value of isPassable to the client.
	 *
	 * @param isPassable
	 *            the isPassable to set
	 */
	public void setPassable(boolean isPassable) {

		this.isPassable = isPassable;
	}

	/**
	 * Set-Method for texture. Returns value of texture to the client.
	 *
	 * @param texture
	 *            the texture to set
	 */
	public void setTexture(String... texture) {
		assert texture != null : "Pre-Condition failed, texture != null!";

		for (String s : texture) {
			this.texture.add(s);
		}
	}

	/**
	 * Set-Method for tileCode. Returns value of tileCode to the client.
	 *
	 * @param tileCode
	 *            the tileCode to set
	 */
	public void setTileCode(String tileCode) {
		assert tileCode != null : "Pre-Condition failed, tileCode != null!";

		this.tileCode = tileCode;
	}
}
