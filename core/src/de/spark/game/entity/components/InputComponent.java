package de.spark.game.entity.components;

import com.badlogic.ashley.core.Component;

/**
 * @author Christian Bargmann <christian.bargmann@haw-hamburg.de>
 * @see de.spark.game.entity.components
 * @since 25.10.2017 , 16:26:55
 *
 */
public class InputComponent implements Component {

	// DIRECTIONS
	private boolean up;
	private boolean down;
	private boolean left;
	private boolean right;

	/**
	 * Get-Method for up. Returns value of up to the client.
	 *
	 * @return the up
	 */
	public boolean isUp() {
		return up;
	}

	/**
	 * Set-Method for up. Returns value of up to the client.
	 *
	 * @param up
	 *            the up to set
	 */
	public void setUp(boolean up) {

		this.up = up;
	}

	/**
	 * Get-Method for down. Returns value of down to the client.
	 *
	 * @return the down
	 */
	public boolean isDown() {
		return down;
	}

	/**
	 * Set-Method for down. Returns value of down to the client.
	 *
	 * @param down
	 *            the down to set
	 */
	public void setDown(boolean down) {

		this.down = down;
	}

	/**
	 * Get-Method for left. Returns value of left to the client.
	 *
	 * @return the left
	 */
	public boolean isLeft() {
		return left;
	}

	/**
	 * Set-Method for left. Returns value of left to the client.
	 *
	 * @param left
	 *            the left to set
	 */
	public void setLeft(boolean left) {

		this.left = left;
	}

	/**
	 * Get-Method for right. Returns value of right to the client.
	 *
	 * @return the right
	 */
	public boolean isRight() {
		return right;
	}

	/**
	 * Set-Method for right. Returns value of right to the client.
	 *
	 * @param right
	 *            the right to set
	 */
	public void setRight(boolean right) {

		this.right = right;
	}

}
