package de.spark.game.assets.load.impl;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ObjectMap;

import de.spark.game.assets.CleverAssetManager;
import de.spark.game.assets.load.CleverAssetLoader;

/**
 * @author Christian Bargmann <christian.bargmann@haw-hamburg.de>
 * @see de.spark.game.assets.load.impl
 * @since 25.10.2017 , 00:38:29
 *
 */
public class BitmapFontLoader implements CleverAssetLoader {

	private CleverAssetManager assetmanager;

	/**
	 * Constructor for new BitmapFontLoader.
	 */
	public BitmapFontLoader(CleverAssetManager assetmanager) {
		this.assetmanager = assetmanager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object loadAsset(FileHandle fileHandle) {
		String name = fileHandle.nameWithoutExtension();
		FileHandle parent = fileHandle.parent();
		FileHandle fontConfig = parent.child(name + ".bfdesc");
		if (fontConfig.exists()) {
			ObjectMap<String, String> bitmapFontParams = JSON.fromJson(ObjectMap.class, fontConfig);
			String atlasName = bitmapFontParams.get("atlas");
			String regionName = bitmapFontParams.get("region");

			if (atlasName == null && regionName == null) {
				return new BitmapFont(fileHandle);
			} else if (atlasName != null && regionName == null) {
				regionName = name;
			}

			TextureRegion region = assetmanager.getRegion(atlasName, regionName);
			return new BitmapFont(fileHandle, region);
		} else {
			return new BitmapFont(fileHandle);
		}

	}
}