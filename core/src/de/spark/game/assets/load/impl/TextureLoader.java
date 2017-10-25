package de.spark.game.assets.load.impl;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;

import de.spark.game.assets.load.CleverAssetLoader;

/**
 * @author Christian Bargmann <christian.bargmann@haw-hamburg.de>
 * @see de.spark.game.assets.load
 * @since 24.10.2017 , 21:03:34
 *
 */
public class TextureLoader implements CleverAssetLoader {

	/**
	 * Overriding method loadAsset defined in TextureLoader. For further details
	 * please see
	 * 
	 * @see de.spark.game.assets.load.CleverAssetLoader#loadAsset(com.badlogic.gdx.files.FileHandle)
	 */
	@Override
	public Object loadAsset(FileHandle fileHandle) {
		Texture result = new Texture(fileHandle);
		return result;
	}

}
