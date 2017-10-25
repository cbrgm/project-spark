package de.spark.game.assets.load.impl;

import java.util.Locale;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.I18NBundle;

import de.spark.game.assets.load.CleverAssetLoader;

/**
 * @author Christian Bargmann <christian.bargmann@haw-hamburg.de>
 * @see de.spark.game.assets.load.impl
 * @since 25.10.2017 , 00:34:51
 *
 */
public class I18NLoader implements CleverAssetLoader {

	private String locale;

	public void setLocale(String language) {
		this.locale = language;
	}

	public String getLocale() {
		return locale;
	}

	/**
	 * 
	 * Overriding method loadAsset defined in I18NLoader. For further details please
	 * see
	 * 
	 * @see de.spark.game.assets.load.CleverAssetLoader#loadAsset(com.badlogic.gdx.files.FileHandle)
	 */
	@Override
	public Object loadAsset(FileHandle fileHandle) {
		return I18NBundle.createBundle(fileHandle.parent().child(fileHandle.nameWithoutExtension()),
				new Locale(locale));
	}

}
