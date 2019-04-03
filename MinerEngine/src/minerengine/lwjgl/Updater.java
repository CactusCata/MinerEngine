package minerengine.lwjgl;

public class Updater {

	private int time;
	private boolean ticks = false;

	public void update() {
		this.setTime(this.getTime() + 1);
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public boolean isTicks() {
		return ticks;
	}

	public void setTicks(boolean ticks) {
		this.ticks = ticks;
	}

}
