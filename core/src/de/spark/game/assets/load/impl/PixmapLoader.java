package de.spark.game.assets.load.impl;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;

import de.spark.game.assets.load.CleverAssetLoader;

/**
 * @author Christian Bargmann <christian.bargmann@haw-hamburg.de>
 * @see de.spark.game.assets.load.impl
 * @since 25.10.2017 , 00:32:16
 *
 */
public class PixmapLoader implements CleverAssetLoader {

	/**
	 * Overriding method loadAsset defined in PixmapLoader. For further details
	 * please see
	 * 
	 * @see de.spark.game.assets.load.CleverAssetLoader#loadAsset(com.badlogic.gdx.files.FileHandle)
	 */
	@Override
	public Object loadAsset(FileHandle fileHandle) {
		return new Pixmap(fileHandle);
	}

}
