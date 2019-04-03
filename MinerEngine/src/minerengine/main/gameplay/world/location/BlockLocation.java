package minerengine.main.gameplay.world.location;

public class BlockLocation {

	private final int x, y;

	public BlockLocation(final int x, final int y) {
		this.x = x;
		this.y = y;
	}

	public int getY() {
		return this.y;
	}

	public int getX() {
		return this.x;
	}

}
