package de.spark.game.entity.components;

import com.badlogic.ashley.core.Component;

/**
 * @author Christian Bargmann <christian.bargmann@haw-hamburg.de>
 * @see de.spark.game.entity
 * @since 25.10.2017 , 15:40:11
 *
 */
public class VelocityComponent implements Component {

	private int directionX = 0;
	private int directionY = 0;

	private float verticalSpeed = 0.0f;
	private float horizontalSpeed = 0.0f;

	/**
	 * Get-Method for directionX. Returns value of directionX to the client.
	 *
	 * @return the directionX
	 */
	public int getDirectionX() {
		return directionX;
	}

	/**
	 * Get-Method for directionY. Returns value of directionY to the client.
	 *
	 * @return the directionY
	 */
	public int getDirectionY() {
		return directionY;
	}

	/**
	 * Get-Method for horizontalSpeed. Returns value of horizontalSpeed to the
	 * client.
	 *
	 * @return the horizontalSpeed
	 */
	public float getHorizontalSpeed() {
		return horizontalSpeed;
	}

	/**
	 * Get-Method for verticalSpeed. Returns value of verticalSpeed to the client.
	 *
	 * @return the verticalSpeed
	 */
	public float getVerticalSpeed() {
		return verticalSpeed;
	}

	/**
	 * Set-Method for directionX. Returns value of directionX to the client.
	 *
	 * @param directionX
	 *            the directionX to set
	 */
	public void setDirectionX(int directionX) {

		this.directionX = directionX;
	}

	/**
	 * Set-Method for directionY. Returns value of directionY to the client.
	 *
	 * @param directionY
	 *            the directionY to set
	 */
	public void setDirectionY(int directionY) {

		this.directionY = directionY;
	}

	/**
	 * Set-Method for horizontalSpeed. Returns value of horizontalSpeed to the
	 * client.
	 *
	 * @param horizontalSpeed
	 *            the horizontalSpeed to set
	 */
	public void setHorizontalSpeed(float horizontalSpeed) {

		this.horizontalSpeed = horizontalSpeed;
	}

	/**
	 * Set-Method for verticalSpeed. Returns value of verticalSpeed to the client.
	 *
	 * @param verticalSpeed
	 *            the verticalSpeed to set
	 */
	public void setVerticalSpeed(float verticalSpeed) {

		this.verticalSpeed = verticalSpeed;
	}

}
