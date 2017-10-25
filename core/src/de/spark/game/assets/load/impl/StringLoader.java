package de.spark.game.assets.load.impl;

import com.badlogic.gdx.files.FileHandle;

import de.spark.game.assets.load.CleverAssetLoader;

/**
 * @author Christian Bargmann <christian.bargmann@haw-hamburg.de>
 * @see de.spark.game.assets.load
 * @since 25.10.2017 , 00:19:29
 *
 */
public class StringLoader implements CleverAssetLoader {

	private String encoding = "UTF-8";

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public String getEncoding() {
		return encoding;
	}

	/**
	 * Overriding method loadAsset defined in CleverAssetLoader. For further details
	 * please see
	 * 
	 * @see de.spark.game.assets.load.CleverAssetLoader#loadAsset(com.badlogic.gdx.files.FileHandle)
	 */
	@Override
	public Object loadAsset(FileHandle fileHandle) {
		return fileHandle.readString(encoding);
	}

}
