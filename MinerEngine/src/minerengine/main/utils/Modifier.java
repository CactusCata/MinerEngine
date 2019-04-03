package minerengine.main.utils;

public class Modifier {

	private int value;

	public Modifier(int value) {
		this.setValue(value);
	}

	public Modifier(Modifier modifier) {
		this(modifier.getValue());
	}

	public final int getValue() {
		return this.value;
	}

	public final void setValue(int value) {
		this.value = value;
	}

	public final void addValue(int value) {
		this.setValue(this.getValue() + value);
	}

	public final void increment() {
		this.addValue(1);
	}

	public final void decrement() {
		this.removeValue(1);
	}

	public final void removeValue(int value) {
		this.setValue(this.getValue() - value > -1 ? this.getValue() - value : 0);
	}

	public final void resetValue() {
		this.setValue(0);
	}

}
