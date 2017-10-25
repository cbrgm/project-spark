package de.spark.game.assets.load;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;

/**
 * @author Christian Bargmann <christian.bargmann@haw-hamburg.de>
 * @see de.spark.game.assets.load
 * @since 24.10.2017 , 21:02:04
 *
 */
public interface CleverAssetLoader {

	Json JSON = new Json();

	Object loadAsset(FileHandle fileHandle);

}
