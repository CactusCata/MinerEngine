package minerengine.main.gameplay.entity.list.monster;

import minerengine.main.gameplay.entity.EntityType;
import minerengine.main.gameplay.entity.list.Monster;
import minerengine.main.gameplay.entity.stats.Statistics;

public final class Zombie extends Monster {

	public Zombie() {
		super(EntityType.ZOMBIE);
	}

	public Zombie(Statistics statistics) {
		super(EntityType.ZOMBIE, statistics);
	}

}
