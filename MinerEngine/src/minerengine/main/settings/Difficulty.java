package minerengine.main.settings;

public enum Difficulty {

	PEACEFULL(0),
	EASY(70),
	MEDUIM(100),
	HARD(130),
	IMPOSSIBLE(200);

	private final int factor;

	private Difficulty(final int factor) {
		this.factor = factor;
	}

	public final int getFactor() {
		return this.factor;
	}

}
