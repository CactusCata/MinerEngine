package minerengine.main.utils;

public class ArrayFiller {

	public static final <E> E[] fillAndGet(E[] array, E element) {
		for (int i = 0, j = array.length; i < j; i++)
			array[i] = element;
		return array;
	}

	public static final <E> E[][] fillAndGet(E[][] array, E element) {
		for (int w = 0, mw = array.length; w < mw; w++)
			for (int h = 0, mh = array[w].length; h < mh; h++)
				array[w][h] = element;
		return array;
	}

	public static final <E> E[] fillAndGet(E element, int size) {
		@SuppressWarnings("unchecked")
		E[] array = (E[]) new Object[size];
		for (int i = 0; i < size; i++) {
			array[i] = element;
		}
		return array;
	}

	public static final <E> void fill(E[] array, E element) {
		array = fillAndGet(array, element);
	}

}
