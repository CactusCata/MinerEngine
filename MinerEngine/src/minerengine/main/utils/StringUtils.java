package minerengine.main.utils;

public final class StringUtils {

	public static final String capitalize(String string) {
		return string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();
	}

}
