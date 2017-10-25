package de.spark.game.entity.system;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import de.spark.game.assets.CleverAssetManager;
import de.spark.game.entity.components.PositionComponent;
import de.spark.game.entity.components.TextureComponent;

/**
 * @author Christian Bargmann <christian.bargmann@haw-hamburg.de>
 * @see de.spark.game.entity.system
 * @since 25.10.2017 , 16:44:54
 *
 */
public class RenderSystem extends EntitySystem {

	private SpriteBatch batch;
	private CleverAssetManager assetManager;

	private ImmutableArray<Entity> entities;

	private ComponentMapper<PositionComponent> pm = ComponentMapper.getFor(PositionComponent.class);
	private ComponentMapper<TextureComponent> tm = ComponentMapper.getFor(TextureComponent.class);

	/**
	 * Constructor for new RenderSystem.
	 */
	public RenderSystem(SpriteBatch batch, CleverAssetManager assetmanager) {
		this.batch = batch;
		this.assetManager = assetmanager;
	}

	public void addedToEngine(Engine engine) {
		entities = engine.getEntitiesFor(Family.all(TextureComponent.class, PositionComponent.class).get());
	}

	public void update(float deltaTime) {
		for (int i = 0; i < entities.size(); ++i) {
			Entity entity = entities.get(i);

			Texture texture = assetManager.getTexture(entity.getComponent(TextureComponent.class).getTexture());
			batch.draw(texture, entity.getComponent(PositionComponent.class).getCoordinates().x,
					entity.getComponent(PositionComponent.class).getCoordinates().y);
		}
	}

}
