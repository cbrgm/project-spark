package de.spark.game.entity.system;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;

import de.spark.game.entity.components.InputComponent;
import de.spark.game.entity.components.PositionComponent;
import de.spark.game.entity.components.VelocityComponent;

/**
 * @author Christian Bargmann <christian.bargmann@haw-hamburg.de>
 * @see de.spark.game.entity.system
 * @since 25.10.2017 , 16:42:34
 *
 */
public class InputSystem extends EntitySystem {

	private ImmutableArray<Entity> entities;

	private ComponentMapper<PositionComponent> pm = ComponentMapper.getFor(PositionComponent.class);
	private ComponentMapper<VelocityComponent> vm = ComponentMapper.getFor(VelocityComponent.class);
	private ComponentMapper<InputComponent> im = ComponentMapper.getFor(InputComponent.class);

	private OrthographicCamera camera;

	/**
	 * Constructor for new InputSystem.
	 */
	public InputSystem(OrthographicCamera camera) {
		this.camera = camera;
	}

	public void addedToEngine(Engine engine) {
		entities = engine.getEntitiesFor(
				Family.all(PositionComponent.class, VelocityComponent.class, InputComponent.class).get());
	}

	public void update(float deltaTime) {

		for (int i = 0; i < entities.size(); ++i) {
			Entity entity = entities.get(i);

			PositionComponent position = pm.get(entity);
			VelocityComponent velocity = vm.get(entity);
			InputComponent input = im.get(entity);

			// reset all variables
			input.setUp(false);
			input.setDown(false);
			input.setRight(false);
			input.setLeft(false);

			velocity.setDirectionX(0);
			velocity.setDirectionY(0);

			// set boolean to true if key is touched
			if (Gdx.input.isKeyPressed(Keys.LEFT)) {
				input.setLeft(true);
				velocity.setDirectionX(-1);
			}
			if (Gdx.input.isKeyPressed(Keys.DOWN)) {
				input.setDown(true);
				velocity.setDirectionY(-1);
			}
			if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
				input.setRight(true);
				velocity.setDirectionX(1);
			}
			if (Gdx.input.isKeyPressed(Keys.UP)) {
				input.setUp(true);
				velocity.setDirectionY(1);
			}

			position.setX(position.getCoordinates().x + velocity.getDirectionX() * velocity.getVerticalSpeed());
			position.setY(position.getCoordinates().y + velocity.getDirectionY() * velocity.getHorizontalSpeed());

			camera.position.lerp(position.getCoordinates(), .2f);
			camera.update();

		}
	}
}
