package de.spark.game.entity.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector3;

/**
 * @author Christian Bargmann <christian.bargmann@haw-hamburg.de>
 * @see de.spark.game.entity
 * @since 25.10.2017 , 15:39:42
 *
 */
public class PositionComponent implements Component {

	private Vector3 position;

	public PositionComponent() {
		position = new Vector3(0, 0, 0);
	}

	/**
	 * Get-Method for coordinates. Returns value of coordinates to the client.
	 *
	 * @return the coordinates
	 */
	public Vector3 getCoordinates() {
		return position;
	}

	/**
	 * Set-Method for coordinates. Returns value of coordinates to the client.
	 *
	 * @param coordinates
	 *            the coordinates to set
	 */
	public void setCoordinates(Vector3 coordinates) {
		assert coordinates != null : "Pre-Condition failed, coordinates != null!";

		this.position = coordinates;
	}

	/**
	 * Set-Method for coordinates. Returns value of coordinates to the client.
	 *
	 * @param coordinates
	 *            the coordinates to set
	 */
	public void setCoordinates(float x, float y, float z) {
		Vector3 v3 = new Vector3(x, y, z);

		this.position = v3;
	}

	/**
	 * Set-Method for coordinates. Returns value of coordinates to the client.
	 *
	 * @param coordinates
	 *            the coordinates to set
	 */
	public void setX(float x) {

		this.position.x = x;
	}

	/**
	 * Set-Method for coordinates. Returns value of coordinates to the client.
	 *
	 * @param coordinates
	 *            the coordinates to set
	 */
	public void setY(float y) {

		this.position.y = y;
	}

	/**
	 * Set-Method for coordinates. Returns value of coordinates to the client.
	 *
	 * @param coordinates
	 *            the coordinates to set
	 */
	public void setZ(float z) {

		this.position.z = z;
	}

}
