package minerengine.main.gameplay.entity.list;

import minerengine.main.gameplay.entity.Entity;
import minerengine.main.gameplay.entity.EntityType;
import minerengine.main.gameplay.entity.stats.Statistics;

public class Monster extends Entity {

	public Monster(EntityType entityType) {
		super(entityType);
	}

	public Monster(EntityType entityType, Statistics statistics) {
		super(entityType, statistics);
	}

	public final int getExperienceAdded() {
		return super.getEntityType().getExperienceAdded();
	}

}
