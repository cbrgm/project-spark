package de.spark.game.assets.load.impl;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import de.spark.game.assets.load.CleverAssetLoader;

/**
 * @author Christian Bargmann <christian.bargmann@haw-hamburg.de>
 * @see de.spark.game.assets.load
 * @since 25.10.2017 , 00:17:21
 *
 */
public class TextureAtlasLoader implements CleverAssetLoader {

	/**
	 * Overriding method loadAsset defined in CleverAssetLoader. For further details
	 * please see
	 * 
	 * @see de.spark.game.assets.load.CleverAssetLoader#loadAsset(com.badlogic.gdx.files.FileHandle)
	 */
	@Override
	public Object loadAsset(FileHandle fileHandle) {
		return new TextureAtlas(fileHandle);
	}

}
