package minerengine.main.game.actions;

public final class Running {

	private boolean running;

	public Running(boolean run) {
		this.setRunning(run);
	}

	public Running() {
		this(false);
	}

	public final boolean isRunning() {
		return running;
	}

	public final void setRunning(boolean running) {
		this.running = running;
	}

}
