package de.spark.game.entity.system;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;

import de.spark.game.entity.components.PositionComponent;
import de.spark.game.entity.components.VelocityComponent;

/**
 * @author Christian Bargmann <christian.bargmann@haw-hamburg.de>
 * @see de.spark.game.entity.system
 * @since 25.10.2017 , 15:46:09
 *
 */
public class MovementSystem extends EntitySystem {

	private ImmutableArray<Entity> entities;

	private ComponentMapper<PositionComponent> pm = ComponentMapper.getFor(PositionComponent.class);
	private ComponentMapper<VelocityComponent> vm = ComponentMapper.getFor(VelocityComponent.class);

	public void addedToEngine(Engine engine) {
		entities = engine.getEntitiesFor(Family.all(PositionComponent.class, VelocityComponent.class).get());
	}

	public void update(float deltaTime) {
		for (int i = 0; i < entities.size(); ++i) {
			Entity entity = entities.get(i);
			PositionComponent position = pm.get(entity);
			VelocityComponent velocity = vm.get(entity);

			position.getCoordinates().x += velocity.getVerticalSpeed() * velocity.getDirectionX();
			position.getCoordinates().y += velocity.getHorizontalSpeed() * velocity.getDirectionY();
		}
	}

}
