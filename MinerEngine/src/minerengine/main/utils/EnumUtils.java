package minerengine.main.utils;

import java.util.Random;

public final class EnumUtils {

	public static final <T extends Enum<T>> T randomEnum(Class<T> clazz) {
		return getByID(clazz, new Random().nextInt(clazz.getEnumConstants().length));
	}

	public static final <T extends Enum<T>> T getByID(Class<T> clazz, int ID) {
		return clazz.getEnumConstants()[ID];
	}

	public static final <T extends Enum<T>> T getByName(Class<T> clazz, String name) {
		for (final T enumeration : clazz.getEnumConstants())
			if (StringUtils.capitalize(enumeration.name()).equals(name)
					|| StringUtils.capitalize(enumeration.toString()).equals(name))
				return enumeration;
		return null;
	}

}
