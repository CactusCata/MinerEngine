package minerengine.main.gameplay.world.location;

import minerengine.main.gameplay.world.World;
import minerengine.main.utils.Modifier;

public final class Location {

	private World world;
	private final Modifier x, y;
	private Direction direction;

	public Location(World world, int x, int y, Direction direction) {
		this.setWorld(world);
		this.x = new Modifier(x);
		this.y = new Modifier(y);
		this.setDirection(direction);
	}

	public Location(World world, int x, int y) {
		this(world, x, y, Direction.NORTH);
	}

	public final Direction getDirection() {
		return this.direction;
	}

	public final void setDirection(Direction direction) {
		this.direction = direction;
	}

	public final Modifier getX() {
		return this.x;
	}

	public final Modifier getY() {
		return this.y;
	}

	public final World getWorld() {
		return this.world;
	}

	public final void setWorld(World world) {
		this.world = world;
	}

}
