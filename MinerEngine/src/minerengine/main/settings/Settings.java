package minerengine.main.settings;

import minerengine.main.settings.message.Message;

public final class Settings {

	private Difficulty difficulty;
	private final Message message;
	private final int fpsMax;

	public Settings(final Difficulty difficulty, MessageType messageType, int fpsMax) {
		this.setDifficulty(difficulty);
		this.message = messageType.getMessage();
		this.fpsMax = fpsMax;
	}

	public final Difficulty getDifficulty() {
		return this.difficulty;
	}

	public final void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public final Message getMessage() {
		return this.message;
	}

	public int getFpsMax() {
		return this.fpsMax;
	}

}
