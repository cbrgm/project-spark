package de.spark.game.assets.load.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import de.spark.game.assets.load.CleverAssetLoader;

/**
 * @author Christian Bargmann <christian.bargmann@haw-hamburg.de>
 * @see de.spark.game.assets.load.impl
 * @since 25.10.2017 , 00:33:07
 *
 */
public class MusicLoader implements CleverAssetLoader {

	/**
	 * Overriding method loadAsset defined in MusicLoader. For further details
	 * please see
	 * 
	 * @see de.spark.game.assets.load.CleverAssetLoader#loadAsset(com.badlogic.gdx.files.FileHandle)
	 */
	@Override
	public Object loadAsset(FileHandle fileHandle) {
		return Gdx.audio.newMusic(fileHandle);
	}

}
