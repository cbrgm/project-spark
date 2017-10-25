package de.spark.game.assets;

import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.I18NBundle;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.ObjectMap;

import de.spark.game.assets.load.CleverAssetLoader;
import de.spark.game.assets.load.impl.I18NLoader;

/**
 * 
 * @author Christian Bargmann <christian.bargmann@haw-hamburg.de>
 * @see de.spark.game.assets
 * @since 24.10.2017 , 18:45:45
 *
 */
public class CleverAssetManager {

	private static Json json;
	private ObjectMap<Class<?>, CleverAssetLoader> assetLoaders = new ObjectMap<Class<?>, CleverAssetLoader>();
	private ObjectMap<Class<?>, FileHandleResolver> assetResolvers = new ObjectMap<Class<?>, FileHandleResolver>();
	private ObjectMap<Class<?>, ObjectMap<String, Object>> loadedAssets = new ObjectMap<Class<?>, ObjectMap<String, Object>>();

	CleverDefaultLoader config;

	/**
	 * Constructor for new AbstractCleverAssetManager.
	 */
	public CleverAssetManager() {
		json = new Json();
		config = new CleverDefaultLoader(this);
		config.registerLoaders();
	}

	/**
	 * Disposes all loaded assets
	 */
	public void dispose() {
		for (ObjectMap<?, ?> assetMap : loadedAssets.values()) {
			for (Object asset : assetMap.values()) {
				if (asset instanceof Disposable) {
					((Disposable) asset).dispose();
				}
			}
		}

		loadedAssets.clear();
		assetLoaders.clear();
		assetResolvers.clear();
	}

	/**
	 * Loads the asset.
	 * 
	 * @param name
	 * @param class
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private <T extends Object> T getAsset(String name, Class<T> classType) {
		ObjectMap<String, Object> assetMap = getAssetMap(classType);

		// if asset has not been loaded yet, load it!
		if (!assetMap.containsKey(name)) {
			loadAsset(classType, name);
		}

		return (T) getAssetMap(classType).get(name);

	}

	/**
	 * Returns the AssetLoader
	 * 
	 * @param classType
	 * @return
	 */
	private CleverAssetLoader getAssetLoader(Class<?> classType) {
		return assetLoaders.get(classType);
	}

	/**
	 * Returns the asset map of asset type. CleverAssets stores every assetType in
	 * an extra ObjectMap. If the ObjectMap of a given asset type exists, the
	 * reference is returned, else a new ObjectMap will be initialized
	 * 
	 * @param classType
	 * @return
	 */
	private ObjectMap<String, Object> getAssetMap(Class<?> classType) {
		if (!loadedAssets.containsKey(classType)) {
			loadedAssets.put(classType, new ObjectMap<String, Object>());
		}
		return loadedAssets.get(classType);
	}

	/**
	 * Returns the AssetResolver
	 * 
	 * @param assetClass
	 * @return
	 */
	@SuppressWarnings("unused")
	private FileHandleResolver getAssetResolver(Class<?> assetClass) {
		return assetResolvers.get(assetClass);
	}

	/**
	 * Loads an atlas asset. After loading the asset will be cached by the asset
	 * manager.
	 * 
	 * @param name
	 * @return
	 */
	public TextureAtlas getAtlas(String name) {
		return getAsset(name, TextureAtlas.class);
	}

	/**
	 * Loads a font asset. After loading the asset will be cached by the asset
	 * manager.
	 * 
	 * @param name
	 * @return
	 */
	public BitmapFont getFont(String name) {
		return getAsset(name, BitmapFont.class);
	}

	/**
	 * Loads a I18NBundle asset. After loading the asset will be cached by the asset
	 * manager.
	 * 
	 * @param name
	 * @return
	 */
	public I18NBundle getI18NBundle(String name, String locale) {
		unloadAsset(name, I18NBundle.class);
		I18NLoader loader = (I18NLoader) getAssetLoader(I18NBundle.class);
		loader.setLocale(locale);
		return getAsset(name, I18NBundle.class);
	}

	/**
	 * Loads a json config asset. After loading the asset will be cached by the
	 * asset manager.
	 * 
	 * @param name
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T extends Object> T getJsonConfig(String name, Class<?> configClass) {
		String jsonString = getAsset(name, String.class);
		return (T) json.fromJson(configClass, jsonString);
	}

	/**
	 * Loads a music asset. After loading the asset will be cached by the asset
	 * manager.
	 * 
	 * @param name
	 * @return
	 */
	public Music getMusic(String name) {
		return getAsset(name, Music.class);
	}

	/**
	 * Loads a pixmap asset. After loading the asset will be cached by the asset
	 * manager.
	 * 
	 * @param name
	 * @return
	 */
	public Pixmap getPixmap(String name) {
		return getAsset(name, Pixmap.class);
	}

	/**
	 * Loads a region from atlas asset. After loading the asset will be cached by
	 * the asset manager.
	 * 
	 * @param name
	 * @return
	 */
	public AtlasRegion getRegion(String atlas, String region) {
		return getAtlas(atlas).findRegion(region);
	}

	/**
	 * Loads a skin asset. After loading the asset will be cached by the asset
	 * manager.
	 * 
	 * @param name
	 * @return
	 */
	public Skin getSkin(String name) {
		return getAsset(name, Skin.class);
	}

	/**
	 * Loads a sound asset. After loading the asset will be cached by the asset
	 * manager.
	 * 
	 * @param name
	 * @return
	 */
	public Sound getSound(String name) {
		return getAsset(name, Sound.class);
	}

	public Texture getTexture(String name) {
		return getAsset(name, Texture.class);

	}

	/**
	 * Initialize Class
	 */
	public void initialize() {
		dispose();

		// Renew loaders after dispose
		config.registerLoaders();
	}

	/**
	 * Loads an asset from the file system into asset manager.
	 * 
	 * @param classType
	 * @param name
	 */
	private void loadAsset(Class<?> classType, String name) {
		FileHandleResolver resolver = assetResolvers.get(classType);
		FileHandle assetFileHandle = resolver.resolve(name);
		CleverAssetLoader assetLoader = assetLoaders.get(classType);

		Object asset = assetLoader.loadAsset(assetFileHandle);
		getAssetMap(classType).put(name, asset);
	}

	/**
	 * Registers a new assetLoader
	 * 
	 * @param assetClass
	 * @param assetLoader
	 */
	void registerAssetLoader(Class<?> assetClass, CleverAssetLoader assetLoader) {
		assetLoaders.put(assetClass, assetLoader);
	}

	/**
	 * Registers a new assetResolver
	 * 
	 * @param assetClass
	 * @param assetResolver
	 */
	void registerAssetResolver(Class<?> assetClass, FileHandleResolver assetResolver) {
		assetResolvers.put(assetClass, assetResolver);
	}

	/**
	 * Unloads an asset managed by asset manager.
	 * 
	 * @param name
	 * @param assetClass
	 */
	private void unloadAsset(String name, Class<?> assetClass) {
		ObjectMap<String, Object> assetMap = getAssetMap(assetClass);
		Object asset = assetMap.get(name);

		if (asset != null) {
			assetMap.remove(name);

			if (asset instanceof Disposable) {
				((Disposable) asset).dispose();
			}
		}
	}

	/**
	 * Unloads an atlas asset.
	 * 
	 * @param name
	 */
	public void unloadAtlas(String name) {
		unloadAsset(name, TextureAtlas.class);
	}

	/**
	 * Unloads a font asset.
	 * 
	 * @param name
	 */
	public void unloadFont(String name) {
		unloadAsset(name, BitmapFont.class);
	}

	/**
	 * Unloads a I18NBundle asset.
	 * 
	 * @param name
	 */
	public void unloadI18NBundle(String name) {
		unloadAsset(name, I18NBundle.class);
	}

	/**
	 * Unloads a json config asset.
	 * 
	 * @param name
	 */
	public void unloadJsonConfig(String name) {
		unloadAsset(name, String.class);
	}

	/**
	 * Unloads a music asset.
	 * 
	 * @param name
	 */
	public void unloadMusic(String name) {
		unloadAsset(name, Music.class);
	}

	/**
	 * Unloads a pixmap asset.
	 * 
	 * @param name
	 */
	public void unloadPixmap(String name) {
		unloadAsset(name, Pixmap.class);
	}

	/**
	 * Unloads a skin asset.
	 * 
	 * @param name
	 */
	public void unloadSkin(String name) {
		unloadAsset(name, Skin.class);
	}

	/**
	 * Unloads a sound asset.
	 * 
	 * @param name
	 */
	public void unloadSound(String name) {
		unloadAsset(name, Sound.class);
	}

	/**
	 * Unloads a texture asset.
	 * 
	 * @param name
	 */
	public void unloadTexture(String name) {
		unloadAsset(name, Texture.class);
	}

}
