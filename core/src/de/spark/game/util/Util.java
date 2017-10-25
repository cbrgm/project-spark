package de.spark.game.util;

/**
 * @author Christian Bargmann <christian.bargmann@haw-hamburg.de>
 * @see de.spark.game.util
 * @since 16.10.2017 , 00:03:24
 *
 */
public class Util {

	/**
	 * Helper function that throws an IllegalArgumentException if one of the
	 * parameters is null.
	 * 
	 * @param objects
	 *            the paramters to
	 */
	public static void throwIfNull(Object... objects) {
		for (Object obj : objects) {
			if (obj == null) {
				throw new IllegalArgumentException();
			}
		}
	}

	public static void throwIfEmpty(String... strings) {
		for (String string : strings) {
			if (string != null && string.isEmpty()) {
				throw new IllegalArgumentException();
			}
		}
	}
}
