package de.spark.game.entity.system;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

import de.spark.game.entity.components.BodyComponent;
import de.spark.game.entity.components.TransformComponent;

/**
 * @author Christian Bargmann <christian.bargmann@haw-hamburg.de>
 * @see de.spark.game.entity.system
 * @since 25.10.2017 , 23:59:01
 *
 */
public class Box2DPhysicsSystem extends IteratingSystem {

	private ComponentMapper<TransformComponent> tm = ComponentMapper.getFor(TransformComponent.class);
	private ComponentMapper<BodyComponent> bm = ComponentMapper.getFor(BodyComponent.class);

	private static final float MAX_STEP_TIME = 1 / 45f;
	private static float accumulator = 0f;

	private World world;
	private Array<Entity> bodiesQueue;

	public Box2DPhysicsSystem(World world) {
		super(Family.all(BodyComponent.class, TransformComponent.class).get());

		this.world = world;
		this.bodiesQueue = new Array<Entity>();
	}

	@Override
	public void update(float deltaTime) {
		super.update(deltaTime);
		float frameTime = Math.min(deltaTime, 0.25f);
		accumulator += frameTime;
		if (accumulator >= MAX_STEP_TIME) {
			world.step(MAX_STEP_TIME, 6, 2);
			accumulator -= MAX_STEP_TIME;

			// Entity Queue
			for (Entity entity : bodiesQueue) {
				TransformComponent transform = tm.get(entity);
				BodyComponent body = bm.get(entity);
				Vector2 position = body.getBody().getPosition();
				transform.position.x = position.x;
				transform.position.y = position.y;
				transform.rotation = body.getBody().getAngle() * MathUtils.radiansToDegrees;
			}
		}

		bodiesQueue.clear();
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		bodiesQueue.add(entity);
	}

}
