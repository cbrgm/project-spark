package de.spark.game.assets;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.graphics.Texture;

import de.spark.game.assets.load.CleverFileResolver;
import de.spark.game.assets.load.impl.TextureLoader;

/**
 * @author Christian Bargmann <christian.bargmann@haw-hamburg.de>
 * @see de.spark.game.assets.load
 * @since 24.10.2017 , 22:59:52
 *
 */
class CleverDefaultLoader {

	public static final String DEFAULT_ATLASES_FOLDER = "atlases";
	public static final String DEFAULT_TEXTURES_FOLDER = "textures";
	public static final String DEFAULT_PIXMAPS_FOLDER = "pixmaps";
	public static final String DEFAULT_SOUNDS_FOLDER = "sounds";
	public static final String DEFAULT_MUSIC_FOLDER = "music";
	public static final String DEFAULT_CONFIGS_FOLDER = "configs";
	public static final String DEFAULT_FONTS_FOLDER = "fonts";
	public static final String DEFAULT_I18N_FOLDER = "i18n";
	public static final String DEFAULT_SKINS_FOLDER = "skins";

	public static final String PNG_SUFFIX = "png";
	public static final String JPG_SUFFIX = "jpg";
	public static final String ETC1_SUFFIX = "etc1";
	public static final String ATLAS_SUFFIX = "atlas";
	public static final String PACK_SUFFIX = "pack";
	public static final String MP3_SUFFIX = "mp3";
	public static final String OGG_SUFFIX = "ogg";
	public static final String WAV_SUFFIX = "wav";
	public static final String JSON_SUFFIX = "json";
	public static final String BITMAP_FONT_SUFFIX = "fnt";
	public static final String I18N_SUFFIX = "properties";
	public static final String SKIN_SUFFIX = "json";

	CleverAssetManager manager;

	public CleverDefaultLoader(CleverAssetManager assetManager) {
		manager = assetManager;
	}

	public void registerTextureLoader() {
		CleverFileResolver resolver = new CleverFileResolver();
		resolver.addSuffixes(PNG_SUFFIX, JPG_SUFFIX, ETC1_SUFFIX);
		resolver.addFolders(DEFAULT_TEXTURES_FOLDER, DEFAULT_ATLASES_FOLDER);
		resolver.addFileType(Files.FileType.Internal);

		manager.registerAssetLoader(Texture.class, new TextureLoader());
		manager.registerAssetResolver(Texture.class, resolver);
	}

	/**
	 * Registers all loaders to the asset manager
	 */
	public void registerLoaders() {
		registerTextureLoader();
	}

}
