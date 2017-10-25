package de.spark.game.entity.components;

import com.badlogic.ashley.core.Component;

/**
 * @author Christian Bargmann <christian.bargmann@haw-hamburg.de>
 * @see de.spark.game.entity.components
 * @since 25.10.2017 , 16:28:02
 *
 */
public class TextureComponent implements Component {

	private String texture;
	private int width;
	private int height;

	/**
	 * Get-Method for texture. Returns value of texture to the client.
	 *
	 * @return the texture
	 */
	public String getTexture() {
		return texture;
	}

	/**
	 * Set-Method for texture. Returns value of texture to the client.
	 *
	 * @param texture
	 *            the texture to set
	 */
	public void setTexture(String texture) {
		assert texture != null : "Pre-Condition failed, texture != null!";

		this.texture = texture;
	}

	/**
	 * Get-Method for width. Returns value of width to the client.
	 *
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Set-Method for width. Returns value of width to the client.
	 *
	 * @param width
	 *            the width to set
	 */
	public void setWidth(int width) {

		this.width = width;
	}

	/**
	 * Get-Method for height. Returns value of height to the client.
	 *
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Set-Method for height. Returns value of height to the client.
	 *
	 * @param height
	 *            the height to set
	 */
	public void setHeight(int height) {

		this.height = height;
	}

}
