package de.spark.game.entity;

import com.badlogic.ashley.core.Entity;

import de.spark.game.entity.components.InputComponent;
import de.spark.game.entity.components.PositionComponent;
import de.spark.game.entity.components.TextureComponent;
import de.spark.game.entity.components.VelocityComponent;

/**
 * @author Christian Bargmann <christian.bargmann@haw-hamburg.de>
 * @see de.spark.game.entity
 * @since 25.10.2017 , 15:54:36
 *
 */
public class Hero extends Entity {

	/**
	 * Constructor for new Hero.
	 */
	public Hero() {
		PositionComponent position = new PositionComponent();
		VelocityComponent velocity = new VelocityComponent();
		velocity.setHorizontalSpeed(3);
		velocity.setVerticalSpeed(3);

		TextureComponent texture = new TextureComponent();
		texture.setHeight(8);
		texture.setWidth(8);
		texture.setTexture("hero");

		InputComponent input = new InputComponent();

		this.add(input);
		this.add(velocity);
		this.add(position);
		this.add(texture);
	}
}
