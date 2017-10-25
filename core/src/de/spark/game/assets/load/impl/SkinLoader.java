package de.spark.game.assets.load.impl;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.ObjectMap;

import de.spark.game.assets.CleverAssetManager;
import de.spark.game.assets.load.CleverAssetLoader;

/**
 * @author Christian Bargmann <christian.bargmann@haw-hamburg.de>
 * @see de.spark.game.assets.load.impl
 * @since 25.10.2017 , 01:05:25
 *
 */
public class SkinLoader implements CleverAssetLoader {

	private CleverAssetManager assetManager;

	/**
	 * Constructor for new SkinLoader.
	 */
	public SkinLoader(CleverAssetManager assetmanager) {
		this.assetManager = assetmanager;
	}

	/**
	 * Overriding method loadAsset defined in SkinLoader. For further details please
	 * see
	 * 
	 * @see de.spark.game.assets.load.CleverAssetLoader#loadAsset(com.badlogic.gdx.files.FileHandle)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object loadAsset(FileHandle fileHandle) {
		FileHandle skinDescription = fileHandle.sibling(fileHandle.nameWithoutExtension() + ".sdesc");
		if (skinDescription.exists()) {
			ObjectMap<String, String> paramsMap = JSON.fromJson(ObjectMap.class, skinDescription);
			String atlasName = paramsMap.get("atlas");
			TextureAtlas atlas = assetManager.getAtlas(atlasName);

			return new Skin(fileHandle, atlas);
		} else {
			return new Skin(fileHandle);
		}
	}

}
