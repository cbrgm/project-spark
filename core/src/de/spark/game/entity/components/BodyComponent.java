package de.spark.game.entity.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.physics.box2d.Body;

/**
 * @author Christian Bargmann <christian.bargmann@haw-hamburg.de>
 * @see de.spark.game.entity.components
 * @since 25.10.2017 , 23:49:20
 *
 */
public class BodyComponent implements Component {

	private Body body;

	/**
	 * Get-Method for body. Returns value of body to the client.
	 *
	 * @return the body
	 */
	public Body getBody() {
		return body;
	}

	/**
	 * Set-Method for body. Returns value of body to the client.
	 *
	 * @param body
	 *            the body to set
	 */
	public void setBody(Body body) {
		assert body != null : "Pre-Condition failed, body != null!";

		this.body = body;
	}

}
