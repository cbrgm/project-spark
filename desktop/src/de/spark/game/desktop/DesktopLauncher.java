package de.spark.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import de.spark.game.GameStartup;

/**
 * @author Christian Bargmann <christian.bargmann@haw-hamburg.de>
 * @version 14.10.2017
 * @see de.spark.game
 * @since 14.10.2017 , 22:04:08
 *
 */
public class DesktopLauncher {

	/**
	 * Game startup
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new GameStartup(), config);
		config.width = 800;
		config.height = 600;
	}

}
