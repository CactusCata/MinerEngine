package minerengine.main.gameplay.entity;

import minerengine.main.game.Game;
import minerengine.main.gameplay.entity.stats.Statistics;

public enum EntityType {

	PLAYER(20, 20, 5, 2, 0),
	ZOMBIE(20, 20, 3, 3, 10),
	SKELETON(10, 10, 5, 0, 8),
	TROLL(50, 50, 4, 1, 15),
	GOBLIN(5, 5, 5, 2, 5),
	ROBOT(40, 40, 6, 5, 30);

	private final int healthAverage, maxHealthAverage, attackAverage, defenseAverage, experienceAdded;

	private EntityType(int healthAverage, int attackAverage, int defenseAverage) {
		this(healthAverage, healthAverage, attackAverage, defenseAverage);
	}

	private EntityType(int healthAverage, int maxHealthAverage, int attackAverage, int defenseAverage,
			int experienceAdded) {
		this.healthAverage = healthAverage;
		this.maxHealthAverage = maxHealthAverage;
		this.attackAverage = attackAverage;
		this.defenseAverage = defenseAverage;
		this.experienceAdded = experienceAdded;
	}

	private EntityType(int healthAverage, int maxHealthAverage, int attackAverage, int defenseAverage) {
		this(healthAverage, healthAverage, attackAverage, defenseAverage, 0);
	}

	public Statistics getRandomStats() {
		final int factor = Game.getInstance().getSettings().getDifficulty().getFactor();
		return new Statistics(factor * this.healthAverage / 100, factor * this.maxHealthAverage / 100,
				factor * this.attackAverage / 100, factor * this.defenseAverage / 100);
	}

	public int getExperienceAdded() {
		return this.experienceAdded;
	}
	
	public static String getEnumPathTexture() {
		return "mobs";
	}

}
