package minerengine.main.gameplay.entity;

import java.util.UUID;

import minerengine.main.exceptions.SpawnedErrorException;
import minerengine.main.gameplay.entity.inventories.EntityInventory;
import minerengine.main.gameplay.entity.stats.Statistics;
import minerengine.main.gameplay.world.bloc.Block;
import minerengine.main.gameplay.world.location.Location;
import minerengine.main.utils.StringUtils;

public class Entity {

	private boolean spawn, dead;
	private String name;
	private final UUID uuid;
	private final Statistics statistics;
	private final EntityType entityType;
	private Location location;
	private final EntityInventory entityInventory = new EntityInventory();

	public Entity(EntityType entityType) {
		this(entityType, entityType.getRandomStats());
	}

	public Entity(EntityType entityType, Statistics statistics) {
		this.entityType = entityType;
		this.statistics = statistics;
		this.setName(StringUtils.capitalize(entityType.name()));
		this.uuid = UUID.randomUUID();
	}

	public final Statistics getStatistics() {
		return statistics;
	}

	public final EntityType getEntityType() {
		return entityType;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final Location getLocation() {
		return location;
	}

	public final void spawn(Location location) {
		this.spawn = true;
		location.getWorld().spawnEntity(this);
		setLocation(location);
	}

	public final Block getBlockInFrontOff() {
		return this.getLocation().getWorld().getBlocks()[this.getLocation().getX().getValue()][this.getLocation().getY()
				.getValue()];
	}

	public final void setLocation(Location location) {
		if (this.spawn)
			this.location = location;
		else
			throw new SpawnedErrorException("Entity " + this.entityType + " with ID:" + this.uuid
					+ " has not been added to the world previously, please spawn before.");
	}

	public final void walk() {

		switch (this.getLocation().getDirection()) {
		case NORTH:
			this.getLocation().getY().increment();
			return;
		case EAST:
			this.getLocation().getX().increment();
			break;
		case SOUTH:
			this.getLocation().getY().decrement();
			return;
		case WEST:
			this.getLocation().getX().decrement();
		}
	}

	public final boolean isDead() {
		return this.dead;
	}

	public void setDead() {
		this.dead = true;
		this.getLocation().getWorld().removeEntity(this);
	}

	public final void attack(Entity entity) {
		int entityDefense = entity.getStatistics().getDefense().getValue();
		int thisEntityAttack = this.getStatistics().getAttack().getValue();
		if (entityDefense - thisEntityAttack < 0) {
			entity.getStatistics().getHealth().addValue(entityDefense - thisEntityAttack);
			if (entity.getStatistics().getHealth().getValue() <= 0)
				setDead();
		}
	}

	public final EntityInventory getEntityInventory() {
		return entityInventory;
	}

	public final void dropLoot(Entity entity) {
		entity.getEntityInventory().addAll(this.getEntityInventory());
	}

}
