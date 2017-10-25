package de.spark.game.entity;

import com.badlogic.ashley.core.Entity;

import de.spark.game.entity.components.BodyComponent;
import de.spark.game.entity.components.PositionComponent;
import de.spark.game.entity.components.TextureComponent;

/**
 * @author Christian Bargmann <christian.bargmann@haw-hamburg.de>
 * @see de.spark.game.entity.system
 * @since 26.10.2017 , 00:21:41
 *
 */
public class Tile extends Entity {

	private BodyComponent body;
	private TextureComponent texture;
	private PositionComponent position;

	/**
	 * Constructor for new Tile.
	 */
	public Tile() {
		initComponents();
		
		body.setBody();
		texture.setTexture("grass_01");
		
		addComponents();
	}

	private void initComponents() {
		texture = new TextureComponent();
		body = new BodyComponent();
		position = new PositionComponent();
	}

	private void addComponents() {
		this.add(body);
		this.add(position);
		this.add(texture);
	}
}
